package study.javaorder;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public long calculateDiscount(long subtotal) {
        if (subtotal < 0L) {
            throw new IllegalArgumentException("상품 금액은 음수일 수 없습니다.");
        }
        return 0L;
    }
}
