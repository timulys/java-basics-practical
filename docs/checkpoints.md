# 영상 중간의 코드 실행하기

각 강의의 `code/checkpoints`에는 영상에서 설명한 단계별 `Main.java`가 있습니다. 각 파일은 같은 패키지와 클래스 이름을 사용합니다.

1. IntelliJ에서 해당 강의의 `code/complete`를 엽니다.
2. 직접 수정한 코드가 있다면 먼저 별도로 저장합니다.
3. 실행할 체크포인트의 `Main.java` 내용을 전부 복사합니다.
4. 열린 프로젝트의 `src/main/java/study/javaorder/Main.java` 내용을 복사한 코드로 교체합니다.
5. `main`을 실행하고 `code/expected/<체크포인트 이름>.txt`와 출력을 비교합니다.
6. 확인이 끝나면 원래 `complete`의 `Main.java`로 복구합니다.

여러 체크포인트 파일을 `src/main/java`에 함께 넣으면 `Main` 클래스가 중복되어 컴파일 오류가 납니다. 한 번에 하나씩 교체해 확인해주세요.

## 의도한 오류 예제

1강의 다음 세 예제는 컴파일 오류를 확인하는 코드입니다. 해당 예제에는 정상 출력 파일이 없습니다.

| 체크포인트 | 확인할 내용 |
|---|---|
| `08-final-reassignment-error` | final 변수에 값을 다시 넣으면 컴파일 오류가 납니다. |
| `09-int-string-error` | int 변수에 문자열을 넣으면 컴파일 오류가 납니다. |
| `10-type-mismatch-error` | long 값을 int 변수에 바로 넣으면 컴파일 오류가 납니다. |

2강의 `08-exclusive-boundary-bug`, `09-discounted-shipping-bug`, `20-menu-missing-break`는 컴파일되지만 의도와 다른 결과가 나오는 예제입니다. 예상 출력 파일에도 그 잘못된 결과를 기록했습니다. 기본 완성 코드와 비교하면서 원인을 확인해주세요.

2강의 경계값 예제는 `subtotal`에 검증할 상품 금액을 직접 넣습니다. 키보드의 기본 단가를 바꾸지 않아도 49,999원·50,000원·69,999원·70,000원을 비교할 수 있습니다.
