package chapter07_Array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Question {
    /*
    문제2 - 배열의 입력과 출력
    사용자에게 5개의 정수를 입력받아서 배열에 저장하고, 입력 순서대로 출력하자.
    출력시 출력 포멧은 1, 2, 3, 4, 5와 같이 , 쉼표를 사용해서 구분하고, 마지막에는 쉼표를 넣지 않아야 한다.
    실행 결과 예시를 참고하자.
        실행 결과 예시
        5개의 정수를 입력하세요:
        1
        2
        3
        4
        5
        출력
        1, 2, 3, 4, 5
     */
    public static void main(String[] args) {
        int[] userNum = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("5개의 정수를 입력하세요.");
        for(int i = 0;i<userNum.length;i++){
            userNum[i] = sc.nextInt();
        }
        sc.close();
        for (int i=0 ;i<userNum.length; i++) {
            System.out.print(userNum[i]+(i!=(userNum.length-1)?", ":""));
        }
    }
}
