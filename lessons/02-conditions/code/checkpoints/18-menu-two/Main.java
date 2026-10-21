package study.javaorder;

public class Main {
    public static void main(String[] args) {
        int menu = 2;
        switch (menu) {
            case 1:
                System.out.println("메뉴 안내: 상품 조회");
                break;
            case 2:
                System.out.println("메뉴 안내: 장바구니 보기");
                break;
            default:
                System.out.println("메뉴 안내: 1 또는 2를 선택해 주세요");
                break;
        }
    }
}
