package chapter01_variable;

public class Var1 {
    public static void main(String[] args) {
//        변수 사용의 필요성
        System.out.println("##변수 사용 안함");
        System.out.println(10);
        System.out.println(10);
        System.out.println(10);
        // 하드코딩한 경우 값을 바꿀때 일일히 변경
        System.out.println("##변수를 사용한 경우");
        int num1; // 변수 선언
        num1= 10; // 변수의 초기값 입력
        System.out.println(num1);
        num1++;
        System.out.println(num1);
        num1+=1;
        System.out.println(num1);

//        변수의 값 변경
        System.out.println("##변수를 변경하는 경우");
        int a;  //변수 선언 a(null)
        a = 10; //변수 초기화 a(10)
        System.out.println(a);//10
        a = 50; // 값 변경 a(50)
        System.out.println(a);//50

//        변수 선언과 초기화 방법
        System.out.println("##변수를 선언하고 변경하는 여러방법");
        int b;
        b=1;
        System.out.printf("     1. 변수 선언과 초기화를 따로: "+b);
        int c = 1;
        System.out.println("    2. 변수 선언과 초기화를 함께: "+c);
        int d =2, e = 3;
        System.out.println("    3. 여러개 변수의 선언과 초기화를 한번에: "+d+'/'+e);
    }
}
