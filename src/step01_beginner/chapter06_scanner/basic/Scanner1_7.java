package step01_beginner.chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_7 {
    /*
        하나의 정수를 입력받아 이 수가 홀수인지 짝수인지 판별
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 하나를 입력해주세요.");
        int num = sc.nextInt();
        System.out.println("입력한 수("+num+")는 "+(num%2==0?"짝수":"홀수")+"입니다.");
        sc.close();
    }
}
