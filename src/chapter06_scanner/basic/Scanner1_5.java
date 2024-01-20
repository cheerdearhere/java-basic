package chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_5 {
    /*
        사용자의 입력을 받아 그 합계를 계산.
        한번에 하나씩 입력받으며 사용자가 0을 입력하면 종료
        종료될때 최종합을 표시
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long sum=0;
        int num;
        while (true){
            System.out.println("정수를 입력하세요(0을 입력하면 프로그램 종료)");
            num=sc.nextInt();
            sum+=num;
            if(num==0){
                System.out.println("0이 입력되어 프로그램을 종료합니다.");
                break;
            }
        }
        System.out.println("총합: "+sum);
        sc.close();
    }
}
