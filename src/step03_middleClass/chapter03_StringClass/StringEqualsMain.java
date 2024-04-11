package step03_middleClass.chapter03_StringClass;

public class StringEqualsMain {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println("String identity: "+(str1 == str2)); //false
        System.out.println("String equals: "+(str1.equals(str2))); //true

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("String identity using literal: "+(str3 == str4)); //true
        System.out.println("String equals using literal: "+(str3.equals(str4))); //true

        System.out.println("use constructor: "+(isEqual(str1, str2)));
        System.out.println("use literal: "+isEqual(str3, str4));

    }

    private static boolean isEqual(String str1, String str2) {
        return (str1 == str2);
    }

}
