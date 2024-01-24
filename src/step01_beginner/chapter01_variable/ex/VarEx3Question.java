package step01_beginner.chapter01_variable.ex;

public class VarEx3Question {
    public static void main(String[] args){
        /*
        문제 3: long 타입의 변수를 선언하고 그 변수를 100억으로 초기화한 후 출력하는 프로그램을 작성하세요.
        boolean 타입의 변수를 선언하고 그 변수를 true로 초기화한 후 출력하는 프로그램을 작성하세요.
         */
        long longNum;
        longNum= 10000000000L;
        System.out.println("longNum = " + longNum);
        boolean booleanVar;
        booleanVar = true;
        System.out.println("booleanVar = " + booleanVar);
    }
}
