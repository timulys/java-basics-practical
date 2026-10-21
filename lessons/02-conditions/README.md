# 2강. 조건문으로 할인과 주문 조건 처리하기

상품 금액에 따라 할인과 배송비를 선택하고 판매 상태·수량·메뉴 번호에 맞는 안내를 출력합니다.

[강의 ZIP 다운로드](https://github.com/timulys/java-basics-practical/releases/download/lesson-02-v1.0/lesson-02-conditions-v1.0.zip) · [전체 강의로 돌아가기](../../README.md)

## 실습 순서

1. IntelliJ에서 [code/start](code/start)를 열고 Java 21로 실행합니다.
2. 강의를 따라 코드를 수정하고, 결과가 궁금하면 [완성 코드](code/complete/src/main/java/study/javaorder/Main.java)와 비교합니다.
3. [과제](exercise.md)를 읽고 `code/exercise`에서 직접 풀어봅니다.
4. 풀이를 마친 뒤 [해설](solution.md)과 [해답 코드](code/solution/src/main/java/study/javaorder/Main.java)를 확인합니다.

| 프로젝트 | 코드 바로 보기 | 기본 실행 결과 |
|---|---|---|
| 시작 | [Main.java](code/start/src/main/java/study/javaorder/Main.java) | 상품 금액: 60000원 |
| 완성 | [Main.java](code/complete/src/main/java/study/javaorder/Main.java) | 최종 금액: 55000원 |
| 과제 시작 | [Main.java](code/exercise/src/main/java/study/javaorder/Main.java) | 최종 금액: 55000원 |
| 과제 해답 | [Main.java](code/solution/src/main/java/study/javaorder/Main.java) | 최종 금액: 58000원 |

실행 방법과 단계별 예제 목록은 [코드 안내](code/README.md)에 있습니다. 터미널을 사용하시면 실행할 프로젝트 폴더에서 macOS·Linux는 `./gradlew -q run`, Windows 명령 프롬프트는 `gradlew.bat -q run`, PowerShell은 `.\gradlew.bat -q run`을 실행합니다.

기본 완성 코드는 할인과 무료배송 모두 50,000원 기준입니다. 과제 해답은 무료배송 기준만 70,000원으로 바꾼 코드입니다. 3강은 기본 완성 코드에서 시작합니다.
