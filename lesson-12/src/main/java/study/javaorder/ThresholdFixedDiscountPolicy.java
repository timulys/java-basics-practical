package study.javaorder;

public class ThresholdFixedDiscountPolicy implements DiscountPolicy {
    @Override
    public long calculateDiscount(long subtotal) {
        if (subtotal < 0L) {
            throw new IllegalArgumentException("상품 금액은 음수일 수 없습니다.");
        }
        if (subtotal >= 50_000L) {
            return 5_000L;
        }
        return 0L;
    }
}
