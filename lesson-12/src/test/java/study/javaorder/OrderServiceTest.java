package study.javaorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {
    @Test
    void belowDiscountBoundary() {
        Product product = new Product(
                "P001", "경계 검증 상품", 49_999L, "검증");
        Cart cart = new Cart();
        cart.add(product, 1);
        ProductCatalog catalog = new ProductCatalog();
        OrderService service = new OrderService(catalog,
                new ThresholdFixedDiscountPolicy());

        Order order = service.placeOrder(cart);

        assertEquals(52_999L, order.getTotal());
    }

    @Test
    void atDiscountBoundary() {
        Product product = new Product(
                "P001", "경계 검증 상품", 50_000L, "검증");
        Cart cart = new Cart();
        cart.add(product, 1);
        OrderService service = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy());

        Order order = service.placeOrder(cart);

        assertEquals(45_000L, order.getTotal());
    }

    @Test
    void aboveDiscountBoundary() {
        Product product = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        Cart cart = new Cart();
        cart.add(product, 2);
        OrderService service = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy());

        Order order = service.placeOrder(cart);

        assertEquals(55_000L, order.getTotal());
        assertEquals(OrderStatus.CONFIRMED, order.getStatus());
    }

    @Test
    void noDiscountKeepsSubtotal() {
        Cart cart = new Cart();
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        cart.add(keyboard, 2);
        OrderService service = new OrderService(new ProductCatalog(),
                new NoDiscountPolicy());

        Order order = service.placeOrder(cart);

        assertEquals(60_000L, order.getTotal());
    }

    @Test
    void emptyCartIsRejected() {
        Cart cart = new Cart();
        OrderService service = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy());

        assertThrows(IllegalStateException.class,
                () -> service.placeOrder(cart));
    }
}
