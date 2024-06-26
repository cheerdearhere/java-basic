package step03_middleClass.chapter07_InnerClass.localClass;

import java.lang.reflect.Field;

public class CheckVariableLifecycle {
    private int outInstanceVariable = 3;
    public Printer process(int paramVariable){
        int localVariable = 1;

        class LocalPrinter implements Printer{
            int variable = 0;

            @Override
            public void print() {
                System.out.println("variable: "+variable);//지역 클래스 내의 지역변수
                System.out.println("local variable: "+localVariable);//지역 클래스와 같은 스코프의 지역변수
                System.out.println("parameter variable: "+paramVariable);//매개변수는 지역변수의 한종류
                System.out.println("outer instance variable: "+outInstanceVariable);// 외부 클래스의 멤버
            }
        }
        return new LocalPrinter();
//        printer.print();
    }

    public static void main(String[] args) {
        CheckVariableLifecycle localOuter = new CheckVariableLifecycle();
        Printer printer = localOuter.process(2);//stack 프레임 제거 후 처리
            //스택 프레임이 제거된 후 = 지역변수는 이미 제거된 상태
        printer.print();

        System.out.println("check field class name");
        Field[] fields = printer.getClass().getDeclaredFields();
        int counter = 0;
        for(Field field : fields){
            counter++;
            System.out.print("\t"+counter+". "+field+"\n");
        }
    }
}
