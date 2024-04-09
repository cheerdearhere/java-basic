package step03_middleClass.chatper02_Immutable.primitiveReference;

public class PrimitiveMain {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b++;
        System.out.println("a = " + a);//10
        System.out.println("b = " + b);//11
    }
}
