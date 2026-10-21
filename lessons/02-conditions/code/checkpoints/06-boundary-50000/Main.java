package study.javaorder;

public class Main {
    public static void main(String[] args) {
        long subtotal = 50_000L;

        long discount = 0L;
        if (subtotal >= 50_000L) {
            discount = 5_000L;
        }

        long shippingFee = 3_000L;
        if (subtotal >= 50_000L) {
            shippingFee = 0L;
        } else {
            shippingFee = 3_000L;
        }

        long total = subtotal - discount + shippingFee;

        System.out.println("상품 금액: " + subtotal + "원");
        System.out.println("할인액: " + discount + "원");
        System.out.println("배송비: " + shippingFee + "원");
        System.out.println("최종 금액: " + total + "원");
    }
}
