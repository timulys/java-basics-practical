package study.javaorder;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReceiptFileStore store = new ReceiptFileStore(
                Path.of("data", "latest-order.txt"));
        new ConsoleOrderApp(input, System.out, store).run();
    }
}
