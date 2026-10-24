package study.javaorder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();
    private final long subtotal;
    private final long discount;
    private final long shippingFee;
    private OrderStatus status = OrderStatus.DRAFT;

    Order(List<OrderItem> source, long discount, long shippingFee) {
        long amount = 0L;
        for (OrderItem item : source) {
            OrderItem copy = new OrderItem(
                    item.getProduct(), item.getQuantity());
            items.add(copy);
            amount = amount + copy.calculateLineTotal();
        }
        this.subtotal = amount;
        this.discount = discount;
        this.shippingFee = shippingFee;
    }

    public void confirm() {
        if (status != OrderStatus.DRAFT) {
            throw new IllegalStateException("준비 중인 주문만 확정할 수 있습니다.");
        }
        status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == OrderStatus.CANCELLED) {
            throw new IllegalStateException("이미 취소한 주문입니다.");
        }
        status = OrderStatus.CANCELLED;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        List<OrderItem> copies = new ArrayList<>();
        for (OrderItem item : items) {
            copies.add(new OrderItem(
                    item.getProduct(), item.getQuantity()));
        }
        return copies;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public long getDiscount() {
        return discount;
    }

    public long getShippingFee() {
        return shippingFee;
    }

    public long getTotal() {
        return subtotal - discount + shippingFee;
    }
}
