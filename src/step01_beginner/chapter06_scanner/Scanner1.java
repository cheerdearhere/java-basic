package step01_beginner.chapter06_scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요.");//안내용 문자열
        String str = scanner.nextLine();//문자열 입력대기(Enter키를 입력할때까지 대기)
        System.out.println("입력한 문자열: "+str);//입력 받은 값 출력

        System.out.println("정수를 입력하세요");
        int intNum = scanner.nextInt();
        System.out.println("입력한 정수: " + intNum);

        System.out.println("실수를 입력하세요");
        double doubleNum = scanner.nextDouble();
        System.out.println("입력한 실수 " + doubleNum);

    }
}