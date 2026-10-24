# 실무에서 바로 쓸 수 있는 자바 기초 강의

각 강의의 최종 완성 코드입니다.

| 강의 | 완성 코드 |
|---|---|
| 1강 · 변수와 자료형 | [Main.java 보기](lesson-01/src/main/java/study/javaorder/Main.java) |
| 2강 · 조건문 | [Main.java 보기](lesson-02/src/main/java/study/javaorder/Main.java) |
| 3강 · 배열과 반복문 | [Main.java 보기](lesson-03/src/main/java/study/javaorder/Main.java) |
| 4강 · 메서드와 디버깅 | [Main.java 보기](lesson-04/src/main/java/study/javaorder/Main.java) |
| 5강 · 클래스와 객체 | [Main.java](lesson-05/src/main/java/study/javaorder/Main.java) · [Product.java](lesson-05/src/main/java/study/javaorder/Product.java) · [OrderItem.java](lesson-05/src/main/java/study/javaorder/OrderItem.java) |
| 6강 · 참조·문자열·null | [Main.java](lesson-06/src/main/java/study/javaorder/Main.java) · [Product.java](lesson-06/src/main/java/study/javaorder/Product.java) · [OrderItem.java](lesson-06/src/main/java/study/javaorder/OrderItem.java) |
| 7강 · enum과 주문 상태 | [Main.java](lesson-07/src/main/java/study/javaorder/Main.java) · [OrderStatus.java](lesson-07/src/main/java/study/javaorder/OrderStatus.java) · [Order.java](lesson-07/src/main/java/study/javaorder/Order.java) |
| 8강 · List·Map과 장바구니 | [Main.java](lesson-08/src/main/java/study/javaorder/Main.java) · [Cart.java](lesson-08/src/main/java/study/javaorder/Cart.java) · [ProductCatalog.java](lesson-08/src/main/java/study/javaorder/ProductCatalog.java) |

[전체 코드 ZIP 다운로드](https://github.com/timulys/java-basics-practical/archive/refs/heads/main.zip)

## 실행 방법

1. ZIP을 내려받아 압축을 풉니다.
2. IntelliJ에서 실습할 강의 폴더(`lesson-01`부터 `lesson-08`까지)를 엽니다.
3. 프로젝트 SDK와 Gradle JVM을 **Java 21**로 맞춘 뒤 `src/main/java/study/javaorder/Main.java`를 실행합니다.

1강은 상품 금액 **60000원**, 2강은 최종 금액 **55000원**, 3강과 4강은 최종 금액 **45000원**, 5강과 6강은 상품 금액 **75000원**과 최종 금액 **70000원**이 나옵니다. 6강은 참조·문자열 비교 결과와 null을 포함한 코드 입력 7개의 안내도 출력합니다. 7강도 기본 주문의 최종 금액은 70,000원이며, 확정·취소의 성공 여부와 거부 후 상태 유지를 출력합니다.

8강은 같은 상품의 수량을 합산하고 수량 변경·삭제 후 금액을 다시 계산합니다. 최종 장바구니에는 키보드 3개가 한 행으로 남으며 최종 금액은 85,000원입니다.

터미널에서는 실행할 강의 폴더 안에서 `./gradlew -q run`을 사용합니다. Windows 명령 프롬프트는 `gradlew.bat -q run`, PowerShell은 `.\gradlew.bat -q run`을 사용합니다. Gradle은 프로젝트에 포함되어 있습니다. 처음 실행할 때는 인터넷 연결이 필요합니다.

Gradle Wrapper의 라이선스는 각 프로젝트의 `gradle/wrapper/LICENSE.txt`에 있습니다.
