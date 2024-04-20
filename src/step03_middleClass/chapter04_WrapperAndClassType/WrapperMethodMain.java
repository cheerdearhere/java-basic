package step03_middleClass.chapter04_WrapperAndClassType;

public class WrapperMethodMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);// 숫자 -> 래퍼
        Integer i2 = Integer.valueOf("10");// 문자열도 가능
        int inum = Integer.parseInt("10");// 문자열을 바로 기본형 int

        // 비교
        int compareResult = i1.compareTo(20);
        System.out.println("compareResult = " + compareResult);

        //산술연산
        System.out.println("sum = " + Integer.sum(10, 20));
        System.out.println("min = " + Integer.min(10, 20));
        System.out.println("max = " + Integer.max(10, 20));

        //Primitive vs Wrapper
        int iterations = 1_000_000_000;
        long startTime, endTime;

        // 기본형 사용
        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0; i<iterations; i++) sumPrimitive++;
        endTime=System.currentTimeMillis();
        System.out.println("primitive: " + (endTime-startTime));

        //래퍼 사용
        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for(int i = 0; i<iterations; i++) sumWrapper++;
        endTime=System.currentTimeMillis();
        System.out.println("wrapper: " + (endTime-startTime));
    }
}
