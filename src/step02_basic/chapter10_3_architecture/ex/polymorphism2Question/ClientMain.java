package step02_basic.chapter10_3_architecture.ex.polymorphism2Question;

import step02_basic.chapter10_3_architecture.ex.polymorphism2Question.pay.PayStore;

import java.util.Scanner;

public class ClientMain {
/*
문제3 scanner를 사용해 사용자 입력 받기
결제 수단을 입력하세요:kakao
결제 금액을 입력하세요:5000
결제를 시작합니다: option=kakao, amount=5000
카카오페이 시스템과 연결합니다.
5000원 결제를 시도합니다.
결제가 성공했습니다.
결제 수단을 입력하세요:exit
프로그램을 종료합니다
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();
        final String exitCode = "exit";
        while (true){
            System.out.print(
                    "결제 수단을 입력하세요 "+
                    "\n   결제 수단 목록 ("+PayStore.getPayList() +
                    ")\n   종료 키워드 -  exit"+
                    ": "
            );
            String payOption = scanner.nextLine().toLowerCase();
            if(payOption.equalsIgnoreCase(exitCode)){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.print("결제 금액을 입력하세요: ");
            int amount = scanner.nextInt();
            scanner.nextLine();
            payService.processPay(payOption, amount);
        }
    }
}
