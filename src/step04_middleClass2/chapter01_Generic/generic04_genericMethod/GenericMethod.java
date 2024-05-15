package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

public class GenericMethod {
    /**
     * 그냥 Object를 사용해 다형성을 이용
     * @param obj Object 소속... 타입 안정성 x
     */
    public static Object objMethod(Object obj){
        System.out.println("Object print: "+obj);
        return obj;
    }

    /**
     * Generic 그냥 사용
     * @param obj Object 소속
     */
    public static <T> T genericMethod(T obj){
        String t;
        if(obj instanceof String) {
            t = "String - " + obj;
        }
        else {
            t = obj.getClass().getName() + " - " + obj;
        }
        System.out.println("Object print: "+t);
        return obj;
    }

    /**
     * 타입 제한해서 사용
     * @param obj Number로만 제한
     */
    public static <T extends Number> T genericNumberMethod(T obj){
        if(obj instanceof Integer) {
            Integer i = obj.intValue() * 2;
            return (T)i;
        }else{
            return obj;
        }
    }
}
