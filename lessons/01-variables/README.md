# 1강. 변수와 자료형으로 상품 정보 다루기

상품 이름·단가·수량·판매 상태를 변수에 저장하고 상품 금액을 계산합니다.

[강의 ZIP 다운로드](https://github.com/timulys/java-basics-practical/releases/download/lesson-01-v1.0/lesson-01-variables-v1.0.zip) · [전체 강의로 돌아가기](../../README.md)

## 실습 순서

1. IntelliJ에서 [code/start](code/start)를 열고 Java 21로 실행합니다.
2. 강의를 따라 코드를 수정하고, 결과가 궁금하면 [완성 코드](code/complete/src/main/java/study/javaorder/Main.java)와 비교합니다.
3. [과제](exercise.md)를 읽고 `code/exercise`에서 직접 풀어봅니다.
4. 풀이를 마친 뒤 [해설](solution.md)과 [해답 코드](code/solution/src/main/java/study/javaorder/Main.java)를 확인합니다.

| 프로젝트 | 코드 바로 보기 | 기본 실행 결과 |
|---|---|---|
| 시작 | [Main.java](code/start/src/main/java/study/javaorder/Main.java) | 출력 없음 |
| 완성 | [Main.java](code/complete/src/main/java/study/javaorder/Main.java) | 상품 금액: 60000원 |
| 과제 시작 | [Main.java](code/exercise/src/main/java/study/javaorder/Main.java) | 상품 금액: 60000원 |
| 과제 해답 | [Main.java](code/solution/src/main/java/study/javaorder/Main.java) | 최종 금액: 63000원 |

실행 방법과 단계별 예제 목록은 [코드 안내](code/README.md)에 있습니다. 터미널을 사용하시면 실행할 프로젝트 폴더에서 macOS·Linux는 `./gradlew -q run`, Windows 명령 프롬프트는 `gradlew.bat -q run`, PowerShell은 `.\gradlew.bat -q run`을 실행합니다.

1강의 배송비 과제 해답과 기본 완성 코드는 구분합니다. 2강은 상품 금액만 계산한 기본 완성 코드에서 시작합니다.
