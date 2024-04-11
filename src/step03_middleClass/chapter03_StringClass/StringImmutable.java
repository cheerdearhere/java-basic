package step03_middleClass.chapter03_StringClass;

public class StringImmutable {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1.concat(" java");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

    }
}
