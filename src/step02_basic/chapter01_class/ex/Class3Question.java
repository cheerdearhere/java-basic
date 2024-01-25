package step02_basic.chapter01_class.ex;

import java.util.Scanner;

public class Class3Question {
    /*
    문제3: 상품 주문 시스템 개발
문제 설명
    당신은 온라인 상점의 주문 관리 시스템을 만들려고 한다.
    먼저, 상품 주문 정보를 담을 수 있는 ProductOrder 클래스를 만들어보자.
요구 사항
    1. ProductOrder 클래스는 다음과 같은 멤버 변수를 포함해야 한다.
    상품명 ( productName )
    가격 ( price )
    주문 수량 ( quantity )
    2. ProductOrderMain 클래스 안에 main() 메서드를 포함하여, 여러 상품의 주문 정보를 배열로 관리하고, 그
    정보들을 출력하고, 최종 결제 금액을 계산하여 출력하자.
    3. 출력 예시와 같도록 출력하면 된다.
예시 코드 구조
java
    public class ProductOrder {
     String productName;
     int price;
     int quantity;
    }

java
    public class ProductOrderMain {
     public static void main(String[] args) {
     // 여러 상품의 주문 정보를 담는 배열 생성
     // 상품 주문 정보를 `ProductOrder` 타입의 변수로 받아 저장
     // 상품 주문 정보와 최종 금액 출력
     }
    }

출력 예시
    상품명: 두부, 가격: 2000, 수량: 2
    상품명: 김치, 가격: 5000, 수량: 1
    상품명: 콜라, 가격: 1500, 수량: 2
    총 결제 금액: 12000
     */
    public static void main(String[] args) {
        //상품 주문 정보를 담는 배열 생성
        ProductOrder[] productOrders;
        int orderCount;
        //상품 주문 정보를 ProductOrder 타입의 변수로 받아 저장
        Scanner scanner = new Scanner(System.in);
        int inputInt;
        String inputString;

        System.out.print("상품 주문 정보를 입력합니다. \n입력할 상품의 종류는 몇개입니까? ");
        inputInt = scanner.nextInt();
        orderCount = inputInt;

        productOrders = new ProductOrder[orderCount];
        for(int i=0;i<productOrders.length;i++){
            scanner.nextLine();
            ProductOrder po = new ProductOrder();

            System.out.print("상품명: ");
            inputString = scanner.nextLine();
            po.productName = inputString;
            System.out.print("/ 가격: ");
            inputInt = scanner.nextInt();
            po.price = inputInt;
            System.out.print("/ 수량: ");
            inputInt = scanner.nextInt();
            po.quantity = inputInt;

            productOrders[i] = po;
        }
        // 상품 주문 정보와 최종 금액 출력
        int sum = 0;
        for(ProductOrder po : productOrders){
            System.out.println("상품명: "+po.productName+", 가격: "+po.price+", 수량: "+po.quantity);
            sum+=(po.price * po.quantity);
        }
        System.out.println("총 결제 금액: "+sum);
    }
}
