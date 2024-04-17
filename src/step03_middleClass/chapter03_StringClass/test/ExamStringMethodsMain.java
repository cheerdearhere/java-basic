package step03_middleClass.chapter03_StringClass.test;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamStringMethodsMain {
    public static void main(String[] args) {
        //문제1 - startsWith
        //startsWith() 를 사용해서 url 이 https:// 로 시작하는지 확인해라.
        String url = "https://www.example.com";
        System.out.println("1. is url? "+url.startsWith("https://"));
        //문제2 - length
        //length() 를 사용해서 arr 배열에 들어있는 모든 문자열의 길이 합을 구해라.
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        System.out.println("2. arr items ");
        Stream.of(arr).forEach(item->{
            System.out.print("\t"+item+":"+item.length()+"\n");
        });
        //문제3 - indexOf
        // file 에서 ".txt" 문자열이 언제부터 시작하는지 위치를 찾아서 출력해라. indexOf() 를 사용해라.
        String file = "hello.txt";
        System.out.println("3. \".txt\" 시작 위치: "+file.indexOf(".txt"));
        //문제4 - substring
        //substring() 을 사용해서, hello 부분과 .txt 부분을 분리해라.
        System.out.println("4. fileName, extension ");
        System.out.print(
                        "\t fileName: "+file.substring(0, file.indexOf("."))+"\n"
                        +"\t extension: "+file.substring(file.lastIndexOf("."))+"\n"
        );
        //문제5 - indexOf, substring 조합
        //str 에는 파일의 이름과 확장자가 주어진다. ext 에는 파일의 확장자가 주어진다.
        //파일명과 확장자를 분리해서 출력하라.
//        String str="hello.txt";
        String ext = ".txt";
        int extIndex = file.indexOf(ext);
        System.out.print(
                "5. use indexOf, substring  \n"
                +"\t fileName: "+file.substring(0,extIndex)+"\n"
                +"\t ext: "+file.substring(extIndex)+"\n"
        );

        //문제6 - 검색 count
        //str 에서 key 로 주어지는 문자를 찾고, 찾은 문자의 수를 출력해라.
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";
        int count = 0;
        int indexOfKey = str.indexOf(key);
        while (indexOfKey > 0) {
            count++;
            indexOfKey = str.indexOf(key, indexOfKey+1);
        }
        System.out.println("6. count: "+count);
        //문제7 - 공백 제거
        //문자의 양쪽 공백을 제거해라. 예) " Hello Java " "Hello Java"
        String original = " Hello Java ";
        System.out.println("7. remove space: /"+original+"/=>/"+original.strip()+"/");
        //문제8 - replace
        //replace() 를 사용해서 java 라는 단어를 jvm 으로 변경해라.
        String input = "hello java spring jpa java";
        System.out.println("8. java -> jvm: "+input+"=>"+input.replaceAll("java","jvm"));
        //문제9 - split()
        //split() 를 사용해서 이메일의 ID 부분과 도메인 부분을 분리해라.
        String email = "hello@example.com";
        String[] emailData = email.split("@");
        System.out.print(
                "9. id, domain: \n"
                +"\t ID: "+emailData[0]+"\n"
                +"\t Domain: "+emailData[1]+"\n"
        );
        //문제10 - split(), join()
        //split() 를 사용해서 fruits 를 분리하고, join() 을 사용해서 분리한 문자들을 하나로 합쳐라.
        String fruits = "apple,banana,mango";
        System.out.println("10. delete comma: "+ String.join("", fruits.split(",")));
        //문제11 - reverse()
        //str 문자열을 반대로 뒤집어라.
        String str2 = "Hello Java";
        System.out.println("11. reverse string: "+new StringBuilder(str2).reverse().toString());
    }
}
