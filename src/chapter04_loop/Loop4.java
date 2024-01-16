package chapter04_loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loop4 {
    public static void main(String[] args) {
//        1~10까지 출력하기
        for(int i=0;i<11;i++){
            System.out.println("i = " + i);
        }
//        n부터 하나씩 증가하는 수를 i번 더하기
        Random r = new Random();
        int i = r.nextInt(1,10);
        int n = r.nextInt(-10,10);
        int sum = 0;
        for(int j = 0; j<i;j++){
            sum+=n+j;
            System.out.println("+"+(n+j));
        }
        System.out.println("result: "+sum);
//      무한 반복: 1부터 더하다가 n보다 커지면 종료
        n = r.nextInt(100,200);
        i=0;
        sum=0;
        for(;;){// == while(true)
            ++i;
            sum+=i;
            if(sum>n){
                System.out.println("n = " + n+"/ "+i+"th sum = " + sum);
                break;
            }
        }
//      enhancedFor: list에 들어있는 문자를 순서대로 출력하기
        List<String> lagArr = new ArrayList<>();
        lagArr.add("Java");
        lagArr.add("JavaScript");
        lagArr.add("Python");
        lagArr.add("SQL");
        for(String s:lagArr){
            System.out.println(s);
        }
    }
}
