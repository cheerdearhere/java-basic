package step01_beginner.chapter02_operator.ex;

public class Operator2Question {
    /*
    문제2. 다음 double 변수들을 선언하고 그 힘과 평균을 출력하는 프로그램을 작성하세요.
        double val1 = 1.5;
        double val2 = 2.5;
        double val3 = 3.5;
     */
    private static double getSum(double d1,double d2, double d3){
        return d1+d2+d3;
    }
    private static double getAVG(double d1,double d2, double d3){
        return d1+d2+d3/3;
    }
    public static void main(String[] args) {
        double val1 = 1.5;
        double val2 = 2.5;
        double val3 = 3.5;
        System.out.println(getSum(val1,val2,val3));
        System.out.println(getAVG(val1,val2,val3));
    }
}
