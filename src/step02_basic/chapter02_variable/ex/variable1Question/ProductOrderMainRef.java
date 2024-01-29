package step02_basic.chapter02_variable.ex.variable1Question;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProductOrderMainRef {
    /*
문제1: 상품 주문 시스템 개발 - 리팩토링
문제 설명
    앞서 만들었던 다음 클래스에 있는 "상품 주문 시스템"을 리팩토링 하자.
    당신은 온라인 상점의 주문 관리 시스템을 만들려고 한다.
    먼저, 상품 주문 정보를 담을 수 있는 ProductOrder 클래스를 만들어보자.
요구 사항
    ProductOrder 클래스는 다음과 같은 멤버 변수를 포함해야 한다.
        상품명 ( productName )
        가격 ( price )
        주문 수량 ( quantity )
    예시 코드 구조
        package ref.ex;
        public class ProductOrder {
         String productName;
         int price;
         int quantity;
        }
    주문 수량을 입력 받자
        예) 입력할 주문의 개수를 입력하세요:
    가격, 수량, 상품명을 입력 받자
      입력시 상품 순서를 알 수 있게 "n번째 주문 정보를 입력하세요." 라는 메시지를 출력하세요.
      입력이 끝나면 등록한 상품과 총 결제 금액을 출력하자.
    ProductOrderMain2 클래스 안에 main() 메서드를 포함하여,
    여러 상품의 주문 정보를 배열로 관리하고, 그 정보들을 출력하고,
    최종 결제 금액을 계산하여 출력하자.
이 클래스에서는 다음과 같은 메서드를 포함해야 합니다:
    static ProductOrder createOrder(String productName, int price, int quantity)
        ProductOrder 를 생성하고 매개변수로 초기값을 설정합니다. 마지막으로 생성한 ProductOrder 를반환합니다.
    static void printOrders(ProductOrder[] orders)
        배열을 받아서 배열에 들어있는 전체 ProductOrder 의 상품명, 가격, 수량을 출력합니다.
    static int getTotalAmount(ProductOrder[] orders)
        배열을 받아서 배열에 들어있는 전체 ProductOrder 의 총 결제 금액을 계산하고,
        계산 결과를 반환합니다.
예시 코드 구조
        public class ProductOrderMain2 {
         public static void main(String[] args) {
         // 여러 상품의 주문 정보를 담는 배열 생성
         // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
         // printOrders()를 사용해서 상품 주문 정보 출력
         // getTotalAmount()를 사용해서 총 결제 금액 계산
         // 총 결제 금액 출력
         }
        }
출력 예시
    입력할 주문의 개수를 입력하세요: 3
    1번째 주문 정보를 입력하세요.
    상품명: 두부
    가격: 2000
    수량: 2
    2번째 주문 정보를 입력하세요.
    상품명: 김치
    가격: 5000
    수량: 1
    3번째 주문 정보를 입력하세요.
    상품명: 콜라
    가격: 1500
    수량: 2
    상품명: 두부, 가격: 2000, 수량: 2
    상품명: 김치, 가격: 5000, 수량: 1
    상품명: 콜라, 가격: 1500, 수량: 2
    총 결제 금액: 12000
     */
    public static void main(String[] args) {
        //상품 주문 정보를 담는 배열 생성
        ProductOrder[] productOrders;
        int orderCount;
        int inputInt;
        // 상품 데이터 입력용
        String productName;
        int productPrice;
        int productQuantity;

        //상품 주문 정보를 ProductOrder 타입의 변수로 받아 저장
        Scanner scanner = new Scanner(System.in);

        System.out.print("상품 주문 정보를 입력합니다. \n입력할 주문의 개수를 입력하세요: ");
        inputInt = scanner.nextInt();
        orderCount = inputInt;
        productOrders = new ProductOrder[orderCount];

        for(int i=0;i<productOrders.length;i++){
            scanner.nextLine();
            System.out.println((i+1)+"번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            productName = scanner.nextLine();
            System.out.print("/ 가격: ");
            productPrice = scanner.nextInt();
            System.out.print("/ 수량: ");
            productQuantity = scanner.nextInt();

            ProductOrder po = createOrder(productName,productPrice,productQuantity);
            productOrders[i] = po;
        }
        scanner.close();
        // 상품 주문 정보와 최종 금액 출력
        printOrders(productOrders);
        System.out.println("총 결제 금액: "+getTotalAmount(productOrders)+"원");
    }

    /**
     * ProductOrder 를 생성하고 매개변수로 초기값을 설정합니다. 마지막으로 생성한 ProductOrder 를반환합니다.
     * @param productName 상품명
     * @param price 상품가격
     * @param quantity 주문 수량
     * @return 주문 정보
     */
    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;
        return productOrder;
    }

    /**
     * 배열을 받아서 배열에 들어있는 전체 ProductOrder 의 상품명, 가격, 수량을 출력합니다.
     * @param orders 주문 목록을 지닌 배열
     */
    static void printOrders(ProductOrder[] orders){
        for(ProductOrder po : orders){
            System.out.println("상품명: "+po.productName+", 가격: "+po.price+", 수량: "+po.quantity);
        }
    }

    /**
     * 배열을 받아서 배열에 들어있는 전체 ProductOrder 의 총 결제 금액을 계산하고, 계산 결과를 반환합니다.
     * @param orders 주문 목록을 지닌 배열
     * @return 주문 목록의 수량과 가격을 기준으로 계산한 총액
     */
    static int getTotalAmount(ProductOrder[] orders){
        return Arrays.stream(orders).mapToInt(order->order.quantity*order.price).sum();
    }
}
