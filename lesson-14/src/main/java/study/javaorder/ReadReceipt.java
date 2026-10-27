package study.javaorder;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ReadReceipt {
    public static void main(String[] args) {
        ReceiptFileStore store = new ReceiptFileStore(
                Path.of("data", "latest-order.txt"));
        try {
            System.out.print(store.read());
        } catch (NoSuchFileException e) {
            System.out.println("저장된 주문 요약이 없습니다.");
        } catch (IOException e) {
            System.out.println("주문 요약을 읽지 못했습니다: " + e.getMessage());
        }
    }
}
