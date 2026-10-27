package study.javaorder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReceiptFileStoreTest {
    @TempDir
    Path tempDir;

    @Test
    void createsMissingParentDirectories() throws IOException {
        Path file = tempDir.resolve("missing/data/latest-order.txt");
        ReceiptFileStore store = new ReceiptFileStore(file);
        store.save("주문 요약\n");
        assertTrue(Files.isRegularFile(file));
        assertEquals("주문 요약\n", store.read());
    }

    @Test
    void savesKoreanAsUtf8() throws IOException {
        Path file = tempDir.resolve("latest-order.txt");
        ReceiptFileStore store = new ReceiptFileStore(file);
        String summary = "키보드 / 수량 2 / 항목 금액 60000원\n";
        store.save(summary);
        assertEquals(summary, Files.readString(file, StandardCharsets.UTF_8));
    }

    @Test
    void anotherStoreReadsPreviouslySavedText() throws IOException {
        Path file = tempDir.resolve("latest-order.txt");
        new ReceiptFileStore(file).save("이전 실행에서 저장한 요약\n");
        ReceiptFileStore restarted = new ReceiptFileStore(file);
        assertEquals("이전 실행에서 저장한 요약\n", restarted.read());
    }

    @Test
    void secondSaveReplacesPreviousText() throws IOException {
        ReceiptFileStore store = new ReceiptFileStore(tempDir.resolve("latest-order.txt"));
        store.save("길이가 긴 이전 주문 요약입니다.\n");
        store.save("새 요약\n");
        assertEquals("새 요약\n", store.read());
    }

    @Test
    void missingFileThrowsNoSuchFileException() {
        ReceiptFileStore store = new ReceiptFileStore(tempDir.resolve("missing.txt"));
        assertThrows(NoSuchFileException.class, () -> store.read());
    }

    @Test
    void directoryCannotBeReadAsText() {
        ReceiptFileStore store = new ReceiptFileStore(tempDir);
        assertThrows(IOException.class, () -> store.read());
    }

    @Test
    void fileInPlaceOfParentMakesSaveFail() throws IOException {
        Path blocked = tempDir.resolve("blocked");
        Files.writeString(blocked, "디렉터리 대신 놓인 파일", StandardCharsets.UTF_8);
        ReceiptFileStore store = new ReceiptFileStore(blocked.resolve("latest-order.txt"));
        assertThrows(IOException.class, () -> store.save("주문 요약"));
    }

    @Test
    void orderSummaryIncludesItemsAmountsAndCurrentStatus() {
        Cart cart = new Cart();
        cart.add(new Product("P001", "키보드", 30_000L, "주변기기"), 2);
        cart.add(new Product("P002", "마우스", 15_000L, "주변기기"), 1);
        Order order = new OrderService(new ProductCatalog(),
                new ThresholdFixedDiscountPolicy()).placeOrder(cart);
        String amounts = "P001 / 키보드 / 수량 2 / 항목 금액 60000원\n"
                + "P002 / 마우스 / 수량 1 / 항목 금액 15000원\n"
                + "상품 금액: 75000원\n할인: 5000원\n배송비: 0원\n최종 금액: 70000원\n";
        assertEquals("주문 상태: CONFIRMED\n" + amounts, order.toSummaryText());
        order.cancel();
        assertEquals("주문 상태: CANCELLED\n" + amounts, order.toSummaryText());
    }
}
