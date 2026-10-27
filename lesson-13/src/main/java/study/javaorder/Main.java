package study.javaorder;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product(
                "P002", "마우스", 15_000L, "주변기기");
        Product notebook = new Product(
                "P003", "노트", 5_000L, "문구");
        Cart cart = new Cart();
        cart.add(keyboard, 1);
        cart.add(mouse, 1);
        cart.add(notebook, 2);

        System.out.println("[집계 전 장바구니]");
        printCart(cart);
        System.out.println("전체 상품 금액: " + cart.calculateSubtotal() + "원");
        System.out.println("반복문 주변기기 합계: "
                + cart.calculateSubtotalByCategoryWithLoop("주변기기") + "원");
        System.out.println("Stream 주변기기 합계: "
                + cart.calculateSubtotalByCategory("주변기기") + "원");
        System.out.println("Stream 문구 합계: "
                + cart.calculateSubtotalByCategory("문구") + "원");
        System.out.println("Stream 가전 합계: "
                + cart.calculateSubtotalByCategory("가전") + "원");
        System.out.println("다시 조회한 주변기기 합계: "
                + cart.calculateSubtotalByCategory("주변기기") + "원");
        System.out.println("[집계 후 장바구니]");
        printCart(cart);
        System.out.println("전체 상품 금액: " + cart.calculateSubtotal() + "원");
    }

    static void printCart(Cart cart) {
        for (OrderItem item : cart.getItems()) {
            System.out.println(item.getProduct().getName()
                    + " / 수량 " + item.getQuantity()
                    + " / 항목 금액 " + item.calculateLineTotal() + "원");
        }
    }
}
