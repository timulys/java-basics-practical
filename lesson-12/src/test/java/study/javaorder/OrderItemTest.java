package study.javaorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemTest {
    @Test
    void zeroQuantityIsRejected() {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");

        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(keyboard, 0));
    }

    @Test
    void rejectedChangeKeepsQuantity() {
        Product keyboard = new Product(
                "P001", "키보드", 30_000L, "주변기기");
        OrderItem item = new OrderItem(keyboard, 2);

        assertThrows(IllegalArgumentException.class,
                () -> item.changeQuantity(0));

        assertEquals(2, item.getQuantity());
    }
}
