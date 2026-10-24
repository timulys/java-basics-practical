# 7강 enum으로 주문 상태 표현하기

Java 21로 Main.java를 실행합니다. IntelliJ에서 이 폴더를 열거나 터미널에서 ./gradlew -q run을 사용하세요. Gradle Wrapper 9.2.1이 포함돼 있습니다. Windows 명령 프롬프트에서는 gradlew.bat -q run, PowerShell에서는 .\gradlew.bat -q run을 실행합니다.

OrderStatus.java는 DRAFT·CONFIRMED·CANCELLED를 정의합니다. Order.java는 현재 상태와 confirm·cancel의 허용 조건을 관리합니다. Main.java는 기본 금액과 상태 변경 결과를 출력합니다. Product.java와 OrderItem.java는 앞선 강의의 상품과 수량을 유지합니다.

DRAFT는 확정·취소가 가능합니다. CONFIRMED의 재확정은 거부하며 취소는 가능합니다. CANCELLED에서 확정·재취소는 거부되고 상태를 유지합니다. 기본 주문 금액은 75,000원, 할인 5,000원, 배송비 0원, 최종 금액 70,000원입니다.
