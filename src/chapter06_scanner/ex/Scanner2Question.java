package chapter06_scanner.ex;

import java.util.Scanner;

public class Scanner2Question {
    /*
    사용자로부터 하나의 정수 n을 입력받아 정수 n의 구구단을 출력하는 프로그램
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요.");
        int num = sc.nextInt();
        for(int i = 1; i<=9 ; i++){
            System.out.println(num+" x "+i+" = "+(num*i));
        }
        sc.close();
    }
}
