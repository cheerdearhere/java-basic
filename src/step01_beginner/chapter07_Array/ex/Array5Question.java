package step01_beginner.chapter07_Array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Array5Question {
    /*
    문제5 - 합계와 평균2
    이전 문제에서 입력받을 숫자의 개수를 입력받도록 개선하자.
    실행 결과 예시를 참고하자
        실행 결과 예시1
        입력받을 숫자의 개수를 입력하세요:3
        3개의 정수를 입력하세요:
        1
        2
        3
        입력한 정수의 합계: 6
        입력한 정수의 평균: 2.0 ```
        실행 결과 예시2 ```
        입력받을 숫자의 개수를 입력하세요:5
        5개의 정수를 입력하세요:
        1
        2
        3
        4
        5
        입력한 정수의 합계: 15
        입력한 정수의 평균: 3.0 ```
     */
    public static void main(String[] args) {
        int count;
        int temp;
        int[] numbers;
        int sum=0;
        double avg;
        Scanner sc = new Scanner(System.in);

//        입력받을 숫자의 개수를 입력하세요:5
        System.out.println("입력받을 숫자의 개수를 입력하세요:");
        count = sc.nextInt();
//        5개의 정수를 입력하세요:
        System.out.println(count+"개의 정수를 입력하세요:");
        numbers = new int[count];
        for(int i=0;i<count;i++){
            temp = sc.nextInt();
            numbers[i]=temp;
        }
        sc.close();
//        입력한 정수의 합계: 15
        sum = Arrays.stream(numbers).sum();
        System.out.println("입력한 정수의 합계:"+sum);

//        입력한 정수의 평균: 3.0
        avg = Arrays.stream(numbers).average().getAsDouble();
        System.out.println("입력한 정수의 평균:"+avg);

    }
}
