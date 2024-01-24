package step01_beginner.chapter07_Array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Array4Question {
    /*
    문제4 - 합계와 평균
    사용자에게 5개의 정수를 입력받아서 이들 정수의 합계와 평균을 계산하는 프로그램을 작성하자.
        실행 결과 예시
        5개의 정수를 입력하세요:
        1
        2
        3
        4
        5
        입력한 정수의 합계: 15
        입력한 정수의 평균: 3.0
     */
    public static void main(String[] args) {
        int temp;
        int[] numbers =new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("5개의 정수를 입력하시오");
        for(int i=0;i<numbers.length;i++){
            temp = sc.nextInt();
            numbers[i] = temp;
        }
        sc.close();
        System.out.println("입력한 정수의 합계:"+ Arrays.stream(numbers).sum());
        System.out.println("입력한 정수의 평균:"+Arrays.stream(numbers).average().getAsDouble());
    }
}
