package study.javaorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartAggregationTest {
    @Test
    void peripheralsMatchLoop() {
        Cart cart = sampleCart();

        assertEquals(45_000L,
                cart.calculateSubtotalByCategoryWithLoop("주변기기"));
        assertEquals(45_000L,
                cart.calculateSubtotalByCategory("주변기기"));
    }

    @Test
    void stationeryIncludesQuantity() {
        Cart cart = sampleCart();

        assertEquals(10_000L, cart.calculateSubtotalByCategory("문구"));
    }

    @Test
    void unmatchedCategoryReturnsZero() {
        Cart cart = sampleCart();

        assertEquals(0L, cart.calculateSubtotalByCategory("가전"));
    }

    @Test
    void emptyCartReturnsZero() {
        Cart cart = new Cart();

        assertEquals(0L, cart.calculateSubtotalByCategory("주변기기"));
    }

    @Test
    void aggregationPreservesOriginalCart() {
        Cart cart = sampleCart();

        cart.calculateSubtotalByCategory("주변기기");
        cart.calculateSubtotalByCategory("문구");

        assertEquals(3, cart.size());
        assertEquals(55_000L, cart.calculateSubtotal());
        assertEquals(1, cart.getItems().get(0).getQuantity());
        assertEquals(1, cart.getItems().get(1).getQuantity());
        assertEquals(2, cart.getItems().get(2).getQuantity());
        assertEquals("P001", cart.getItems().get(0).getProduct().getCode());
        assertEquals("P002", cart.getItems().get(1).getProduct().getCode());
        assertEquals("P003", cart.getItems().get(2).getProduct().getCode());
    }

    @Test
    void anotherCallReadsCurrentQuantity() {
        Cart cart = sampleCart();
        assertEquals(45_000L, cart.calculateSubtotalByCategory("주변기기"));

        cart.changeQuantity("P001", 2);

        assertEquals(75_000L, cart.calculateSubtotalByCategory("주변기기"));
    }

    @Test
    void nullCategoryIsRejected() {
        Cart cart = sampleCart();

        assertThrows(IllegalArgumentException.class,
                () -> cart.calculateSubtotalByCategory(null));
    }

    @Test
    void blankCategoryIsRejected() {
        Cart cart = sampleCart();

        assertThrows(IllegalArgumentException.class,
                () -> cart.calculateSubtotalByCategory(" "));
    }

    private Cart sampleCart() {
        Cart cart = new Cart();
        cart.add(new Product("P001", "키보드", 30_000L, "주변기기"), 1);
        cart.add(new Product("P002", "마우스", 15_000L, "주변기기"), 1);
        cart.add(new Product("P003", "노트", 5_000L, "문구"), 2);
        return cart;
    }
}
