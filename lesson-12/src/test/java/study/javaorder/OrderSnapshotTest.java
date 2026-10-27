package study.javaorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderSnapshotTest {
    @Test
    void laterCartChangeKeepsConfirmedOrder() {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product(
                "P002", "마우스", 15_000L, "주변기기");
        Cart cart = new Cart();
        cart.add(keyboard, 2);
        OrderService service = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy());
        Order order = service.placeOrder(cart);

        cart.add(mouse, 1);

        assertEquals(55_000L, order.getTotal());
        assertEquals(1, order.getItems().size());
        assertEquals(2, order.getItems().get(0).getQuantity());
        assertEquals(75_000L, cart.calculateSubtotal());
    }
}
