package step01_beginner.chapter02_operator;

public class Operator2 {
    public static void main(String[] args) {
//        문자열에 산술연산자 사용하기
        String h = "hello";
        String w = "world";
        int two = 2;

        String res1 = h + " " + w;
        System.out.println(res1);
//        문자열과 숫자를 함께 배치하면 문자열로 형변환시켜 사용
        String str = "a+b="+10;
        System.out.println(str);
//        변수도 마찬가지로 처리
        String str2 = h+two+" "+w+two;
        System.out.println("str2 = " + str2);
    }
}
