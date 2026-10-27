package study.javaorder;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class ConsoleOrderApp {
    private final Scanner input;
    private final PrintStream output;
    private final ReceiptFileStore store;
    private final ProductCatalog catalog = new ProductCatalog();
    private final Cart cart = new Cart();
    private final OrderService service = new OrderService(
            catalog, new ThresholdFixedDiscountPolicy());
    private Order recentOrder;

    public ConsoleOrderApp(
            Scanner input, PrintStream output, ReceiptFileStore store) {
        if (input == null || output == null || store == null) {
            throw new IllegalArgumentException("입력, 출력과 저장소가 필요합니다.");
        }
        this.input = input;
        this.output = output;
        this.store = store;
        catalog.register(new Product("P001", "키보드", 30_000L, "주변기기"));
        catalog.register(new Product("P002", "마우스", 15_000L, "주변기기"));
        catalog.register(new Product("P003", "노트", 5_000L, "문구"));
    }

    public void run() {
        printMenu();
        while (input.hasNextLine()) {
            String command = input.nextLine().strip();
            try {
                switch (command) {
                    case "0" -> {
                        output.println("프로그램을 종료합니다.");
                        return;
                    }
                    case "1" -> findProduct();
                    case "2" -> addProduct();
                    case "3" -> printCart();
                    case "4" -> changeQuantity();
                    case "5" -> removeProduct();
                    case "6" -> placeOrder();
                    case "7" -> output.print(requireRecentOrder().toSummaryText());
                    case "8" -> saveRecentOrder();
                    case "9" -> output.print(store.read());
                    case "10" -> printCategorySubtotal();
                    default -> throw new IllegalArgumentException(
                            "메뉴는 0~10 중에서 선택해 주세요.");
                }
            } catch (NoSuchFileException e) {
                output.println("저장된 주문 요약이 없습니다.");
            } catch (IOException e) {
                output.println("파일을 처리하지 못했습니다: " + e.getMessage());
            } catch (IllegalArgumentException | IllegalStateException e) {
                output.println("요청을 처리하지 못했습니다: " + e.getMessage());
            }
            printMenu();
        }
        output.println("입력이 끝나 프로그램을 종료합니다.");
    }

    private void printMenu() {
        output.println("\n1 상품 조회 | 2 담기 | 3 장바구니 | 4 수량 변경 | 5 빼기");
        output.println("6 주문 확정 | 7 최근 주문 | 8 요약 저장 | 9 저장 요약"
                + " | 10 카테고리 합계 | 0 종료");
        output.println("상품 코드: P001 키보드 / P002 마우스 / P003 노트");
        output.print("메뉴: ");
    }

    private String readLine(String prompt) {
        output.print(prompt);
        if (!input.hasNextLine()) {
            throw new IllegalStateException("입력이 끝났습니다.");
        }
        return input.nextLine().strip();
    }

    private int readQuantity() {
        String text = readLine("수량: ");
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수량은 정수로 입력해 주세요.");
        }
    }

    private void findProduct() {
        Product product = catalog.findRequired(
                readLine("상품 코드: "));
        output.println(product.getCode() + " / " + product.getName()
                + " / 단가 " + product.getUnitPrice()
                + "원 / " + product.getCategory());
    }

    private void addProduct() {
        String code = readLine("상품 코드: ");
        int quantity = readQuantity();
        service.addByCode(cart, code, quantity);
        output.println("상품을 담았습니다.");
    }

    private void printCart() {
        output.println("[현재 장바구니]");
        for (OrderItem item : cart.getItems()) {
            output.println(item.getProduct().getCode()
                    + " / " + item.getProduct().getName()
                    + " / 수량 " + item.getQuantity()
                    + " / 항목 금액 " + item.calculateLineTotal() + "원");
        }
        output.println("상품 종류 수: " + cart.size());
        output.println("상품 금액: " + cart.calculateSubtotal() + "원");
    }

    private void changeQuantity() {
        String code = readLine("상품 코드: ");
        int quantity = readQuantity();
        cart.changeQuantity(code, quantity);
        output.println("수량을 변경했습니다.");
    }

    private void removeProduct() {
        String code = readLine("상품 코드: ");
        if (!cart.remove(code)) {
            throw new IllegalArgumentException("담지 않은 상품입니다: " + code);
        }
        output.println("상품을 뺐습니다.");
    }

    private void placeOrder() {
        recentOrder = service.placeOrder(cart);
        output.println("[주문 확정]");
        output.print(recentOrder.toSummaryText());
    }

    private Order requireRecentOrder() {
        if (recentOrder == null) {
            throw new IllegalStateException("먼저 주문을 확정해 주세요.");
        }
        return recentOrder;
    }

    private void saveRecentOrder() throws IOException {
        store.save(requireRecentOrder().toSummaryText());
        output.println("주문 요약을 저장했습니다.");
    }

    private void printCategorySubtotal() {
        String category = readLine("카테고리: ");
        output.println(category + " 상품 금액: "
                + cart.calculateSubtotalByCategory(category) + "원");
    }
}
