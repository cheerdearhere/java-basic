package step03_middleClass.chapter01_Object.objectClass02;

public class ObjectPrint {
    public static void print(Object obj){
        String string = "##객체 정보 출력: "+obj.toString();
        System.out.println(string);
    }
    public static void printRefAddr(Object obj){
        int i = System.identityHashCode(obj);// 10진수
        String hexStr = Integer.toHexString(i);// 16진수 문자열
        System.out.println("##객체 참조 위치: "+hexStr);
    }
}
