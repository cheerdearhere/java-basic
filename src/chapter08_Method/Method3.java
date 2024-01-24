package chapter08_Method;

public class Method3 {
    public static void main(String[] args) {
        double number = 1.5;
//        printNumber(number);double을 int로 대입하므로 에러 발생
        printNumber((int)number);
        int intNum = 100;
        printDoubleNumber(100);//묵시적형변환 발생
    }
    private static void printNumber(int n){
        System.out.println("숫자: "+n);
    }
    private static void printDoubleNumber(double n){
        System.out.println("숫자: "+n);
    }

}
