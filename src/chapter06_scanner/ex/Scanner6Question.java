package chapter06_scanner.ex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;

public class Scanner6Question {
    /*
    사용자로부터 상품의 가격( price )과 수량( quantity )을 입력받고,
    총 비용을 출력하는 프로그램을 작성하세요.
    가격과 수량을 입력받은 후에는 이들의 곱을 출력하세요.
    출력 형태는 "총 비용: [곱한 결과]"이어야 합니다.
    -1을 입력하여 가격 입력을 종료합니다.
        상품의 가격을 입력하세요 (-1을 입력하면 종료): 1000
        구매하려는 수량을 입력하세요: 3
        총 비용: 3000
        상품의 가격을 입력하세요 (-1을 입력하면 종료): 2000
        구매하려는 수량을 입력하세요: 4
        총 비용: 8000
        상품의 가격을 입력하세요 (-1을 입력하면 종료): -1
        프로그램을 종료합니다
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String receiptTitle = "<<영수증>> \n no    품목      가격      수량      금액\n";
        StringBuilder receiptBody = new StringBuilder();
        String product;
        int price;
        int quantity;
        int i = 1;
        int sum = 0;

        while(true){
            System.out.println("품목을 입력해주세요. ('끝'을 입력하면 프로그램을 종료합니다.)");
            product = sc.nextLine();
            if(product.equals("끝")){
                receiptBody.append("===========입력 종료===========\n");
                break;
            }
            System.out.println("품목의 가격을 입력해주세요. (-1을 입력하면 프로그램을 종료합니다.)");
            price = sc.nextInt();
            if(price==-1){
                receiptBody.append("===========입력 종료===========\n");
                break;
            }
            System.out.println("수량을 입력해주세요. (-1을 입력하면 프로그램을 종료합니다.)");
            quantity = sc.nextInt();
            if(quantity==-1){
                receiptBody.append("===========입력 종료===========\n");
                break;
            }
            sc.nextLine();
            sum+=price*quantity;
            receiptBody.append(i).append(".     ")
                    .append(product).append("       ")
                    .append(price).append("     ")
                    .append(quantity).append("      ")
                    .append(price * quantity)
                    .append("\n");
            i++;
        }
        sc.close();
        LocalDateTime current = LocalDateTime.now();
        receiptBody.append("합 계: ")
                .append(sum)
                .append("원\n")
                .append(current.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(receiptTitle+receiptBody.toString());
    }
}
