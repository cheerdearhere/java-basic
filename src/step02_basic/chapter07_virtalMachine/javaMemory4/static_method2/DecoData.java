package step02_basic.chapter07_virtalMachine.javaMemory4.static_method2;

public class DecoData {
    private String instanceValue="instance";
    private static String staticValue="static";

    public void instanceCall(){
        instanceValue+="\n    value";//인스턴스 변수 접근
        staticValue+="\n    value";//클래스 변수 접근
        instanceMethod();//인스턴스 메서드 접근
        staticMethod();//클래스 메서드 접근
    }
    public static void staticCall(){
//        instanceValue+="\n    value";//인스턴스 변수 접근 불가
        staticValue+="\n    value";//클래스 변수 접근
//        instanceMethod();//인스턴스 메서드 접근 불가
        staticMethod();//클래스 메서드 접근
    }

    public static void useInstance(DecoData decoData){
        decoData.instanceValue+="\n    value";
        decoData.instanceMethod();
    }
    private static void staticMethod(){
        System.out.println(staticValue+" 메서드 호출");
    }
    private void instanceMethod(){
        System.out.println(instanceValue+" 메서드 호출");
    }
}
