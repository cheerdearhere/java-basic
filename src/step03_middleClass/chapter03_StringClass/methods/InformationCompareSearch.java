package step03_middleClass.chapter03_StringClass.methods;

public class InformationCompareSearch {
    public static void main(String[] args) {
        String str = "Hello, Java";
    //string information
        System.out.println("문자열 길이: "+str.length());

        System.out.println("empty \"\": "+"".isEmpty());
        System.out.println("empty str: "+str.isEmpty());
        System.out.println("empty \"     \": "+"     ".isEmpty());

        System.out.println("blank \"\": "+"".isBlank());
        System.out.println("blank str: "+str.isBlank());
        System.out.println("blank \"     \": "+"     ".isBlank());

        System.out.println("index 7th: "+str.charAt(7));
        System.out.println("J's index: "+str.indexOf('J'));
    // compare
        String str1 = "hello java";
        String str2 = "heLLo java";
        String str3 = "hello World";

        System.out.println("equals: str1,str2: "+str1.equals(str2));
        System.out.println("equals: str1,str3: "+str1.equals(str3));
        System.out.println("equalsIgnoreCase: str1,str2: "+str1.equalsIgnoreCase(str2));
        System.out.println("equalsIgnoreCase: str1,str3: "+str1.equalsIgnoreCase(str3));

        System.out.println("b compareTo a: "+"b".compareTo("a"));
        System.out.println("a compareTo b: "+"a".compareTo("b"));
        System.out.println("a compareTo c: "+"a".compareTo("c"));
        System.out.println("str1 compareTo str3: "+ str1.compareTo(str3));
        System.out.println("str1 compareToIgnoreCase str2: "+ str1.compareToIgnoreCase(str2));

        System.out.println("str1 startWith 'hello'? "+str1.startsWith("hello"));
        System.out.println("str2 startWith 'hello'? "+str2.startsWith("hello"));
        System.out.println("str endWith 'java'? "+str3.endsWith("java"));
    //search
        String greeting = "Hello, java Welcome to Java world!";
        System.out.println("contains('ava') "+greeting.contains("ava"));
        System.out.println("indexOf('ava'): "+greeting.indexOf("ava"));
        System.out.println("indexOf('ava',10): "+greeting.indexOf("ava",10));
        System.out.println("lastIndexOf('ava'): "+greeting.lastIndexOf("ava"));
    }
}
