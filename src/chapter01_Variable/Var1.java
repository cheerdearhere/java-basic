package chapter01_Variable;

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
    }
}
