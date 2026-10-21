# 실무에서 바로 쓸 수 있는 자바 기초 강의

안녕하세요. 개발자 팀입니다.

강의에서 만든 코드를 직접 실행하고 수정해볼 수 있는 실습 저장소입니다. 작은 상점의 주문 프로그램을 만들면서 자바 기초를 익힙니다. 전체 과정은 0강 과정 소개와 15개의 실습 강의로 구성되며, 현재 1·2강 코드를 제공합니다.

## 강의별 실습

| 강의 | 내용 | 실습 안내 | ZIP 다운로드 |
|---|---|---|---|
| 1강 | 변수와 자료형으로 상품 정보 다루기 | [1강 열기](lessons/01-variables/README.md) | [1강 ZIP](https://github.com/timulys/java-basics-practical/releases/download/lesson-01-v1.0/lesson-01-variables-v1.0.zip) |
| 2강 | 조건문으로 할인과 주문 조건 처리하기 | [2강 열기](lessons/02-conditions/README.md) | [2강 ZIP](https://github.com/timulys/java-basics-practical/releases/download/lesson-02-v1.0/lesson-02-conditions-v1.0.zip) |

[전체 커리큘럼](docs/curriculum.md)에서 앞으로 다룰 주제를 확인하실 수 있습니다. 다음 강의의 코드는 제작과 검증을 마친 뒤 추가합니다.

## 처음 시작하시는 분께

1. 위 표에서 들으실 강의의 ZIP을 받아 압축을 풉니다.
2. JDK 21을 준비하고 IntelliJ IDEA를 실행합니다.
3. IntelliJ의 **File → Open**에서 해당 강의의 `code/start` 폴더를 엽니다. 저장소 전체를 하나의 Gradle 프로젝트로 열지 않습니다.
4. 프로젝트 SDK와 Gradle JVM을 모두 Java 21로 선택하고 Gradle 동기화를 마칩니다.
5. `src/main/java/study/javaorder/Main.java`를 열어 `main` 왼쪽 실행 버튼을 누릅니다.

강의를 따라 작성하려면 `start`, 완성 결과를 먼저 확인하려면 `complete`를 여시면 됩니다. 1강의 `start`에는 작성할 코드의 틀만 있습니다. 실행해도 아무것도 출력되지 않습니다.

Git을 사용하시는 분은 다음 명령으로 전체 코드를 받으실 수 있습니다.

```sh
git clone https://github.com/timulys/java-basics-practical.git
```

## 실행 환경

| 항목 | 기준 |
|---|---|
| Java | JDK 21, 미리보기 기능 미사용 |
| 강의 제작 시 사용한 JDK | Zulu 21.0.7+6-LTS |
| 강의 제작 시 사용한 IDE | IntelliJ IDEA 2025.1.4.1 |
| 빌드 도구 | Gradle Wrapper 9.2.1, 프로젝트에 포함 |
| 문자 인코딩 | UTF-8 |
| 1·2강 외부 의존성 | 없음 |

1·2강은 Spring과 DB를 사용하지 않습니다. 처음 Gradle을 실행할 때는 배포 파일을 내려받으므로 인터넷 연결이 필요합니다. Gradle을 별도로 설치할 필요는 없습니다.

## 폴더를 고르는 기준

| 폴더 | 사용 시점 |
|---|---|
| `code/start` | 강의를 따라 코드를 작성할 때 |
| `code/complete` | 해당 강의의 기본 완성 결과를 확인할 때 |
| `code/exercise` | 과제를 직접 풀 때 |
| `code/solution` | 과제 풀이를 마친 뒤 해답과 비교할 때 |
| `code/checkpoints` | 영상 중간의 특정 코드 상태를 확인할 때 |
| `code/expected` | 실행 결과를 텍스트로 비교할 때 |

`start`·`complete`·`exercise`·`solution`은 각각 독립적으로 실행하는 Gradle 프로젝트입니다. `checkpoints`의 `Main.java`는 [체크포인트 사용 안내](docs/checkpoints.md)에 따라 하나씩 실행합니다. 의도한 오류를 보여주는 예제도 이름과 설명에 표시해두었습니다.

2강의 `start`는 1강의 `complete`와 같습니다. 다음 강의도 직전 강의의 기본 완성 코드에서 이어갑니다. 과제 해답은 별도로 보관합니다.

## 영상과 같은 코드 받기

강의 공개 시점의 코드는 `lesson-01-v1.0`, `lesson-02-v1.0` 태그와 [릴리스](https://github.com/timulys/java-basics-practical/releases)에 보관합니다. 이후 수정본이 나와도 같은 버전의 ZIP을 받으면 해당 영상에서 사용한 코드를 확인하실 수 있습니다.

## 실행이 잘 안 될 때

- Java 버전 오류가 나면 프로젝트 SDK와 Gradle JVM이 모두 21인지 확인합니다.
- macOS·Linux에서 `./gradlew` 실행 권한 오류가 나면 프로젝트 폴더에서 `chmod +x gradlew`를 실행합니다.
- `Main`이 중복된다는 오류가 나면 `src/main/java`에 여러 체크포인트를 함께 넣었는지 확인합니다. 한 번에 하나의 `Main.java`만 둡니다.
- 콘솔에서 한글이 깨지면 프로젝트와 실행 콘솔의 문자 인코딩을 UTF-8로 맞춥니다.

## 코드 검증

실습은 Python 없이 IntelliJ나 Gradle로 실행하실 수 있습니다. 배포본의 모든 예제를 한꺼번에 확인하는 방법은 [검증 도구 안내](docs/verification.md)에 있습니다.

Gradle Wrapper의 저작권·라이선스 안내는 [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)에 있습니다.
