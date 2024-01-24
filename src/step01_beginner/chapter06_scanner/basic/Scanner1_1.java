package step01_beginner.chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_1 {
    /*
    두 수를 입력받고 그 합을 출력하기
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 정수를 입력해주세요.");
        int num1 = sc.nextInt();
        System.out.println("두번째 정수를 입력해주세요.");
        int num2 = sc.nextInt();
        System.out.println("입력된 식: "+num1+" + "+num2+" = "+(num2+num1));
        sc.close();
    }
}
