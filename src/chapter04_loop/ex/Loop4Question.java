package chapter04_loop.ex;

import java.util.Random;

public class Loop4Question {
    /*
    문제4. 피라미드 출력
    int rows 를 선언해라.
    이 수만큼 다음과 같은 피라미드를 출력하면 된다.
     */
    public static void main(String[] args) {
        Random r = new Random();
        int rows = r.nextInt(1,20);
        for(int i=0;i<rows;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("rows = " + rows);
    }
}
