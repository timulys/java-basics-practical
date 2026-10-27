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
| 9강 · equals·hashCode·Set | [Main.java](lesson-09/src/main/java/study/javaorder/Main.java) · [Product.java](lesson-09/src/main/java/study/javaorder/Product.java) · [ProductCatalog.java](lesson-09/src/main/java/study/javaorder/ProductCatalog.java) |
| 10강 · 예외 처리 | [Main.java](lesson-10/src/main/java/study/javaorder/Main.java) · [OrderItem.java](lesson-10/src/main/java/study/javaorder/OrderItem.java) · [OrderService.java](lesson-10/src/main/java/study/javaorder/OrderService.java) · [Order.java](lesson-10/src/main/java/study/javaorder/Order.java) |
| 11강 · 인터페이스로 할인 규칙 교체 | [Main.java](lesson-11/src/main/java/study/javaorder/Main.java) · [DiscountPolicy.java](lesson-11/src/main/java/study/javaorder/DiscountPolicy.java) · [NoDiscountPolicy.java](lesson-11/src/main/java/study/javaorder/NoDiscountPolicy.java) · [ThresholdFixedDiscountPolicy.java](lesson-11/src/main/java/study/javaorder/ThresholdFixedDiscountPolicy.java) · [OrderService.java](lesson-11/src/main/java/study/javaorder/OrderService.java) |
| 12강 · JUnit 테스트 | [OrderServiceTest.java](lesson-12/src/test/java/study/javaorder/OrderServiceTest.java) · [OrderItemTest.java](lesson-12/src/test/java/study/javaorder/OrderItemTest.java) · [OrderSnapshotTest.java](lesson-12/src/test/java/study/javaorder/OrderSnapshotTest.java) |
| 13강 · 람다와 Stream 집계 | [Main.java](lesson-13/src/main/java/study/javaorder/Main.java) · [Cart.java](lesson-13/src/main/java/study/javaorder/Cart.java) · [CartAggregationTest.java](lesson-13/src/test/java/study/javaorder/CartAggregationTest.java) |
| 14강 · 주문 요약 파일 저장과 읽기 | [Main.java](lesson-14/src/main/java/study/javaorder/Main.java) · [ReceiptFileStore.java](lesson-14/src/main/java/study/javaorder/ReceiptFileStore.java) · [ReadReceipt.java](lesson-14/src/main/java/study/javaorder/ReadReceipt.java) |
| 15강 · 콘솔 주문 프로그램 통합 | [Main.java](lesson-15/src/main/java/study/javaorder/Main.java) · [ConsoleOrderApp.java](lesson-15/src/main/java/study/javaorder/ConsoleOrderApp.java) |

[전체 코드 ZIP 다운로드](https://github.com/timulys/java-basics-practical/archive/refs/heads/main.zip)

## 실행 방법

1. ZIP을 내려받아 압축을 풉니다.
2. IntelliJ에서 실습할 강의 폴더(`lesson-01`부터 `lesson-15`까지)를 엽니다.
3. 프로젝트 SDK와 Gradle JVM을 **Java 21**로 맞춘 뒤 `src/main/java/study/javaorder/Main.java`를 실행합니다.

1강은 상품 금액 **60000원**, 2강은 최종 금액 **55000원**, 3강과 4강은 최종 금액 **45000원**, 5강과 6강은 상품 금액 **75000원**과 최종 금액 **70000원**이 나옵니다. 6강은 참조·문자열 비교 결과와 null을 포함한 코드 입력 7개의 안내도 출력합니다. 7강도 기본 주문의 최종 금액은 70,000원이며, 확정·취소의 성공 여부와 거부 후 상태 유지를 출력합니다.

8강은 같은 상품의 수량을 합산하고 수량 변경·삭제 후 금액을 다시 계산합니다. 최종 장바구니에는 키보드 3개가 한 행으로 남으며 최종 금액은 85,000원입니다.

9강은 상품 코드 기준 equals·hashCode와 HashSet의 중복 처리를 확인합니다. 같은 코드의 카탈로그 재등록은 거부하고 기존 상품을 유지합니다.

10강은 잘못된 가격·수량·입력·주문 상태를 예외로 거부하고 기존 데이터를 유지합니다. 다음 정상 주문까지 이어서 실행합니다.

11강은 같은 60,000원 주문에 할인 없음과 기본 할인 구현을 전달해 최종 60,000원과 55,000원을 비교합니다. 마우스 추가 후 새 주문은 70,000원이며 기존 주문은 55,000원과 항목 1종류를 유지합니다.

12강은 JUnit 6.0.3으로 정상 계산, 할인 경계, 수량 0 거부와 주문 보존을 테스트합니다. `lesson-12` 안에서 `./gradlew test`를 실행하면 테스트 8개가 통과합니다. Windows는 `gradlew.bat test` 또는 `.\gradlew.bat test`를 사용합니다.

13강은 반복문과 Stream으로 주변기기 합계 **45,000원**을 구합니다. 문구 합계는 **10,000원**, 일치 상품이 없는 가전 합계는 **0원**입니다. 집계 전후 전체 상품 금액은 **55,000원**으로 유지됩니다. `lesson-13`에서 `./gradlew test`를 실행하면 기존 검증을 포함한 테스트 **16개**가 통과합니다.

14강은 주문 요약을 UTF-8 텍스트 파일로 저장합니다. `lesson-14`에서 `./gradlew -q run`으로 저장한 뒤 `./gradlew -q readReceipt`를 실행하면 이전 요약을 읽습니다. 최종 금액은 **70,000원**이며 테스트 **24개**가 통과합니다. 저장 대상은 요약 문자열입니다.

15강은 `./gradlew -q --console=plain run`으로 메뉴를 실행합니다. 상품 코드와 수량을 한 줄씩 입력하고, 키보드 2개와 마우스 1개를 확정하면 최종 금액은 **70,000원**입니다. `./gradlew test`로 테스트 **31개**를 확인할 수 있습니다.

터미널에서는 실행할 강의 폴더 안에서 `./gradlew -q run`을 사용합니다. Windows 명령 프롬프트는 `gradlew.bat -q run`, PowerShell은 `.\gradlew.bat -q run`을 사용합니다. Gradle은 프로젝트에 포함되어 있습니다. 처음 실행할 때는 인터넷 연결이 필요합니다.

Gradle Wrapper의 라이선스는 각 프로젝트의 `gradle/wrapper/LICENSE.txt`에 있습니다.
