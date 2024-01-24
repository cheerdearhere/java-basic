package chapter08_Method;

public class Method4 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        double c = 1.0;
        double d = 2.0;
        System.out.println("param: int int - "+add(a,b));
        System.out.println("param: int int int - "+add(a,a,a));
        System.out.println("param: double double - "+add(c,d));
        System.out.println("param: double int - "+add(c,a));
        System.out.println("param: int double - "+add(a,c));
    }
    private static int add(int a, int b){
        return a+b;
    }
    private static int add(int a, int b, int c){
        return a+b+c;
    }
    private static int add(double a, double b){
        return (int)(a+b);
    }
    private static int add(double a, int b){
        return (int)a+b;
    }
    private static int add(int a, double b){
        return a+(int)b;
    }
}
