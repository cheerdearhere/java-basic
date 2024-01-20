package chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_2 {
    /*
    두 수를 입력받고 둘 중 더 큰 수를 출력하는 프로그램.
    같을 경우 같다고 표시
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 수를 입력해주세요");
        double num1 = sc.nextDouble();
        System.out.println("두번째 수를 입력해주세요");
        double num2 = sc.nextDouble();
        if(num2!=num1) {
            System.out.println("더 큰 수: "+(num2>num1?num2:num1));
        } else {
            System.out.println("두 수는 같습니다.");
        }
        sc.close();
    }
}
