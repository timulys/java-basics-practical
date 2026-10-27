# 13강 람다와 Stream으로 조회·집계하기

Java 21, Gradle Wrapper 9.2.1, JUnit 6.0.3을 사용합니다. IntelliJ에서 이 폴더를 열고 Project SDK를 Java 21로 지정한 뒤 Gradle 동기화를 마치고 Main.main을 실행하세요. 터미널에서는 ./gradlew run, 테스트는 ./gradlew test로 실행합니다.

키보드 1개·마우스 1개·노트 2개의 전체 상품 금액은 55,000원입니다. 반복문과 Stream의 주변기기 합계는 모두 45,000원, 문구 합계는 10,000원이며 일치하는 항목이 없으면 합계는 0원입니다. 집계 전후 항목 수량과 순서는 같습니다.

Cart.java에서 반복문과 filter → mapToLong → sum 처리를 비교할 수 있습니다. 카테고리는 전달한 문자열과 정확히 비교하며 null이나 공백만 있는 조회는 거부합니다. src/test/java의 테스트 16개로 기존 주문 동작, 집계 금액, 빈 결과와 장바구니 보존을 확인합니다.
