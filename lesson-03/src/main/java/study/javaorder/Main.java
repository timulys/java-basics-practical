package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String[] productNames = {"키보드", "마우스", "노트"};
        long[] unitPrices = {30_000L, 15_000L, 5_000L};
        int[] quantities = {1, 1, 1};
        final String CURRENCY = "원";

        long subtotal = 0L;
        for (int i = 0; i < productNames.length; i++) {
            long lineTotal = unitPrices[i] * quantities[i];
            subtotal = subtotal + lineTotal;
            System.out.println(productNames[i] + " "
                    + quantities[i] + "개: " + lineTotal + CURRENCY);
        }

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
        System.out.println("상품 금액: " + subtotal + CURRENCY);
        System.out.println("할인액: " + discount + CURRENCY);
        System.out.println("배송비: " + shippingFee + CURRENCY);
        System.out.println("최종 금액: " + total + CURRENCY);
    }
}
