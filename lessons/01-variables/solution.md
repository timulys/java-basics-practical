# 1강 연습 문제 해설

상품 금액을 계산한 다음 배송비를 저장하고 최종 금액을 계산합니다.

```java
long subtotal = unitPrice * quantity;
long shippingFee = 3_000L;
long total = subtotal + shippingFee;
```

subtotal은 단가와 수량을 곱한 상품 금액입니다. shippingFee에는 배송비 3000원을 넣습니다. 두 금액을 더해 total에 저장합니다.

```java
System.out.println("상품 금액: " + subtotal + CURRENCY);
System.out.println("배송비: " + shippingFee + CURRENCY);
System.out.println("최종 금액: " + total + CURRENCY);
```

수량 2일 때에는 60000 + 3000이므로 최종 금액은 63000원입니다. 수량 3일 때에는 90000 + 3000이므로 93000원입니다. 각 결과를 실제 Java 실행으로 확인했습니다.

최종 금액을 변수로 먼저 계산하면 출력 문장에서는 안내 문자열과 계산 결과만 연결하면 됩니다. 숫자를 문자열 뒤에 순서대로 붙여 600003000처럼 표시하는 실수를 줄일 수 있습니다.

전체 해답은 code/solution/src/main/java/study/javaorder/Main.java에 있습니다. 기본 완성 코드는 배송비 과제를 추가하기 전 상태로 보관합니다.
