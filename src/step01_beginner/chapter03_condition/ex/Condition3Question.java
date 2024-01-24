package step01_beginner.chapter03_condition.ex;

import java.util.Random;

public class Condition3Question {
    /*
    문제3: 환율계산하기
    특정 금액을 미국 달러에서 한국 원으로 변환하는 프로그램 작성.
    환율은 1달러당 1300원이라고 가정.
        달러가 0미만이면 "잘못된 금액입니다."
        달러가 0일때 "환전할 금액이 없습니다."
        달러가 0초과일때 "환전 금액은 (계산 결과)원입니다."
     */
    public static void main(String[] args){
        Random r = new Random();
        int dollar = r.nextInt(-10,10);
        if(dollar<0) System.out.println("잘못된 금액입니다. \n $"+dollar);
        else if (dollar==0) System.out.println("환전할 금액이 없습니다. \n $"+dollar);
        else {
            int won = dollar * 1300;
            System.out.println("환전 금액은 "+won+"원 입니다. \n $"+dollar);
        }
    }
}
