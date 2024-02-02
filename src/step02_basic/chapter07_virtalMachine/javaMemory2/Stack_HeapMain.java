package step02_basic.chapter07_virtalMachine.javaMemory2;


public class Stack_HeapMain {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    static void method1() {
        System.out.println("method1 start");
        Data data = new Data(1);
        method2(data);
        System.out.println("method1 end");
    }

    static void method2(Data data) {
        System.out.println("method2 start");
        System.out.println("data.value = " + data.getValue());
        System.out.println("method2 end");
    }
}
