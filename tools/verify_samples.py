#!/usr/bin/env python3
"""Compile isolated teaching samples and compare explicit expected results (JDK 21)."""
import argparse
import difflib
import hashlib
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCE = Path('src/main/java/study/javaorder/Main.java')


def command(args, cwd=None):
    result = subprocess.run(
        [str(x) for x in args], cwd=cwd, capture_output=True,
        text=True, encoding='utf-8', errors='replace', timeout=240,
    )
    return result.returncode, result.stdout.replace('\r\n', '\n'), result.stderr.replace('\r\n', '\n')


def java_tool(name):
    home = os.environ.get('JAVA_HOME')
    if home:
        tool = Path(home) / 'bin' / (name + ('.exe' if os.name == 'nt' else ''))
        if tool.is_file():
            return str(tool)
        raise RuntimeError('JAVA_HOME does not contain ' + name)
    tool = shutil.which(name)
    if not tool:
        raise RuntimeError('JDK 21 is required; set JAVA_HOME or add its bin directory to PATH.')
    return tool


def relative_path(value):
    path = (ROOT / value).resolve()
    path.relative_to(ROOT)
    return path


def check_versions():
    java, javac = java_tool('java'), java_tool('javac')
    for tool in [java, javac]:
        code, stdout, stderr = command([tool, '-version'])
        output = stdout + stderr
        if code != 0 or not re.search(r'(?:version\s+"|javac\s+)21(?:[.\s"+-]|$)', output):
            raise RuntimeError('Expected JDK 21, received: ' + output.strip())
    return java, javac


def verify_case(case, java, javac):
    source = relative_path(case['source'])
    text = source.read_text(encoding='utf-8')
    replacement = case.get('replaceFirst')
    if replacement:
        if replacement['old'] not in text:
            raise RuntimeError('Missing fixture anchor: ' + case['id'])
        text = text.replace(replacement['old'], replacement['new'], 1)
    record = {'id': case['id'], 'source': case['source'],
              'sourceSha256': hashlib.sha256(source.read_bytes()).hexdigest(),
              'effectiveSourceSha256': hashlib.sha256(text.encode('utf-8')).hexdigest()}
    with tempfile.TemporaryDirectory(prefix='java-basics-check-') as temp:
        temp = Path(temp)
        effective = temp / 'Main.java'
        effective.write_text(text, encoding='utf-8')
        code, stdout, stderr = command([
            javac, '-XDrawDiagnostics', '--release', '21', '-encoding', 'UTF-8',
            '-d', temp, effective,
        ])
        record.update(compileExitCode=code, compileDiagnostics=stderr)
        if case.get('compileErrorContains'):
            passed = code != 0 and case['compileErrorContains'] in stderr
            record.update(result='PASS' if passed else 'FAIL', intentionalCompileError=True)
            return record
        if code != 0:
            record.update(result='FAIL', error='Unexpected compile failure')
            return record
        code, stdout, stderr = command([
            java, '-Dfile.encoding=UTF-8', '-cp', temp, 'study.javaorder.Main',
        ])
        expected = relative_path(case['expectedOutput']).read_text(encoding='utf-8')
        passed = code == 0 and stdout == expected
        record.update(result='PASS' if passed else 'FAIL', runExitCode=code,
                      stdout=stdout, stderr=stderr, expectedStdout=expected)
        if not passed:
            record['diff'] = ''.join(difflib.unified_diff(
                expected.splitlines(True), stdout.splitlines(True),
                fromfile='expected', tofile='actual',
            ))
        return record


def verify_gradle(case):
    project = relative_path(case['gradleProject'])
    if os.name == 'nt':
        args = [os.environ.get('COMSPEC', 'cmd.exe'), '/d', '/c', 'gradlew.bat']
    else:
        args = ['./gradlew']
    args += ['--no-daemon', '--console=plain', '-q', 'run']
    code, stdout, stderr = command(args, cwd=project)
    expected = relative_path(case['expectedOutput']).read_text(encoding='utf-8')
    return {'project': case['gradleProject'], 'exitCode': code,
            'stdout': stdout, 'stderr': stderr, 'expectedStdout': expected,
            'result': 'PASS' if code == 0 and stdout == expected else 'FAIL'}


def main():
    cases = json.loads((ROOT / 'verification/cases.json').read_text(encoding='utf-8'))['cases']
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--with-gradle', action='store_true')
    parser.add_argument('--lesson', choices=sorted({case['lesson'] for case in cases}))
    args = parser.parse_args()
    java, javac = check_versions()
    if args.lesson:
        cases = [case for case in cases if case['lesson'] == args.lesson]
    all_sources = {str(p.relative_to(ROOT)) for p in (ROOT / 'lessons').rglob('*.java')
                   if not any(part in ['build', '.gradle'] for part in p.parts)
                   and (not args.lesson or args.lesson in p.parts)}
    if all_sources != {case['source'] for case in cases}:
        raise RuntimeError('Verification cases do not cover exactly the published Java sources.')
    runs, gradle = [], []
    for case in cases:
        result = verify_case(case, java, javac)
        runs.append(result)
        print(result['result'] + ': ' + case['id'], flush=True)
    if args.with_gradle:
        for case in cases:
            if 'gradleProject' in case:
                result = verify_gradle(case)
                gradle.append(result)
                print(result['result'] + ': Gradle ' + case['gradleProject'], flush=True)
    passed = all(r['result'] == 'PASS' for r in runs + gradle)
    report = {'result': 'PASS' if passed else 'FAIL', 'javaRelease': 21,
              'caseCount': len(runs),
              'intentionalCompileErrorCount': sum(bool(r.get('intentionalCompileError')) for r in runs),
              'gradleProjectCount': len(gradle), 'runs': runs, 'gradle': gradle}
    output = ROOT / '.verification/results.json'
    output.parent.mkdir(exist_ok=True)
    output.write_text(json.dumps(report, ensure_ascii=False, indent=2) + '\n', encoding='utf-8')
    print(f"{report['result']}: {len(runs)} Java cases, {len(gradle)} Gradle project runs.")
    return 0 if passed else 1


if __name__ == '__main__':
    try:
        sys.exit(main())
    except (RuntimeError, OSError, subprocess.TimeoutExpired) as error:
        print('Verification failed: ' + str(error), file=sys.stderr)
        sys.exit(1)
