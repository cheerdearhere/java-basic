package chapter04_loop;

import java.util.Random;

public class Loop3 {
    public static void main(String[] args){
//      break:  주어진 수에서 3씩 더했을때 처음으로 50보다 커졌을때의 수 출력
        Random r = new Random();
        int num = r.nextInt(-20,30);
        int i = 0;
        int d = 3;
        System.out.println("시작: " + num);
        while(true) {
            if(num>50){
                System.out.println(i+"th num = " + num);
                break;
            }
            ++i;
            num+=d;
        }
//      continue: 1~n까지의 수를 출력하는 중 3의 배수는 x로 출력
        i = 0;
        while(i<num){
            ++i;
            if(i%3==0){
                System.out.println("X");
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}
