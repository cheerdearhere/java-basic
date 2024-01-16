package chapter04_loop.ex;

import java.util.Random;

public class Loop2Question {
    /*
    문제: 짝수 출력
    반복문을 사용하여 처음 10개의 짝수를 출력하는 프로그램을 작성해 보세요. 이때, num 이라는 변수를 사용하여 수를
    표현해야 합니다.
    while문, for문 2가지 버전의 정답을 만들어야 합니
     */
    public static void main(String[] args) {
        int i = 0;
        Random r = new Random();
        int num = r.nextInt(0,10);
        System.out.println("num = " + num);
        while(i<10){
            num++;
            if(num%2==0){
                System.out.println((i+1)+". "+num);
                i++;
                continue;
            }
        }
        i=0;
        num = r.nextInt(0,10);
        System.out.println("num = " + num);
        for(int j = 1;j<=10;j++){
            if(num%2==1) ++num;
            num+=2;
            System.out.println(j+"/ "+num);
        }
    }
}
