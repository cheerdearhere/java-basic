package chapter04_loop;

import java.util.Random;

public class Loop1 {
//    while 연습
    public static void main(String[] args) {
        int count = 0;
//        count++;
//        System.out.println("count: "+count);
//        count++;
//        System.out.println("count: "+count);
//        count++;
//        System.out.println("count: "+count);

//      while을 사용해 코드를 반복
        while(count < 3){
            count++;
            System.out.println("count: "+count);
        }
        System.out.println("반복문 종료: "+count);

//       등차수열의 합 구하기
//        1부터 하나씩 증가하는 수를 더하기
//        1 + 2 + 3 + ... + n
        int sum = 0;
        int i = 0;
        Random r = new Random();
        int endNum = r.nextInt(1,10);
        System.out.println("endNum = " + endNum);
        while (i<endNum){
            ++i;
            sum+=i;
            System.out.println("중간: i - "+i+"/ sum - "+sum);
        }
        System.out.println("결과 sum = " + sum);

//        입력된 수부터 연속된 3개의 수 더하기
        int num = r.nextInt(0,10);
        i = 0;
        sum=0;
        while(i<3){
            sum=sum+num+i;
            System.out.println(i+"번째 수 = " + (num + i));
            System.out.println(i+"번째 합 = " + sum);
            i++;
        }
        System.out.println("num = " + num);
        System.out.println("sum = " + sum);
    }
}
