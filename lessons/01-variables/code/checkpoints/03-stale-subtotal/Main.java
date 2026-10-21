
package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String productName = "키보드";
        long unitPrice = 30_000L;
        int quantity = 2;

        long subtotal = unitPrice * quantity;
        quantity = 3;

        System.out.println("상품: " + productName);
        System.out.println("단가: " + unitPrice + "원");
        System.out.println("수량: " + quantity);
        System.out.println("상품 금액: " + subtotal + "원");
    }
}
