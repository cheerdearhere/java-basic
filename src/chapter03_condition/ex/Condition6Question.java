package chapter03_condition.ex;

import java.util.Random;
import java.util.stream.IntStream;

public class Condition6Question {
    /*
    문제6.더 큰 숫자 찾기
    두개의 임의의 정수 a, b가 주어질때 삼항연산자를 사용해 두 수중 더 큰 숫자를 출력하는 코드를 작성하기
     */
    public static void main(String[] args) {
        Random r = new Random();
        int a = r.nextInt();
        int b = r.nextInt();
        System.out.println("a:"+a+"/ b:"+b);
        System.out.println(a>b?a:b);
    }
}
