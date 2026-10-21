# 1강 실습 코드 실행 안내

Java 21을 사용합니다. 네 프로젝트 중 필요한 폴더 하나를 IntelliJ에서 열어 실행하시면 됩니다.

| 폴더 | 용도 |
|---|---|
| start | main 안에 상품 정보와 계산을 작성하는 시작 코드 |
| complete | 수량 2와 상품 금액 60000원을 출력하는 완성 코드 |
| exercise | 배송비와 최종 금액을 추가하는 과제 코드 |
| solution | 배송비 3000원과 최종 금액 63000원을 출력하는 해답 |

## IntelliJ 실행

1. File의 Open에서 start 또는 complete 폴더를 엽니다.
2. Project Structure의 Project SDK를 Java 21로 선택합니다.
3. Gradle 가져오기가 끝나면 src/main/java/study/javaorder/Main.java를 엽니다.
4. main 옆의 실행 표시를 누르고 출력창을 확인합니다.

컴파일과 실행에 모두 Java 21을 사용합니다.

## 터미널 실행

열어 둔 프로젝트 폴더 안에서 실행합니다.

```sh
./gradlew run
```

Windows 명령 프롬프트에서는 다음 명령을 사용합니다.

```bat
gradlew.bat run
```

Wrapper 버전은 9.2.1로 고정했고 공식 배포 파일의 SHA-256을 설정했습니다. 처음 실행할 때에는 Gradle 배포 파일을 내려받을 수 있습니다. 자바 소스와 출력은 UTF-8을 사용합니다. 이 강의의 실제 실행 검증 환경은 macOS입니다.

## 기본 완성 코드의 출력

```text
상품: 키보드
단가: 30000원
수량: 2
판매 가능: true
상품 금액: 60000원
```

수량을 처음 저장하는 줄에서 2를 3으로 바꾼 뒤 다시 실행하면 상품 금액은 90000원입니다.

## 중간 체크포인트

checkpoints 폴더의 Main.java는 설명할 상태를 보관한 단일 소스 파일입니다. 각 파일에는 같은 패키지 이름이 있으므로, 한 번에 하나만 실습 프로젝트의 Main.java 위치로 복사해 확인합니다. 여러 체크포인트를 하나의 프로젝트 소스 폴더에 함께 넣지 않습니다.

| 이름 | 확인할 내용 |
|---|---|
| 01-variables-only | 이름·가격·수량을 출력 |
| 01a-calculate | 처음 상품 금액 60000원을 계산 |
| 02-quantity-three | 처음 수량 3으로 계산해 90000원 |
| 03-stale-subtotal | 계산 뒤 수량만 바꾸면 금액은 60000원 |
| 04-recalculated | 수량 변경 뒤 다시 계산하면 90000원 |
| 05-next-quantity-text | 문자열 연결 결과 21 |
| 06-next-quantity-number | 괄호 안에서 숫자를 더한 결과 3 |
| 07a-available | boolean 상태를 추가해 출력 |
| 07-unavailable | false로 바꿔도 현재 계산식은 실행 |
| 08-final-reassignment-error | final 변수 재대입으로 의도한 컴파일 오류 |
| 09-int-string-error | int에 문자열을 넣어 의도한 컴파일 오류 |
| 10-type-mismatch-error | long 값을 int에 바로 대입하는 추가 오류 예제 |
| 11-quantity-four | 수량 4의 상품 금액 120000원 |
| 12-solution-three | 수량 3의 과제 최종 금액 93000원 |
| 13-product-mouse | 상품 이름을 마우스로 바꾸어 출력 |

오류 예제는 정상 실행용 완성 코드에 들어 있지 않습니다. 오류를 확인한 뒤에는 complete의 Main.java로 복구합니다.

## 관련 안내

[체크포인트 실행 방법](../../../docs/checkpoints.md) · [배포본 전체 검증](../../../docs/verification.md)
