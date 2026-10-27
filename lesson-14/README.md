# 14강 주문 요약을 파일로 저장하고 읽기

Java 21, Gradle Wrapper 9.2.1, JUnit 6.0.3을 사용합니다. 이 폴더에서 ./gradlew run으로 주문 요약을 data/latest-order.txt에 저장합니다. ./gradlew readReceipt는 새 실행에서 이전에 저장한 텍스트를 읽습니다. IntelliJ에서는 Main.java와 ReadReceipt.java를 각각 실행하시면 됩니다.

저장 경로는 프로젝트 작업 디렉터리를 기준으로 합니다. Main 실행 화면에서 절대 경로를 확인하실 수 있습니다. 새 저장은 이전 요약을 UTF-8로 덮어씁니다. Order 객체를 복원하는 기능은 포함하지 않습니다.

./gradlew test로 기존 테스트 16개와 파일·요약 테스트 8개를 실행합니다.
