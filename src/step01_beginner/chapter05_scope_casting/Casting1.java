package step01_beginner.chapter05_scope_casting;

public class Casting1 {
    public static void main(String[] args) {
//        자동 형변환
        int intValue=10;
        long longValue;
        double doubleValue;

        longValue = intValue;
        doubleValue = intValue;
        System.out.println("longValue = " + longValue);
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L;//바로 대입해서도 사용 가능
        System.out.println("doubleValue = " + doubleValue);
    }
}
