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
        int max = a>b?a:b;
        System.out.println("a:"+a+"/ b:"+b);
        System.out.println("더 큰 숫자는 "+max+"입니다.");
    }
}
