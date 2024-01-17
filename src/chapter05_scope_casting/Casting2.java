package chapter05_scope_casting;

public class Casting2 {
    public static void main(String[] args) {
//        명시적 형변환
        double doubleValue = 1.5;
        int intValue;
        intValue = (int)doubleValue;
        System.out.println("doubleValue = " + doubleValue);//1.5
        System.out.println("intValue = " + intValue);//1  소수점 버려짐(오차 발생)

//        overflow 발생 예시
        long maxIntValue     = 2147483647; //int 최대값
        long maxIntOverValue = 2147483648L;// int 최대값 +1

        intValue = (int)maxIntValue;
        System.out.println("intValue < maxIntValue: " + intValue);
        intValue = (int)maxIntOverValue;
        System.out.println("intValue < maxIntOverValue: " + intValue);//int의 max를 넘어 min값으로 이동
    }
}
