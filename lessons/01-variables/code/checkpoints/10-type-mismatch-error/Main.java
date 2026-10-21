package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String productName = "키보드";
        int unitPrice = 30_000L;
        int quantity = 2;
        boolean available = true;
        final String CURRENCY = "원";

        long subtotal = unitPrice * quantity;

        System.out.println("상품: " + productName);
        System.out.println("단가: " + unitPrice + CURRENCY);
        System.out.println("수량: " + quantity);
        System.out.println("판매 가능: " + available);
        System.out.println("상품 금액: " + subtotal + CURRENCY);
    }
}
