package step03_middleClass.chapter07_InnerClass.useNested.calc_useStaticNested;

import java.util.Random;

public class ReceiveSource {
    public static void calcDice(){
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위: "+randomValue);
    }
    public static void calcSum(){
        for(int i = 1; i<=3; i++){
            System.out.println("i: "+i);
        }
    }
    public static void helloCalc(int type){
        System.out.println("프로그램 시작");
        switch (type){
            case 1:
                calcDice();
                break;
            case 2:
                calcSum();
                break;
            default:
                System.out.printf("잘못된 입력: %d",type);
                break;
        }
        System.out.println("프로그램 종료");
    }
    public static void main(String[] args) {
        helloCalc(1);
        helloCalc(2);
    }
}
