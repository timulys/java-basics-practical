# 실무에서 바로 쓸 수 있는 자바 기초 강의

각 강의의 최종 완성 코드입니다.

| 강의 | 완성 코드 |
|---|---|
| 1강 · 변수와 자료형 | [Main.java 보기](lesson-01/src/main/java/study/javaorder/Main.java) |
| 2강 · 조건문 | [Main.java 보기](lesson-02/src/main/java/study/javaorder/Main.java) |
| 3강 · 배열과 반복문 | [Main.java 보기](lesson-03/src/main/java/study/javaorder/Main.java) |

[전체 코드 ZIP 다운로드](https://github.com/timulys/java-basics-practical/archive/refs/heads/main.zip)

## 실행 방법

1. ZIP을 내려받아 압축을 풉니다.
2. IntelliJ에서 실습할 강의 폴더(`lesson-01`, `lesson-02`, `lesson-03`)를 엽니다.
3. 프로젝트 SDK와 Gradle JVM을 **Java 21**로 맞춘 뒤 `src/main/java/study/javaorder/Main.java`를 실행합니다.

1강은 상품 금액 **60000원**, 2강은 최종 금액 **55000원**, 3강은 최종 금액 **45000원**이 나옵니다.

터미널에서는 실행할 강의 폴더 안에서 `./gradlew -q run`을 사용합니다. Windows 명령 프롬프트는 `gradlew.bat -q run`, PowerShell은 `.\gradlew.bat -q run`을 사용합니다. Gradle은 프로젝트에 포함되어 있습니다. 처음 실행할 때는 인터넷 연결이 필요합니다.

Gradle Wrapper의 라이선스는 각 프로젝트의 `gradle/wrapper/LICENSE.txt`에 있습니다.
