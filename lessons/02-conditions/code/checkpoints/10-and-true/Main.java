package study.javaorder;

public class Main {
    public static void main(String[] args) {
        boolean available = true;
        int quantity = 2;
        boolean canOrder = available && quantity > 0;
        System.out.println("주문 가능: " + canOrder);
    }
}
