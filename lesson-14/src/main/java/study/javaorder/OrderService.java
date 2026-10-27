package study.javaorder;

public class OrderService {
    private final ProductCatalog catalog;
    private final DiscountPolicy discountPolicy;

    public OrderService(ProductCatalog catalog, DiscountPolicy discountPolicy) {
        if (catalog == null) {
            throw new IllegalArgumentException("상품 목록이 필요합니다.");
        }
        if (discountPolicy == null) {
            throw new IllegalArgumentException("할인 규칙이 필요합니다.");
        }
        this.catalog = catalog;
        this.discountPolicy = discountPolicy;
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
        if (subtotal < 0L) {
            throw new IllegalArgumentException("상품 금액은 음수일 수 없습니다.");
        }
        long discount = discountPolicy.calculateDiscount(subtotal);
        if (discount < 0L || discount > subtotal) {
            throw new IllegalStateException("할인액은 0원 이상 상품 금액 이하여야 합니다.");
        }
        return discount;
    }

    public long calculateShippingFee(long subtotal) {
        if (subtotal < 0L) {
            throw new IllegalArgumentException("상품 금액은 음수일 수 없습니다.");
        }
        if (subtotal >= 50_000L) {
            return 0L;
        }
        return 3_000L;
    }
}
