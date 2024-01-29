package step02_basic.chapter02_variable.variable3;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println("초기화 안한 field1 = " + data.fieldData1); //자동초기화 가능 > int의 default는 0
        System.out.println("초기화한 field2 = " + data.fieldData2);//수동 초기화

        int localValue1;//수동으로 초기화하지 않으면 에러
        int localValue2=10;//수동초기화 필수
//        System.out.println("초기화 안한 localValue1 = " + localValue1); 에러
        System.out.println("초기화한 localValue2 = " + localValue2);
    }
}
