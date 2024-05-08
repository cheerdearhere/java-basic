package step03_middleClass.chapter07_InnerClass.anonymous;

import step03_middleClass.chapter07_InnerClass.localClass.Printer;

import java.lang.reflect.Field;

public class AnonymousOuter {
    private int outInstanceVariable = 3;
    public Printer process(int paramVariable){
        int localVariable = 1;

//        class LocalPrinter implements Printer{
//            int variable = 0;
//            @Override
//            public void print() {
//                System.out.println("variable: "+variable);//지역 클래스 내의 지역변수
//                System.out.println("local variable: "+localVariable);//지역 클래스와 같은 스코프의 지역변수
//                System.out.println("parameter variable: "+paramVariable);//매개변수는 지역변수의 한종류
//                System.out.println("outer instance variable: "+outInstanceVariable);// 외부 클래스의 멤버
//            }
//        }
//        Printer printer = new LocalPrinter();
        //선언과 생성을 함께
            Printer printer =new Printer(){
                int variable = 0;
                @Override
                public void print() {
                    System.out.println("variable: "+variable);//지역 클래스 내의 지역변수
                    System.out.println("local variable: "+localVariable);//지역 클래스와 같은 스코프의 지역변수
                    System.out.println("parameter variable: "+paramVariable);//매개변수는 지역변수의 한종류
                    System.out.println("outer instance variable: "+outInstanceVariable);// 외부 클래스의 멤버
                }
        };
        return printer;
    }

    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        Printer printer = anonymousOuter.process(2);
        printer.print();
    }
}
