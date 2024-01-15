package chapter03_condition.ex;

import java.util.Random;

public class Condition7Question {
    /*
    문제7.홀수, 짝수 찾기
    임의의 정수 x가 주어졌을때
    x가 짝수면 "짝수"를 홀수면 "홀수를 출력"
     */
    public static void main(String[] args) {
        Random r = new Random();
        int x = r.nextInt();
        String message=x%2==0?"짝수":"홀수";
        System.out.println(x+" => " + message);
    }
}
