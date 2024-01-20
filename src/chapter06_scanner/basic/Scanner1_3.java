package chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_3 {
    /*
        사용자가 입력한 문자열을 그대로 출력
        "exit"를 입력하기 전까지 계속 반복
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true){
            System.out.println("출력할 문자열을 입력하고 enter를 누르세요. ('exit'를 입력하면 종료됩니다.)");
            str = sc.nextLine();

            if(str.equals("exit")){
                System.out.println(str+"가 입력되어 프로그램을 종료합니다.");
                break;
            }else {
                System.out.println("console: "+str);
            }
        }
        sc.close();
    }
}
