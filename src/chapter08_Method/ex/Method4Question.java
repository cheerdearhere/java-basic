package chapter08_Method.ex;

import chapter04_loop.Loop1;

import java.util.Random;
import java.util.Scanner;

public class Method4Question {
    /*
    문제 4- 은행 계좌 입출금
        다음 실행 예시를 참고해서, 사용자로부터 계속 입력을 받아 입금과 출금을 반복 수행하는 프로그램을 작성하자.
        또한 간단한 메뉴를 표시하여 어떤 동작을 수행해야 할지 선택할 수 있게 하자
        출금시 잔액이 부족하다면 "x원을 출금하려 했으나 잔액이 부족합니다."라고 출력해야 한다.
        실행 예시
            ---------------------------------
            1.입금 | 2.출금 | 3.잔액 확인 | 4.종료
            ---------------------------------
            선택: 1
           : 10000
            10000원을 입금하였습니다. 현재 잔액: 10000원
            ---------------------------------
            1.입금 | 2.출금 | 3.잔액 확인 | 4.종료
            ---------------------------------
            선택: 2
            출금액을 입력하세요: 8000
            8000원을 출금하였습니다. 현재 잔액: 2000원
            ---------------------------------
            1.입금 | 2.출금 | 3.잔액 확인 | 4.종료
            ---------------------------------
            선택: 2
            출금액을 입력하세요: 3000
            3000원을 출금하려 했으나 잔액이 부족합니다.
            ---------------------------------
            1.입금 | 2.출금 | 3.잔액 확인 | 4.종료
            ---------------------------------
            선택: 3
            현재 잔액: 2000원
            ---------------------------------
            1.입금 | 2.출금 | 3.잔액 확인 | 4.종료
            ---------------------------------
            선택: 4
            시스템을 종료합니다.
     */
    public static void main(String[] args) {
        Random random = new Random();
        int balance = random.nextInt(1000,10*10000);
        int userSelect;
        int amount;
        int retryCnt=5;
        Scanner sc = new Scanner(System.in);
        Loop1: while (true){
            if(retryCnt==0){
                System.out.println("5회 오류로 프로그램을 종료합니다.");
                break;
            }
            System.out.print(
                    "---------------------------------\n" +
                    "1.입금 | 2.출금 | 3.잔액 확인 | 4.종료\n" +
                    "---------------------------------\n" +
                    "선택: ");
            userSelect =sc.nextInt();
            switch (userSelect){
                case 1:
                    System.out.print("입금액을 입력하세요: ");
                    amount = sc.nextInt();
                    balance= deposit(balance, amount);
                    break;
                case 2:
                    System.out.print("출금액을 입력하세요: ");
                    amount=sc.nextInt();
                    balance=withdraw(balance,amount);
                    break;
                case 3:
                    getBalance(balance);
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    break Loop1;
                default:
                    --retryCnt;
                    System.out.println("잘못입력하셨습니다. 5회 연속 오류시 시스템을 종료합니다. \n    잔여횟수: "+retryCnt+"회");
                    break;
            }
        }


    }
    private static int deposit(int balance,int amount){
        balance+=amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        return balance;
    }
    private static int withdraw(int balance, int amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
    private static void getBalance(int balance){
        System.out.println("최종 잔액: " + balance + "원");
    }
}
