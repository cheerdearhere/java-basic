package chapter05_scope_casting;

public class Scope1 {
    public static void main(String[] args) {
        int m = 10;
        if(true){
            int x = 20;
            System.out.println("if x = " + x);
            System.out.println("if m = " + m);
        }
        System.out.println("main m = " + m);
//        System.out.println("main x = " + x); 변수가 선언된 블럭 외부에서 사용 불가

        int temp = 0;
        if(m>0){
            temp = m*2;
            System.out.println("temp = " + temp);
        }
//        if문 이후에서는 temp가 필요없음에도 계속 메모리에서 관리
    }
}
