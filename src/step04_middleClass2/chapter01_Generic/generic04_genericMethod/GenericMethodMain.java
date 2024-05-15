package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

public class GenericMethodMain {
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();

        Integer i = 10;
        Integer result;

        Object object = GenericMethod.objMethod(i);
        result = (Integer)object;
        System.out.println("result = " + result);
        //타입 인자(Type Argument) 명시적 전달
        result = GenericMethod.<Integer>genericMethod(i);
        System.out.println("result = " + result);
        //다른 타입을 인자로 전달할 수 없음
        Double doubleRes = GenericMethod.<Double>genericNumberMethod(Double.valueOf(i));
        System.out.println("doubleRes = " + doubleRes);

        //타입추론
        i++;
        Integer integerData = GenericMethod.genericMethod(i);
        System.out.println("integer = " + integerData);
        Double doubleData = GenericMethod.genericMethod(Double.valueOf(i));
        System.out.println("double = " + doubleData);
//        GenericMethod.genericNumberMethod("not number");
    }
}
