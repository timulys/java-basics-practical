package study.javaorder;

public class Main {
    public static void main(String[] args) {
        long subtotal = 60_000L;
        System.out.println("60000 >= 50000: " + (subtotal >= 50_000L));
        System.out.println("49999 >= 50000: " + (49_999L >= 50_000L));
        System.out.println("50000 >= 50000: " + (50_000L >= 50_000L));
        int quantity = 2;
        System.out.println("quantity == 2: " + (quantity == 2));
        System.out.println("quantity != 2: " + (quantity != 2));
    }
}
