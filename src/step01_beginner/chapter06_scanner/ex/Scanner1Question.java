package step01_beginner.chapter06_scanner.ex;

import java.util.Scanner;

public class Scanner1Question {
    /*
    사용자로부터 음식의 이름(foodName), 가격(foodPrice), 수량(foodQuantity)을 입력받아
    음식의 총 가격을 계산하고 출력하는 프로그램을 작성하세요
    음식의 총 가격을 totalPrice라는 변수에 저장하세요
    주문 정보와 총 가격을 출력하세요.
    ex)
        음식 이름을 입력해주세요: 피자
        음식의 가격을 입력해주세요: 20000
        음식의 수량을 입력해주세요: 2
        피자 2개를 주문하셨습니다. 총 가격은 40000원입니다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("음식의 이름을 입력해주세요: ");
        String foodName=sc.nextLine();
        System.out.println("음식의 가격을 입력해주세요: ");
        int foodPrice = sc.nextInt();
        System.out.println("음식의 수량을 입력해주세요: ");
        int foodQuantity = sc.nextInt();
        System.out.println("order: "+foodName+" "+foodQuantity+"개를 주문하셨습니다. 총 가격은 "+(foodPrice*foodQuantity)+"원 입니다.");
        sc.close();
    }
}
