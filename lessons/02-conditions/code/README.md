# 2강 실습 코드

Java 21과 Gradle Wrapper 9.2.1을 사용합니다. IntelliJ IDEA에서는 프로젝트 폴더를 열고 Gradle JVM과 프로젝트 SDK를 Java 21로 맞춘 뒤 `src/main/java/study/javaorder/Main.java`를 실행합니다. macOS 기준으로 `./gradlew -q run`, Windows에서는 `gradlew.bat -q run`도 사용할 수 있습니다. Wrapper를 처음 실행할 때에는 공식 Gradle 배포 파일을 내려받습니다.

## 프로젝트 선택

| 폴더 | 용도 | 기본 실행 결과 |
|---|---|---|
| start | 1강 기본 완성 코드에서 시작 | 상품 금액 60000원 |
| complete | 2강 기본 정책과 안내 예제 | 최종 금액 55000원 |
| exercise | 무료배송 기준 변경 과제 시작 | 수정 전 최종 금액 55000원 |
| solution | 무료배송 기준 70000원 해답 | 최종 금액 58000원 |

각 폴더는 독립적으로 열 수 있는 Gradle 프로젝트입니다. `start`의 Main.java는 1강 기본 완성 코드와 같습니다. 상품 단가 30000원과 수량 2를 유지하며, 과제 해답은 기본 완성 코드와 구분합니다.

## 설명용 체크포인트

`checkpoints/<이름>/Main.java`는 설명 중 잠시 실행할 코드입니다. 실행할 프로젝트의 Main.java 내용을 해당 파일의 내용으로 교체한 뒤 실행합니다. 파일의 패키지와 클래스 이름은 같습니다. 여러 Main.java를 한 프로젝트의 소스 폴더에 동시에 넣지 마세요. 확인 후 기본 `complete`의 Main.java 내용으로 복구합니다.

| 체크포인트 | 확인 내용 |
|---|---|
| 01-fixed-shipping | 고정 배송비 복습, 63000원 |
| 02-comparison-results | 숫자 비교의 true·false |
| 03-discount-only | 할인만 먼저 반영, 58000원 |
| 04-pricing | 할인과 무료배송, 55000원 |
| 05~07-boundary | 49999·50000·60000원 금액 검증 |
| 08-exclusive-boundary-bug | 의도한 > 오류, 50000원 주문이 53000원 |
| 09-discounted-shipping-bug | 할인 후 금액 비교 오류, 최종 48000원 |
| 10~12-and | 판매 상태와 수량의 && 조건 |
| 13-not-unavailable | !로 조건 결과 반전 |
| 14~16-or | 판매 불가 또는 0 이하 수량의 \|\| 조건 |
| 17~19-menu | 메뉴 1·2·9의 안내 |
| 20-menu-missing-break | 의도한 break 누락, 메뉴 1에서 두 줄 출력 |
| 21~22-exercise | 과제의 60000원과 70000원 입력 |
| 23-first-switch-case | switch와 case 하나로 메뉴 1 안내 |

bug 체크포인트는 실행은 되지만 정책이나 메뉴 의도와 다른 결과를 보여줍니다. 정상 정책으로 사용하지 마세요. 경계값 예제에는 상품 정보 대신 검증용 subtotal을 직접 넣으므로 기본 상품 가격을 바꿀 필요가 없습니다.

## 관련 안내

[체크포인트 실행 방법](../../../docs/checkpoints.md) · [배포본 전체 검증](../../../docs/verification.md)
