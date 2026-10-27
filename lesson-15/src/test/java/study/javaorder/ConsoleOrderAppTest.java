package study.javaorder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleOrderAppTest {
    @TempDir Path temp;

    private String run(String commands, Path file) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(bytes, true, StandardCharsets.UTF_8);
        new ConsoleOrderApp(new Scanner(commands), output, new ReceiptFileStore(file)).run();
        return bytes.toString(StandardCharsets.UTF_8);
    }

    @Test void savesOrderAndReadsItInANewApp() throws Exception {
        Path file = temp.resolve("data/latest-order.txt");
        String first = run("2\nP001\n2\n2\nP002\n1\n6\n8\n0\n", file);
        String stored = Files.readString(file, StandardCharsets.UTF_8);
        String restarted = run("9\n3\n7\n0\n", file);
        assertAll(
                () -> assertTrue(first.contains("주문 요약을 저장했습니다.")),
                () -> assertTrue(stored.contains("주문 상태: CONFIRMED")),
                () -> assertTrue(stored.contains("P001 / 키보드 / 수량 2 / 항목 금액 60000원")),
                () -> assertTrue(stored.contains("상품 금액: 75000원")),
                () -> assertTrue(stored.contains("최종 금액: 70000원")),
                () -> assertTrue(restarted.contains(stored)),
                () -> assertTrue(restarted.contains("상품 종류 수: 0")),
                () -> assertTrue(restarted.contains("먼저 주문을 확정해 주세요.")));
    }

    @Test void invalidRequestsKeepCartAndContinue() {
        String text = run("99\n2\nP001\n2\n2\nP999\n1\n4\nP001\n0\n2\nP001\nabc\n3\n0\n", temp.resolve("order.txt"));
        assertAll(
                () -> assertEquals(4, text.split("요청을 처리하지 못했습니다:", -1).length - 1),
                () -> assertTrue(text.contains("수량은 정수로 입력해 주세요.")),
                () -> assertTrue(text.contains("P001 / 키보드 / 수량 2 / 항목 금액 60000원")),
                () -> assertTrue(text.contains("상품 금액: 60000원")),
                () -> assertTrue(text.endsWith("프로그램을 종료합니다.\n")));
    }

    @Test void changingCartAfterOrderPreservesSavedSnapshot() throws Exception {
        Path file = temp.resolve("order.txt");
        String text = run("2\nP001\n2\n2\nP002\n1\n6\n4\nP001\n1\n3\n7\n8\n0\n", file);
        String stored = Files.readString(file);
        assertAll(
                () -> assertTrue(text.contains("P001 / 키보드 / 수량 1 / 항목 금액 30000원")),
                () -> assertTrue(stored.contains("P001 / 키보드 / 수량 2 / 항목 금액 60000원")),
                () -> assertTrue(stored.contains("최종 금액: 70000원")));
    }

    @Test void emptyOrderAndMissingFileDoNotStopMenu() {
        String text = run("6\n9\n7\n8\n2\nP001\n1\n6\n0\n", temp.resolve("missing.txt"));
        assertAll(
                () -> assertTrue(text.contains("빈 장바구니는 주문할 수 없습니다.")),
                () -> assertTrue(text.contains("저장된 주문 요약이 없습니다.")),
                () -> assertEquals(2, text.split("먼저 주문을 확정해 주세요.", -1).length - 1),
                () -> assertTrue(text.contains("최종 금액: 33000원")),
                () -> assertTrue(text.endsWith("프로그램을 종료합니다.\n")));
    }

    @Test void removesItemAndShowsCategorySubtotal() {
        String text = run("2\nP001\n2\n2\nP002\n1\n10\n주변기기\n5\nP002\n3\n0\n", temp.resolve("order.txt"));
        assertAll(
                () -> assertTrue(text.contains("주변기기 상품 금액: 75000원")),
                () -> assertTrue(text.contains("상품을 뺐습니다.")),
                () -> assertTrue(text.contains("상품 종류 수: 1")),
                () -> assertTrue(text.contains("상품 금액: 60000원")));
    }

    @Test void writeFailureKeepsRecentOrderAndMenuAlive() throws Exception {
        Path blocked = temp.resolve("blocked");
        Files.writeString(blocked, "부모 폴더 대신 파일");
        Path target = blocked.resolve("order.txt");
        String text = run("2\nP001\n2\n6\n8\n7\n0\n", target);
        assertAll(
                () -> assertTrue(text.contains("파일을 처리하지 못했습니다:")),
                () -> assertEquals(2, text.split("최종 금액: 55000원", -1).length - 1),
                () -> assertFalse(Files.exists(target)),
                () -> assertTrue(text.endsWith("프로그램을 종료합니다.\n")));
    }

    @Test void cancelledOrderCannotBeConfirmedAgainAndKeepsAmounts() {
        ProductCatalog catalog = new ProductCatalog();
        Product keyboard = new Product("P001", "키보드", 30_000L, "주변기기");
        catalog.register(keyboard);
        Cart cart = new Cart();
        cart.add(keyboard, 2);
        Order order = new OrderService(catalog, new ThresholdFixedDiscountPolicy()).placeOrder(cart);
        order.cancel();
        assertAll(
                () -> assertEquals(OrderStatus.CANCELLED, order.getStatus()),
                () -> assertEquals(60_000L, order.getSubtotal()),
                () -> assertEquals(55_000L, order.getTotal()),
                () -> assertThrows(IllegalStateException.class, order::confirm));
    }
}
