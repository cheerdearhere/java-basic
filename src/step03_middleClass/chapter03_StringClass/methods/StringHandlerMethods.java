package step03_middleClass.chapter03_StringClass.methods;

import java.util.Arrays;
import java.util.Objects;

public class StringHandlerMethods {
    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java Programming!";

        System.out.println("after index 7: "+str.substring(7));
        System.out.println("after index 7, before 12: "+str.substring(7,12));

        System.out.println("use concat: "+str.concat("!!!"));
        System.out.println("use +operator: "+str+"!!!");
        System.out.println("Java -> World: "+str.replace("Java", "World"));
        System.out.println("first Java -> World: "+str.replaceFirst("Java","World"));

        String strWithSpaces = "     Java  program      with  spaces     ";
        System.out.println("trim: "+strWithSpaces.trim());
        System.out.println("strip: "+strWithSpaces.strip());
        System.out.println("front space: "+strWithSpaces.stripLeading());
        System.out.println("next space: "+strWithSpaces.stripTrailing());
//split, join
        String fruits = "apple,banana,Orange";
        String[] fruitsArray = fruits.split(",");
        Arrays.stream(fruitsArray).forEach(System.out::println);
        System.out.println("re: "+String.join("-", fruitsArray));
// etc
        int num = 100;
        boolean flag = true;
        Object obj = new Object();
        String strObj = "hi! ";
        String numStr = String.valueOf(num);
        String numStr2 = ""+num;
        String booleanStr = String.valueOf(flag);
        String objStr = String.valueOf(obj);
        System.out.println(String.join("-", strObj, numStr, booleanStr, objStr));

        char[] fruitsChars = fruits.toCharArray();
        for(char c : fruitsChars){
            System.out.print(c+" ");
        }
        System.out.println();

        System.out.println(String.format("num: %05d, flag: %b, str: %s", num, flag, str));
        String regex = "Hello, (Java||World)";
        System.out.println(str.matches(regex));
    }
}
