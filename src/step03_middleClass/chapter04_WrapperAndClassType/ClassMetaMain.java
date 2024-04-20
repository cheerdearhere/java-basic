package step03_middleClass.chapter04_WrapperAndClassType;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassMetaMain {
    public static void main(String[] args) throws Exception{
        // Class 조회
        Class<String> stringClass1 = String.class;// 1. class에서 조회
        Class<? extends String> stringClass2 = new String().getClass(); // 2. instance에서 조회
        Class<?> stringClass3 = Class.forName("java.lang.String");// 3. 문자열로 라이브러리 조회(Exception 처리 필요)

        // 모든 필드 출력
        Field[] fields = stringClass1.getDeclaredFields();
        System.out.println("### "+stringClass1.getName()+"fields>> ");
        Arrays.stream(fields).forEach(field -> {
            System.out.print("\t"+field.getType()+" "+field.getName()+" : "+field+"\n");
        });

        System.out.println();

        //모든 메서드 출력
        Method[] methods = stringClass1.getDeclaredMethods();
        System.out.println("### "+stringClass1.getName()+"methods>> ");
        Arrays.stream(methods).forEach(method -> {
            System.out.print("\t"+method.getReturnType()+" "+method.getName()+" : "+method+"\n");
        });

        // super class
        System.out.println("### "+stringClass1.getName()+"super class>> \n\t"+stringClass1.getSuperclass());

        //Interface info
        Class[] interfaces = stringClass1.getInterfaces();
        System.out.println("### "+stringClass1.getName()+"interfaces>> ");
        Arrays.stream(interfaces).forEach(interfaceClass -> {
            System.out.print("\t"+interfaceClass.getName()+": "+interfaceClass+"\n");
        });

        // create instance
        Class helloClass = Class.forName("step03_middleClass.chapter04_WrapperAndClassType.Hello");
        Hello hello =(Hello) helloClass.getDeclaredConstructor().newInstance();
        System.out.println("hello: "+hello.sayHello());
    }
}
