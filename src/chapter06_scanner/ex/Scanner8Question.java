package chapter06_scanner.ex;

import chapter04_loop.Loop1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Scanner8Question {
    /*
    사용자로부터 상품 정보(상품명, 가격, 수량)를 입력받고, 이들의 총 가격을 출력하는 프로그램을 작성하세요.
    사용자는 여러 상품을 추가하고 결제할 수 있으며, 프로그램을 언제든지 종료할 수 있습니다.
    사용자에게 다음 세 가지 옵션을 제공해야 합니다:
        1: 상품 입력, 2: 결제, 3: 프로그램 종료.
    옵션은 정수로 입력받으며, 옵션을 저장하는 변수의 이름은 option 이어야 합니다.
    상품 입력 옵션을 선택하면, 사용자에게 상품명과 가격, 수량을 입력받으세요.
    결제 옵션을 선택하면, 총 비용을 출력하고 총 비용을 0 으로 초기화하세요.
    (사용자가 총 비용을 확인하고, 결제를 완료했다고 가정합니다.
    따라서 다음 사용자를 위해 총 비용을 다시 0 으로 초기화 해야합니다.)
    프로그램 종료 옵션을 선택하면, "프로그램을 종료합니다."라는 메시지를 출력하고 프로그램을 종료하세요.
    위의 세 가지 옵션 외에 다른 값을 입력하면, "올바른 옵션을 선택해주세요."라는 메시지를 출력하세요
        1: 상품 입력, 2: 결제, 3: 프로그램 종료
        1
        상품명을 입력하세요: JPA
        상품의 가격을 입력하세요: 40000
        구매 수량을 입력하세요: 2
        상품명:JPA 가격:40000 수량:2 합계:80000
        1: 상품 입력, 2: 결제, 3: 프로그램 종료
        2
        총 비용: 110000
        1: 상품 입력, 2: 결제, 3: 프로그램 종료
        3
        프로그램을 종료합니다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long todayEarn = 0;
        long sum = 0;
        StringBuilder receiptBuilder = new StringBuilder("구매 결정: \n");
        String product;
        int price,quantity;
        int count=0;
        int option;

        System.out.println("옵션을 선택하세요. ");
        Loop1: while(true){
            System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");
            option=sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("### 1번 상품 입력을 선택하셨습니다.");
                    System.out.println("상품명을 입력하세요: ");
                    product = sc.nextLine();
                    System.out.println("상품의 가격을 입력하세요: ");
                    price = sc.nextInt();
                    System.out.println("구매 수량을 입력하세요: ");
                    quantity = sc.nextInt();
                    ++count;
                    sum+=(price*quantity);
                    receiptBuilder.append(count).append(". ")
                            .append("상품명: ").append(product).append("/ ")
                            .append("가격: ").append(price).append("원/ ")
                            .append("수량: ").append(quantity).append("/ ")
                            .append("금액: ").append(price*quantity).append("원/ \n");
                    break;
                case 2:
                    System.out.println("### 2번 현재 거래 결제를 선택하셨습니다.");
                    receiptBuilder.append("****************************\n")
                            .append("총 합계: ").append(sum).append("원 \n")
                            .append("결제일: ")
                            .append(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
                    todayEarn+=sum;
                    System.out.println(receiptBuilder.toString());
                    count=1;
                    sum=0;
                    receiptBuilder = new StringBuilder("구매 결정: \n");
                    break;
                case 3:
                    System.out.println("### 3번 프로그램을 종료를 선택하셨습니다. \n오늘 총 매출: "+todayEarn+"원");
                    break Loop1;
                default:
                    System.out.println("잘못 선택하셨습니다. 올바른 옵션을 선택해주세요.");
                    break;
            }
        }
        sc.nextLine();


    }
}
