package study.javaorder;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product(
                "P001", "키보드",
                30_000L, "주변기기");
        Product mouse = new Product(
                "P002", "마우스",
                15_000L, "주변기기");
        Product notebook = new Product(
                "P003", "노트",
                5_000L, "문구");

        OrderItem[] items = {
                new OrderItem(keyboard, 2),
                new OrderItem(mouse, 1)
        };
        long subtotal = calculateSubtotal(items);
        long discount = calculateDiscount(subtotal);
        long shippingFee = calculateShippingFee(subtotal);
        long total = calculateTotal(subtotal, discount, shippingFee);
        printSummary(subtotal, discount, shippingFee, total);
        printCategory(keyboard);
        printCategory(mouse);
        printCategory(notebook);
    }

    static long calculateSubtotal(OrderItem[] items) {
        long subtotal = 0L;
        for (OrderItem item : items) {
            long lineTotal = item.calculateLineTotal();
            Product product = item.getProduct();
            System.out.println(product.getCode() + " " + product.getName()
                    + " " + item.getQuantity() + "개: " + lineTotal + "원");
            subtotal = subtotal + lineTotal;
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
    static void printCategory(Product product) {
        System.out.println(product.getCode() + " 카테고리: "
                + product.getCategory());
    }
}
