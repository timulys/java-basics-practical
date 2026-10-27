package study.javaorder;

public class OrderItem {
    private final Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("상품이 필요합니다.");
        }
        validateQuantity(quantity);
        this.product = product;
        this.quantity = quantity;
    }

    public static void validateQuantity(int quantity) {
        if (quantity < 1 || quantity > 99) {
            throw new IllegalArgumentException("수량은 1~99개여야 합니다.");
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public long calculateLineTotal() {
        return product.getUnitPrice() * quantity;
    }
}
