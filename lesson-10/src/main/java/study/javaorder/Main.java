package study.javaorder;

public class Main {
    public static void main(String[] args) {
        try {
            new Product("P000", "잘못된 상품", 0L, "문구");
        } catch (IllegalArgumentException e) {
            System.out.println("상품 생성 거부: " + e.getMessage());
        }
        Product keyboard = new Product("P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product("P002", "마우스", 15_000L, "주변기기");
        Product notebook = new Product("P003", "노트", 5_000L, "문구");
        ProductCatalog catalog = new ProductCatalog();
        catalog.register(keyboard);
        catalog.register(mouse);
        catalog.register(notebook);
        OrderService service = new OrderService(catalog);
        Cart cart = new Cart();
        requestAdd(service, cart, "P001", "0");
        requestAdd(service, cart, "P001", "abc");
        requestAdd(service, cart, "P999", "1");
        System.out.println("거부 후 행 수: " + cart.size());
        requestAdd(service, cart, "P001", "2");
        requestAdd(service, cart, "P002", "1");
        System.out.println("정상 추가 후 상품 금액: " + cart.calculateSubtotal() + "원");
        requestAdd(service, cart, "P001", "98");
        System.out.println("합산 거부 후 키보드 수량: " + cart.getItems().get(0).getQuantity());
        try {
            cart.changeQuantity("P001", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("변경 거부: " + e.getMessage());
        }
        System.out.println("변경 거부 후 키보드 수량: " + cart.getItems().get(0).getQuantity());
        requestEmptyOrder(service);
        Order order = service.placeOrder(cart);
        System.out.println("주문 상태: " + order.getStatus());
        System.out.println("상품 금액: " + order.getSubtotal() + "원");
        System.out.println("할인: " + order.getDiscount() + "원");
        System.out.println("배송비: " + order.getShippingFee() + "원");
        System.out.println("최종 금액: " + order.getTotal() + "원");
        cart.changeQuantity("P001", 3);
        System.out.println("장바구니 변경 후 상품 금액: " + cart.calculateSubtotal() + "원");
        System.out.println("확정 주문의 키보드 수량: " + order.getItems().get(0).getQuantity());
        System.out.println("확정 주문의 상품 금액: " + order.getSubtotal() + "원");
        requestConfirm(order);
        System.out.println("재확정 거부 후 상태: " + order.getStatus());
        order.cancel();
        System.out.println("취소 후 상태: " + order.getStatus());
        requestConfirm(order);
        requestCancel(order);
        System.out.println("거부 후 상태: " + order.getStatus());
        Cart nextCart = new Cart();
        requestAdd(service, nextCart, "P003", "2");
        Order nextOrder = service.placeOrder(nextCart);
        System.out.println("다음 정상 주문: " + nextOrder.getStatus()
                + " / " + nextOrder.getTotal() + "원");
    }

    static void requestAdd(OrderService service, Cart cart,
                           String code, String quantityText) {
        try {
            int quantity = Integer.parseInt(quantityText);
            service.addByCode(cart, code, quantity);
            System.out.println("추가 성공: " + code + " / 요청 수량 " + quantity);
        } catch (NumberFormatException e) {
            System.out.println("추가 거부: 수량은 정수로 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("추가 거부: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("추가 거부: " + e.getMessage());
        }
    }

    static void requestEmptyOrder(OrderService service) {
        try {
            service.placeOrder(new Cart());
        } catch (IllegalStateException e) {
            System.out.println("주문 거부: " + e.getMessage());
        }
    }

    static void requestConfirm(Order order) {
        try {
            order.confirm();
            System.out.println("확정 성공");
        } catch (IllegalStateException e) {
            System.out.println("확정 거부: " + e.getMessage());
        }
    }

    static void requestCancel(Order order) {
        try {
            order.cancel();
            System.out.println("취소 성공");
        } catch (IllegalStateException e) {
            System.out.println("취소 거부: " + e.getMessage());
        }
    }
}
