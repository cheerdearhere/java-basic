package step01_beginner.chapter06_scanner.ex;

public class Scanner3Question {
    /*
    변수 a는 10, b는 20이 들어있다. 이 두 변수의 값을 서로 바꾸고 출력
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp = a;
        a=b;
        b=temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
