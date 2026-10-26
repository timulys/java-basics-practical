package study.javaorder;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product("P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product("P002", "마우스", 15_000L, "주변기기");
        ProductCatalog catalog = new ProductCatalog();
        catalog.register(keyboard);
        catalog.register(mouse);
        Cart cart = new Cart();
        cart.add(keyboard, 2);

        DiscountPolicy noDiscount = new NoDiscountPolicy();
        DiscountPolicy fixedDiscount = new ThresholdFixedDiscountPolicy();
        OrderService noDiscountService = new OrderService(catalog, noDiscount);
        OrderService fixedDiscountService = new OrderService(catalog, fixedDiscount);

        Order first = noDiscountService.placeOrder(cart);
        Order second = fixedDiscountService.placeOrder(cart);
        printOrder("할인 없음", first);
        printOrder("기본 할인", second);

        cart.add(mouse, 1);
        Order third = fixedDiscountService.placeOrder(cart);
        printOrder("마우스 추가 후 주문", third);
        System.out.println("기존 기본 할인 주문 금액: " + second.getTotal() + "원");
        System.out.println("기존 기본 할인 주문 항목 수: " + second.getItems().size());
    }

    static void printOrder(String title, Order order) {
        System.out.println("[" + title + "]");
        System.out.println("상품 금액: " + order.getSubtotal() + "원");
        System.out.println("할인: " + order.getDiscount() + "원");
        System.out.println("배송비: " + order.getShippingFee() + "원");
        System.out.println("최종 금액: " + order.getTotal() + "원");
        System.out.println("상태: " + order.getStatus());
    }
}
