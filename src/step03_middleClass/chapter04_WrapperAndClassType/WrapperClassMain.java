package step03_middleClass.chapter04_WrapperAndClassType;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer i = new Integer(10);//deprecated 예정
        // 대신 valueOf 사용 권장... but 언제 몇버전에서 적용될지 모름
        Integer i2 = Integer.valueOf(10);
        Integer i3 = 10;
        // 생략 가능
        Double d1 = 10.0;
        Float f1 = 10.2F;
        Long l1 = 10000000L;
        Boolean b1 = true;
        Character c1 = 'A';

        int n1 = i.intValue();
        long n2 = l1.longValue();
        //비교
        i3 = 20;
        System.out.println("(i==i2) = " + (i==i2));
        System.out.println("(i.equals(i2)) = " + (i.equals(i2)));
        System.out.println("(i.equals(i3)) = " + (i.equals(i3)));
    }
}
