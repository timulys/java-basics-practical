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

        showPrimitiveCopy();
        showReferenceSharing(keyboard);
        showStringComparison();
        showNullSafeCondition();
        String[] codes = {
                keyboard.getCode(), new String("P001"), "P002",
                null, "", "   ", " P001 "
        };
        for (String code : codes) {
            printCodeResult(code);
        }
        String orderStatus = "DRAFT";
        System.out.println("주문 상태: " + orderStatus);
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

    static void showPrimitiveCopy() {
        int original = 1;
        int copied = original;
        copied = 2;
        System.out.println("기본형: original=" + original + ", copied=" + copied);
    }

    static void showReferenceSharing(Product keyboard) {
        OrderItem first = new OrderItem(keyboard, 1);
        OrderItem alias = first;
        alias.changeQuantity(2);
        System.out.println("같은 항목: " + (first == alias));
        System.out.println("공유 후 수량: first=" + first.getQuantity()
                + ", alias=" + alias.getQuantity());
        System.out.println("공유 후 금액: " + first.calculateLineTotal() + "원");

        alias = new OrderItem(keyboard, 3);
        System.out.println("다시 대입 후 같은 항목: " + (first == alias));
        System.out.println("각 수량: first=" + first.getQuantity()
                + ", alias=" + alias.getQuantity());
        System.out.println("같은 상품: " + (first.getProduct() == alias.getProduct()));
    }

    static void showStringComparison() {
        String literal = "P001";
        String sameLiteral = "P001";
        String entered = new String("P001");
        String another = new String("P001");
        System.out.println("리터럴 ==: " + (literal == sameLiteral));
        System.out.println("새 문자열 ==: " + (entered == another));
        System.out.println("내용 equals: " + entered.equals(another));
        System.out.println("코드 리터럴과 입력 ==: " + (literal == entered));
        System.out.println("코드 내용 비교: " + literal.equals(entered));
        System.out.println("대소문자 비교: " + literal.equals("p001"));

        String nullable = null;
        System.out.println("상수에서 equals(null): " + "P001".equals(nullable));
        String spaced = " P001 ";
        String cleaned = spaced.strip();
        System.out.println("원본: [" + spaced + "]");
        System.out.println("정리: [" + cleaned + "]");
    }

    static void showNullSafeCondition() {
        String code = null;
        boolean matched = code != null && code.equals("P001");
        System.out.println("null 조건 검사: " + matched);
    }

    static void printCodeResult(String code) {
        if (code == null) {
            System.out.println("상품 코드: 누락");
            return;
        }
        if (code.isBlank()) {
            System.out.println("상품 코드: 빈 값");
            return;
        }
        String normalized = code.strip();
        if ("P001".equals(normalized)) {
            System.out.println("상품 코드 [" + normalized + "]: 일치");
        } else {
            System.out.println("상품 코드 [" + normalized + "]: 불일치");
        }
    }
}
