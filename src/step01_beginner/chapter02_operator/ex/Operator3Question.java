package step01_beginner.chapter02_operator.ex;

import java.util.Random;

public class Operator3Question {
    /*
    문제3. 다음 작업을 수행하는 프로그램 작성
        int 형 변수 score 선언
        score가 80 이상, 100 이하면 true를 출력하고 아니면 false를 출력
     */
    public static void main(String[] args) {
        Random random = new Random();
        int score = random.nextInt(0,100);
        System.out.println("score = " + score);
        boolean res = score>=80 && score<=100;
        System.out.println("res = " + res);
    }
}
