# 배포본 코드 검증

이 도구는 공개된 시작·완성·과제·해답과 모든 체크포인트를 컴파일하고, 명시한 예상 출력과 실제 출력을 비교합니다. 경계값과 수량 변경 예제도 확인합니다. 컴파일 오류를 가르치는 세 예제는 지정한 오류가 발생해야 통과합니다.

JDK 21과 Python 3.9 이상이 필요합니다. 실습 코드만 실행하실 때는 Python을 설치하지 않으셔도 됩니다. 아래 명령은 저장소 최상위 폴더에서 실행합니다.

```sh
python3 tools/verify_samples.py --with-gradle
```

Windows에서 Python 실행 명령이 `py`라면 `py -3 tools/verify_samples.py --with-gradle`을 사용합니다.

Java와 javac는 `JAVA_HOME`의 JDK를 사용하며, `JAVA_HOME`이 없으면 PATH에서 찾습니다. 두 명령 모두 버전 21이어야 합니다. `--with-gradle`은 여덟 Gradle 프로젝트의 실제 실행 결과까지 비교합니다. 처음 실행할 때는 Gradle 배포 파일을 내려받습니다.

빠르게 Java 소스만 확인하려면 `--with-gradle`을 생략합니다. 한 강의만 확인하려면 `--lesson 01-variables` 또는 `--lesson 02-conditions`를 덧붙입니다.

검증 과정은 임시 폴더에서 컴파일하므로 원본 Java 파일을 수정하지 않습니다. 결과는 `.verification/results.json`에 저장합니다. 과제를 직접 수정하신 뒤에는 배포 당시의 예상 출력과 달라 일부 검사가 실패할 수 있습니다. 과제 채점은 각 강의의 `exercise.md`에 있는 기준을 확인해주세요.
