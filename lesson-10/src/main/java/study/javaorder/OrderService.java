package study.javaorder;

public class OrderService {
    private final ProductCatalog catalog;

    public OrderService(ProductCatalog catalog) {
        if (catalog == null) {
            throw new IllegalArgumentException("상품 목록이 필요합니다.");
        }
        this.catalog = catalog;
    }

    public void addByCode(Cart cart, String productCode, int quantity) {
        if (cart == null) {
            throw new IllegalArgumentException("장바구니가 필요합니다.");
        }
        Product product = catalog.findRequired(productCode);
        cart.add(product, quantity);
    }

    public Order placeOrder(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("장바구니가 필요합니다.");
        }
        if (cart.size() == 0) {
            throw new IllegalStateException("빈 장바구니는 주문할 수 없습니다.");
        }
        long subtotal = cart.calculateSubtotal();
        long discount = calculateDiscount(subtotal);
        long shippingFee = calculateShippingFee(subtotal);
        Order order = new Order(cart.getItems(), discount, shippingFee);
        order.confirm();
        return order;
    }

    public long calculateDiscount(long subtotal) {
        if (subtotal >= 50_000L) {
            return 5_000L;
        }
        return 0L;
    }

    public long calculateShippingFee(long subtotal) {
        if (subtotal >= 50_000L) {
            return 0L;
        }
        return 3_000L;
    }
}
