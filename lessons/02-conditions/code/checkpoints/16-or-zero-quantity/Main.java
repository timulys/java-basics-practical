package study.javaorder;

public class Main {
    public static void main(String[] args) {
        boolean available = true;
        int quantity = 0;
        boolean needsCheck = !available || quantity <= 0;
        System.out.println("조건 확인 필요: " + needsCheck);
    }
}
