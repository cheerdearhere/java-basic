package step03_middleClass.chapter07_InnerClass.localCInner;

public class LocalOuter {
    private int outInstanceVariable = 3;
    public void process(int paramVariable){
        int localVariable = 1;
        class LocalPrinter{
            int variable = 0;
            public void printData(){
                System.out.println("variable: "+variable);//지역 클래스 내의 지역변수
                System.out.println("local variable: "+localVariable);//지역 클래스와 같은 스코프의 지역변수
                System.out.println("parameter variable: "+paramVariable);//매개변수는 지역변수의 한종류
                System.out.println("outer instance variable: "+outInstanceVariable);// 외부 클래스의 멤버
            }
        }
        LocalPrinter printer = new LocalPrinter();
        printer.printData();
    }

    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        localOuter.process(2);
    }
}
