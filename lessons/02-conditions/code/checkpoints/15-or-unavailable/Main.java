package study.javaorder;

public class Main {
    public static void main(String[] args) {
        boolean available = false;
        int quantity = 2;
        boolean needsCheck = !available || quantity <= 0;
        System.out.println("조건 확인 필요: " + needsCheck);
    }
}
