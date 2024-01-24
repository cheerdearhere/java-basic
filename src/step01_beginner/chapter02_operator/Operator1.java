package step01_beginner.chapter02_operator;

public class Operator1 {
    public static void main(String[] args) {
//        피연산자 선언 및 초기화
        int a = 10;
        int b = 2;
        int c = 5;
        int zero = 0;
        printResult(0,a,b);
        printResult(1,a,b);
        printResult(2,a,b);
        printResult(3,a,b);
        printResult(4,a,b);
        printResult(5,a,b);
//      나눗셈 주의
        printResult(4,c,b);
        printResult(4,a,zero);
    }
    private static void printResult(int type, int num1, int num2){
        String operator;
        int res;
        switch (type) {
            case 1: { // 1 > +
                operator = "+";
                res = num1 + num2;
                break;
            }
            case 2: { // 2 > -
                operator = "-";
                res = num1 - num2;
                break;
            }
            case 3: { // 3 > *
                operator = "*";
                res = num1 * num2;
                break;
            }
            case 4: { // 4 > /
                operator = "/";
                res = num1 / num2;
                break;
            }
            case 5: { // 5 > %
                operator = "%";
                res = num1 % num2;
                break;
            }
            default: {
                System.out.println("type error: " + type);
                operator = "잘못된 연산자";
                res=0;
            }
        }
        if(operator.length()==1)System.out.println(num1+operator+num2+"="+res);
    }
}
