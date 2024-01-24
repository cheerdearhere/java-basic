package step01_beginner.chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_4 {
    /*
    첫번째 숫자와 두번째 숫자를 출력하는 프로그램 개발
    첫 수자와 두번째 숫자를 모두 0으로 입력하면 프로그램 종료
    그전까지 반복 진행
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
        for(;;){
            System.out.println("첫번째 수 입력 (0,0 입력시 프로그램 종료)");
            a=scanner.nextInt();
            System.out.println("두번째 수 입력 (0,0 입력시 프로그램 종료)");
            b=scanner.nextInt();
            System.out.println("["+a+","+b+"]");
            if(a==0&&b==0) {
                System.out.println("[0,0]이 입력되어 프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}
