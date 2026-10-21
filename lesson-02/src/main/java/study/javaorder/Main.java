
package study.javaorder;

public class Main {
    public static void main(String[] args) {
        String productName = "키보드";
        long unitPrice = 30_000L;
        int quantity = 2;
        boolean available = true;
        final String CURRENCY = "원";

        long subtotal = unitPrice * quantity;

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

        System.out.println("상품: " + productName);
        System.out.println("단가: " + unitPrice + CURRENCY);
        System.out.println("수량: " + quantity);
        System.out.println("판매 가능: " + available);
        System.out.println("상품 금액: " + subtotal + CURRENCY);
        System.out.println("할인액: " + discount + CURRENCY);
        System.out.println("배송비: " + shippingFee + CURRENCY);
        System.out.println("최종 금액: " + total + CURRENCY);

        boolean canOrder = available && quantity > 0;
        if (canOrder) {
            System.out.println("주문 안내: 주문 가능");
        } else {
            System.out.println("주문 안내: 판매 상태와 수량을 확인해 주세요");
        }

        int menu = 1;
        switch (menu) {
            case 1:
                System.out.println("메뉴 안내: 상품 조회");
                break;
            case 2:
                System.out.println("메뉴 안내: 장바구니 보기");
                break;
            default:
                System.out.println("메뉴 안내: 1 또는 2를 선택해 주세요");
                break;
        }
    }
}
