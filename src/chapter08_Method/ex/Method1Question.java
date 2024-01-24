package chapter08_Method.ex;

public class Method1Question {
    /*
    문제 - 평균값 리펙토링
    메서드를 잘 이해하고 있는지 확인하기 위해 다음 코드를 메서드를 사용하도록 리펙토링해보자.
    MethodEx1
    ```java
        package method.ex;
        public class MethodEx1 {
         public static void main(String[] args) {
         int a = 1;
         int b = 2;
         int c = 3;
         int sum = a + b + c;
         double average = sum / 3.0;
         System.out.println("평균값: " + average);
         int x = 15;
         int y = 25;
         int z = 35;
         sum = x + y + z;
         average = sum / 3.0;
         System.out.println("평균값: " + average);
         }
        }
    ```
    실행 결과
        평균값: 2.0
        평균값: 25.0
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println("평균값: " + getAVG(a,b,c));
        int x = 15;
        int y = 25;
        int z = 35;
        System.out.println("평균값: " + getAVG(x,y,z));
    }
    private static double getAVG(int a, int b, int c){
        return (a+b+c)/3.0;
    }
}
