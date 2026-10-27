package study.javaorder;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Product keyboard = new Product("P001", "키보드", 30_000L, "주변기기");
        Product mouse = new Product("P002", "마우스", 15_000L, "주변기기");
        Cart cart = new Cart();
        cart.add(keyboard, 2);
        cart.add(mouse, 1);
        OrderService service = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy());
        Order order = service.placeOrder(cart);
        Path file = Path.of("data", "latest-order.txt");
        ReceiptFileStore store = new ReceiptFileStore(file);

        try {
            store.save(order.toSummaryText());
            System.out.println("저장 경로: " + file.toAbsolutePath());
            System.out.println("[저장한 주문 요약]");
            System.out.print(store.read());
        } catch (IOException e) {
            System.out.println("주문 요약을 저장하거나 읽지 못했습니다: " + e.getMessage());
        }
    }
}
