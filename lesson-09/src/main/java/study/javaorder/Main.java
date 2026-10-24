package study.javaorder;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        Product duplicate = new Product(
                "P001", "다른 키보드", 35_000L, "주변기기");
        Product mouse = new Product(
                "P002", "마우스", 15_000L, "주변기기");
        System.out.println("같은 참조: " + (keyboard == duplicate));
        System.out.println("같은 상품 코드: " + keyboard.equals(duplicate));
        System.out.println("같은 해시 코드: "
                + (keyboard.hashCode() == duplicate.hashCode()));
        Set<Product> unique = new HashSet<>();
        System.out.println("키보드 추가: " + unique.add(keyboard));
        System.out.println("중복 상품 추가: " + unique.add(duplicate));
        System.out.println("P001 집합 크기: " + unique.size());
        unique.add(mouse);
        System.out.println("P002 추가 후 크기: " + unique.size());
        ProductCatalog catalog = new ProductCatalog();
        System.out.println("최초 등록: " + catalog.register(keyboard));
        System.out.println("중복 등록: " + catalog.register(duplicate));
        catalog.register(mouse);
        System.out.println("등록 상품 수: " + catalog.size());
        Product found = catalog.find("P001");
        if (found != null) {
            System.out.println("기존 상품 유지: " + found.getName());
        }
        Cart cart = new Cart();
        cart.add(keyboard, 1);
        cart.add(duplicate, 1);
        System.out.println("장바구니 행 수: " + cart.size());
        System.out.println("키보드 수량: "
                + cart.getItems().get(0).getQuantity());
        System.out.println("상품 금액: " + cart.calculateSubtotal() + "원");
        System.out.println("null과 비교: " + keyboard.equals(null));
        System.out.println("문자열과 비교: " + keyboard.equals("P001"));
    }
}
