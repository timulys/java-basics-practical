package study.javaorder;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product(
                "P002", "마우스", 15_000L, "주변기기");
        Product notebook = new Product(
                "P003", "노트", 5_000L, "문구");
        ProductCatalog catalog = new ProductCatalog();
        catalog.register(keyboard);
        catalog.register(mouse);
        catalog.register(notebook);
        System.out.println("등록 상품 수: " + catalog.size());
        Product found = catalog.find("P002");
        if (found != null) {
            System.out.println("상품 조회: " + found.getName());
        }

        Cart cart = new Cart();
        addByCode(catalog, cart, "P001", 1);
        addByCode(catalog, cart, "P001", 1);
        addByCode(catalog, cart, "P002", 1);
        printCart("수량 합산 후", cart);

        addByCode(catalog, cart, "P999", 1);
        System.out.println("없는 상품 조회 후 행 수: " + cart.size());

        boolean changed = cart.changeQuantity("P001", 3);
        System.out.println("P001 수량 변경: " + changed);
        printCart("수량 변경 후", cart);

        boolean removed = cart.remove("P002");
        System.out.println("P002 삭제: " + removed);
        printCart("삭제 후", cart);
        System.out.println("P002 다시 삭제: " + cart.remove("P002"));
        System.out.println("없는 항목 수량 변경: "
                + cart.changeQuantity("P999", 2));
    }

    static void addByCode(
            ProductCatalog catalog, Cart cart,
            String productCode, int quantity) {
        Product product = catalog.find(productCode);
        if (product == null) {
            System.out.println("추가 거부: " + productCode + " 상품 없음");
            return;
        }
        cart.add(product, quantity);
    }

    static void printCart(String label, Cart cart) {
        System.out.println("[" + label + "] 행 수: " + cart.size());
        for (OrderItem item : cart.getItems()) {
            Product product = item.getProduct();
            System.out.println(product.getCode() + " " + product.getName()
                    + " / 수량 " + item.getQuantity()
                    + " / 항목 금액 " + item.calculateLineTotal() + "원");
        }
        long subtotal = cart.calculateSubtotal();
        long total = subtotal - calculateDiscount(subtotal)
                + calculateShippingFee(subtotal);
        System.out.println("상품 금액: " + subtotal + "원");
        System.out.println("최종 금액: " + total + "원");
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
