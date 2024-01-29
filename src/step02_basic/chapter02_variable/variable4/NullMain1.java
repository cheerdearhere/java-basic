package step02_basic.chapter02_variable.variable4;

public class NullMain1 {
    public static void main(String[] args) {
//        Data data;
//        System.out.println("1. 초기화 안한 data = " + data); 에러
        Data data = null;
        System.out.println("2. null data = " + data);
        data = new Data();
        System.out.println("3. 초기화 data = " + data);
        System.out.println("3-1. dat1a.value = " + data.value);
        data.value = 3;
        System.out.println("3-2. data.value 변경 = " + data);
        System.out.println("3-3. dat1a.value 값 호출= " + data.value);
        data = null;
        System.out.println("4. 다시 지우기 = " + data);
        System.out.println("4-1. 지운 후 dat1a.value 값 호출= " + data.value);//data가 null이므로 null.value는 포인터가 체크할 수 없다.

    }
}
