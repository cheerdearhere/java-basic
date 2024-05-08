package step03_middleClass.chapter07_InnerClass.useNested.calc_useLocalInnerClass;

import step03_middleClass.chapter07_InnerClass.useNested.calc_useStaticNested.Process;

import java.util.Random;

public class UseLocalInnerClass {
    public static void  helloInner(Process process){
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }
    public static void main(String[] args) {
        //local inner class
        class Dice implements Process {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위: "+randomValue);
            }
        }
        class Sum implements Process{
            @Override
            public void run() {
                for(int i = 1; i<=3; i++){
                    System.out.println("i: "+i);
                }
            }
        }
        helloInner(new Dice());
        helloInner(new Sum());
    }
}
