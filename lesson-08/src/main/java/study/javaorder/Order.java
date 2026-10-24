package study.javaorder;

public class Order {
    private OrderStatus status = OrderStatus.DRAFT;

    public OrderStatus getStatus() {
        return status;
    }

    public boolean confirm() {
        if (status != OrderStatus.DRAFT) {
            return false;
        }
        status = OrderStatus.CONFIRMED;
        return true;
    }

    public boolean cancel() {
        if (status == OrderStatus.CANCELLED) {
            return false;
        }
        status = OrderStatus.CANCELLED;
        return true;
    }
}
