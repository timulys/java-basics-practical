package study.javaorder;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        OrderItem existing = findItem(product.getCode());
        if (existing != null) {
            int combined = existing.getQuantity() + quantity;
            existing.changeQuantity(combined);
            return;
        }
        items.add(new OrderItem(product, quantity));
    }

    public boolean remove(String productCode) {
        for (int index = 0; index < items.size(); index++) {
            OrderItem item = items.get(index);
            if (item.getProduct().getCode().equals(productCode)) {
                items.remove(index);
                return true;
            }
        }
        return false;
    }

    public boolean changeQuantity(String productCode, int quantity) {
        OrderItem item = findItem(productCode);
        if (item == null) {
            return false;
        }
        item.changeQuantity(quantity);
        return true;
    }

    public int size() {
        return items.size();
    }

    public long calculateSubtotal() {
        long subtotal = 0L;
        for (OrderItem item : items) {
            subtotal = subtotal + item.calculateLineTotal();
        }
        return subtotal;
    }

    public List<OrderItem> getItems() {
        List<OrderItem> copies = new ArrayList<>();
        for (OrderItem item : items) {
            copies.add(new OrderItem(
                    item.getProduct(), item.getQuantity()));
        }
        return copies;
    }

    private OrderItem findItem(String productCode) {
        for (OrderItem item : items) {
            if (item.getProduct().getCode().equals(productCode)) {
                return item;
            }
        }
        return null;
    }
}
