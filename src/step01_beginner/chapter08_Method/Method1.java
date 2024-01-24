package step01_beginner.chapter08_Method;

public class Method1 {
    public static void main(String[] args) {
        printHeader();
        int res = add(1,2);
        System.out.println(res);
        printFooter("홍길동");
    }
    private static int add(int a, int b){
        return a+b;
    }
    private static void printHeader(){
        System.out.println("= 프로그램을 시작합니다 =");
    }
    private static void printFooter(String userName){
        System.out.println("= 프로그램을 종료합니다 =\n user: "+userName);
    }
}
