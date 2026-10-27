package study.javaorder;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("상품이 필요합니다.");
        }
        OrderItem.validateQuantity(quantity);
        OrderItem existing = findItem(product.getCode());
        if (existing != null) {
            int combined = existing.getQuantity() + quantity;
            existing.changeQuantity(combined);
            return;
        }
        if (items.size() >= 100) {
            throw new IllegalStateException("장바구니는 최대 100종류까지 담을 수 있습니다.");
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
            throw new IllegalArgumentException("담지 않은 상품입니다: " + productCode);
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

    public long calculateSubtotalByCategoryWithLoop(String category) {
        validateCategory(category);
        long subtotal = 0L;
        for (OrderItem item : items) {
            if (category.equals(item.getProduct().getCategory())) {
                subtotal = subtotal + item.calculateLineTotal();
            }
        }
        return subtotal;
    }

    public long calculateSubtotalByCategory(String category) {
        validateCategory(category);
        return items.stream()
                .filter(item -> category.equals(
                        item.getProduct().getCategory()))
                .mapToLong(item -> item.calculateLineTotal())
                .sum();
    }

    private static void validateCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("조회할 카테고리가 필요합니다.");
        }
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
