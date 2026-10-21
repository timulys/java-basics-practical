package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String productName = "키보드";
        long unitPrice = 30_000L;
        int quantity = 2;
        boolean available = true;
        final String CURRENCY = "원";

        long subtotal = unitPrice * quantity;

        // 과제: 배송비 3,000원과 최종 금액을 계산하는 변수를 추가합니다.

        System.out.println("상품: " + productName);
        System.out.println("단가: " + unitPrice + CURRENCY);
        System.out.println("수량: " + quantity);
        System.out.println("판매 가능: " + available);
        System.out.println("상품 금액: " + subtotal + CURRENCY);
        // 과제: 배송비와 최종 금액을 출력합니다.
    }
}
