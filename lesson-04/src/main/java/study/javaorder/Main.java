package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String[] productNames = {"키보드", "마우스", "노트"};
        long[] unitPrices = {30_000L, 15_000L, 5_000L};
        int[] quantities = {1, 1, 1};

        for (int i = 0; i < productNames.length; i++) {
            long lineTotal = unitPrices[i] * quantities[i];
            System.out.println(productNames[i] + " "
                    + quantities[i] + "개: " + lineTotal + "원");
        }

        long subtotal = calculateSubtotal(unitPrices, quantities);
        long discount = calculateDiscount(subtotal);
        long shippingFee = calculateShippingFee(subtotal);
        long total = calculateTotal(subtotal, discount, shippingFee);
        printSummary(subtotal, discount, shippingFee, total);
    }

    static long calculateSubtotal(
            long[] unitPrices, int[] quantities) {
        long subtotal = 0L;
        for (int i = 0; i < unitPrices.length; i++) {
            subtotal = subtotal + unitPrices[i] * quantities[i];
        }
        return subtotal;
    }

    static long calculateDiscount(long subtotal) {
        if (subtotal >= 50_000L) {
            return 5_000L;
        }
        return 0L;
    }

    static long calculateShippingFee(long subtotal) {
        if (subtotal >= 50_000L) {
            return 0L;
        }
        return 3_000L;
    }

    static long calculateTotal(
            long subtotal, long discount, long shippingFee) {
        return subtotal - discount + shippingFee;
    }

    static void printSummary(
            long subtotal, long discount,
            long shippingFee, long total) {
        System.out.println("상품 금액: " + subtotal + "원");
        System.out.println("할인액: " + discount + "원");
        System.out.println("배송비: " + shippingFee + "원");
        System.out.println("최종 금액: " + total + "원");
    }
}
