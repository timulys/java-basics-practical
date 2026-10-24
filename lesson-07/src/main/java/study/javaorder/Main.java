package study.javaorder;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product("P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product("P002", "마우스", 15_000L, "주변기기");
        OrderItem[] items = {
                new OrderItem(keyboard, 2),
                new OrderItem(mouse, 1)
        };
        long subtotal = calculateSubtotal(items);
        long discount = calculateDiscount(subtotal);
        long shippingFee = calculateShippingFee(subtotal);
        long total = subtotal - discount + shippingFee;
        System.out.println("상품 금액: " + subtotal + "원");
        System.out.println("할인액: " + discount + "원");
        System.out.println("배송비: " + shippingFee + "원");
        System.out.println("최종 금액: " + total + "원");

        Order order = new Order();
        printStatus("처음", order);
        printRequest("첫 확정", order.confirm(), order);
        printRequest("다시 확정", order.confirm(), order);
        printRequest("확정 후 취소", order.cancel(), order);
        printRequest("취소 후 확정", order.confirm(), order);
        printRequest("다시 취소", order.cancel(), order);

        Order draftOrder = new Order();
        Order untouchedOrder = new Order();
        printRequest("준비 중 취소", draftOrder.cancel(), draftOrder);
        printStatus("다른 주문", untouchedOrder);

        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("상태 안내: " + status + " / " + statusLabel(status));
        }
    }

    static void printStatus(String label, Order order) {
        OrderStatus status = order.getStatus();
        System.out.println(label + ": " + status + " / " + statusLabel(status));
    }

    static void printRequest(String label, boolean accepted, Order order) {
        if (accepted) {
            System.out.println(label + ": 성공 / " + order.getStatus());
        } else {
            System.out.println(label + ": 거부 / " + order.getStatus());
        }
    }

    static String statusLabel(OrderStatus status) {
        if (status == OrderStatus.DRAFT) {
            return "준비 중";
        }
        if (status == OrderStatus.CONFIRMED) {
            return "확정";
        }
        if (status == OrderStatus.CANCELLED) {
            return "취소";
        }
        return "상태 없음";
    }

    static long calculateSubtotal(OrderItem[] items) {
        long subtotal = 0L;
        for (OrderItem item : items) {
            subtotal = subtotal + item.calculateLineTotal();
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
}
