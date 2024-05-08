package step03_middleClass.chapter07_InnerClass.useNested.justHello;

public class HelloRefactoring {
    private static String[] langArr = {"Java", "Spring"};
    public static void helloLang(int type){
        if(type < 0 || type >= langArr.length){
            System.out.println("잘못된 입력입니다: "+type);
            return;
        }
        System.out.println("프로그램 시작");
        System.out.println("Hello "+langArr[type]);
        System.out.println("프로그램 종료");
    }

    public static void hello(String str){
        System.out.println("프로그램 시작");
        System.out.println("Hello "+str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
//        helloLang(0);
//        helloLang(1);
        hello("Java");
        hello("Spring");
    }
}