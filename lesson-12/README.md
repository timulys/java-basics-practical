# 12강 JUnit으로 계산 결과 검증하기

Java 21, Gradle Wrapper 9.2.1, JUnit 6.0.3을 사용합니다. IntelliJ에서 이 폴더를 열고 Gradle 프로젝트로 불러옵니다. 테스트는 ./gradlew test, 주문 예제는 ./gradlew run으로 실행합니다.

완성 프로젝트는 테스트 8개를 포함합니다. src/test/java에서 경계 금액, 할인 규칙 교체, 수량 0 거부, 잘못된 변경 뒤 수량 보존, 확정 주문의 보존을 확인합니다. src/main/java의 업무 코드는 11강의 완성 코드와 같습니다. 제공한 Gradle 설정은 테스트 라이브러리를 연결하는 설정입니다.
