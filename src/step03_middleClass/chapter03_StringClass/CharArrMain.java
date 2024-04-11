package step03_middleClass.chapter03_StringClass;

public class CharArrMain {
    public static <Char> void main(String[] args) {
        char character = 'c';
        Character wrapperChar = 'c';
        char[] charArr = new char[]{'h','e','l','l','o'};
        Character[] wrapperCharArr = new Character[]{'h','e','l','l','o'};
        String str = "hello";

        System.out.println("charArr = " + charArr);
        System.out.println( charArr);
        System.out.println("wrapperCharArr = " + wrapperCharArr);
        System.out.println("str = " + str);

        String str2 = " Java";
        String result1= str+str2;
        String result2= str.concat(str2);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
