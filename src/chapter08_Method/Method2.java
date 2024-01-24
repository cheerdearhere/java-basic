package chapter08_Method;

public class Method2 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("1. changeNumber 호출 전 num = " + num);//5
        changeNumber(num);
        //method 코드블럭 내에서만 변경될뿐 원래 변수인 num1에는 영향을 주지 않음
        System.out.println("4. changeNumber 호출 후 num = " + num);//5

        /**
         * 각각의 method에서 사용되는 변수의 이름이 같아도 서로 다른 변수
         * main()의 number와 changeNumber의 number는 완전히 다른 변수이다
         * 서로 다른 메모리에서 생성된 변수임을 기억
         * 원래의 변수를 변경해 사용하고 싶다면 return을 통해 받아서 사용하면 된다.
         */
        num = useResult(num);
        System.out.println("4-1. changeNumber 호출 후 num = " + num);//10
    }
    public static void changeNumber(int num){
        System.out.println("2. changeNumber 변경 전 num = " + num);//5
        num*=2;
        System.out.println("3. changeNumber 변경 후 num = " + num);//10
    }
    public static int useResult(int num){
        System.out.println("2-1. changeNumber 변경 전 num = " + num);//5
        num*=2;
        System.out.println("3-1. changeNumber 변경 후 num = " + num);//10
        return num;//10
    }
}
