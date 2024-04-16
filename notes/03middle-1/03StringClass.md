
[실습 코드 모음](../../src/step03_middleClass/chapter03_StringClass)

# I. String class - 기본
- 자바에서 문자를 다루는 기본 타입: String, char
  - 기본형: char
  - 참조형: Chararter(wrapper class)
  - 문자형 배열: String6
    - 배열은 그 자체로 참조형
```java
public static void main(String[] args) {
    char character = 'c';
    Character wrapperChar = 'c';
    char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
    Character[] wrapperCharArr = new Character[]{'h', 'e', 'l', 'l', 'o'};
    String str = "hello";

    System.out.println("charArr = " + charArr);// 참조위치 출력: [C@b4c966a
    System.out.println(charArr);//배열을 합쳐 문자열로 출력: hello
    System.out.println("wrapperCharArr = " + wrapperCharArr);// 참조 주소 [Ljava.lang.Character;@1d81eb93
    System.out.println("str = " + str);// 문자열 출력, toString 재정의 되어있음
}
```
- String 객체 생성하기
  - literal 생성(java.lang.String): `"hello"` 
  - 참조 인스턴스 constructor 사용: `new String("hello");`
# II. String class 구조
- java 9 이전
```java
public final class String {
  private final char[] value;
  //... String 관련 데이터  

  public String concat(String str) {
    return this.value;
  }
  public int length() {
    return Stream.of(value).count();
  }
  //...String 관련 메서드
}
```
## A. 속성
  - char[]에 데이터가 보관됨
  - 문자열을 저장하고 관련된 편리한 기능을 제공
```java
private final char[] value;
```
- java 9 이후: char[] 대신 byte[] 사용
  - `char`는 2byte. 영어, 숫자는 1byte로 사용 가능(Latin-1 encoding 기준). 
  - UTF-16처럼 그외의 인코딩을 사용하는 경우 2byte 사용
  - 1byte를 쓸 수 있는 데이터는 1byte만 사용하고 그외에는 2byte로 사용해 메모리를 효율적으로 사용. 
  - 기본 구조는 유사
````java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence,
        Constable, ConstantDesc {
  @Stable
  private final byte[] value;
  private final byte coder;
  private int hash; // Default to 0
  //... String 관련 데이터  

  public String concat(String str) {
    return this.value;
  }
  public int length() {
    return Stream.of(value).count();
  }
  //...String 관련 메서드
}
````
## B. method
- 문자열 관련 자주 사용하는 기본 기능을 제공
  - `int` length(): 문자열 길이
  - `char` charAt(`int index`): 특정 인덱스의 문자 반환
  - `String` substring(`int beginIndex`, `int endIndex`): 문자열의 부분 문자열 반환
  - `int` indexOf(`String str`): 특정 문자열이 시작되는 인덱스를 반환
  - `String` toLowerCase/toUpperCase(): 문자열을 소문자/대문자로 변환
  - `String` trim(): 문자열 양 끝의 공백 제거
  - `String` concat(`String str`): 호출한 문자열과 매개변수의 문자열을 합친다. 
  ...
## C. deference from Reference type
- String은 참조형
- 본래 참조형 객체는 산술연산 `+`를 사용할 수 없다. 하지만 String은 워낙 많이 쓰다보니 예외적으로 허용
```java
        String str = "hello";
        
        String str2 = " Java";
        String result1= str+str2;
        String result2= str.concat(str2);
        //result1 = hello Java
        //result2 = hello Java
```
# III. compare String (identity, equals)
- String 비교는 보통 참조주소 비교(`identity`)가 아닌 문자배열의 내용 비교(value 비교/ `equals`)이므로 `==`을 사용하지 않는다.
```java
public static void main(String[] args){
  String str1 = new String("Hello");
  String str2 = new String("Hello");

  System.out.println("String identity: "+(str1 == str2)); //false
  System.out.println("String equals: "+(str1.equals(str2))); //true
}
```

- String.equals()
```java
    /**
     * Compares this string to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * String} object that represents the same sequence of characters as this
     * object.
     *
     * <p>For finer-grained String comparison, refer to
     * {@link java.text.Collator}.
     *
     * @param  anObject
     *         The object to compare this {@code String} against
     *
     * @return  {@code true} if the given object represents a {@code String}
     *          equivalent to this string, {@code false} otherwise
     *
     * @see  #compareTo(String)
     * @see  #equalsIgnoreCase(String)
     */
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        return (anObject instanceof String aString)
                && (!COMPACT_STRINGS || this.coder == aString.coder)
                && StringLatin1.equals(value, aString.value);
    }
```
- 리터럴 형태로 만들면?
  - `==`도 true
  - 리터럴로 생성하면 `String pool`에서 같은 내용은 같은 대상을 참조시켜 메모리주소도 같게된다.
    - 프로그램을 실행할때 Class 정보를 등록하는데 그때 리터럴 생성방식은 문자열 풀에 등록
    - 같은 문자를 사용하는 경우 메모리 소모를 줄일 수 있다.
```java
      String str3 = "hello";
      String str4 = "hello";// 어? 같은 문자열이네? 문자열 풀에서 같은 곳을 참조
      System.out.println("String identity using literal: "+(str3 == str4)); //true
      System.out.println("String equals using literal: "+(str3.equals(str4))); //true
```
- 참고) 개발에서의 Pool 
  - Pool은 공용 자원이 모여있는 곳을 의미하며 여러 곳에서 함께 사용할 수 있는 객체를 모아놓고 필요할때 사용해 메모리 낭비를 줄일 수 있다. 여러곳에서 사용하는 자원을 필요할 때마다 생성, 제거하는 경우가 반복되면 매우 비효율적이기 때문에 미리 생성해놓고 재사용하여 성능과 메모리를 최적화할 수 있다. 
  - Heap 메모리를 사용하며 Hash 알고리즘을 사용해 검색 속도를 높여준다. 
- 그래서... `==`를 사용할 것인가?
  - 어쨌든 불변 객체이기때문에 큰 문제 없지 않나...?
  - No! method 사용자 입력이 리터럴일지 모르기때문에 불확실성을 짊어질 필요가 없다!!
- 만약.. main과 isEqual을 맡은 담당자가 다르다면...? 
  - 호출하는 곳에서 입력하는 매개변수가 무엇이냐에 따라 결과가 다르다면 그게 좋은 코드인가? 
```java
public static void main(String[] args) {
  String str1 = new String("hello");
  String str2 = new String("hello");
  String str3 = "hello";
  String str4 = "hello";
  
    System.out.println("use constructor: "+(isEqual(str1, str2))); //false
    System.out.println("use literal: "+isEqual(str3, str4)); // true
    
}
private static boolean isEqual(String str1, String str2) {
    return (str1 == str2);
}
```

# IV. Immutable Object in String class
- String의 value는 final로 선언된 불변객체
- 생성 이후 내부 문자열을 변경할 수 없다. 
```java
    String s1 = "hello";
    s1.concat(" java");
    System.out.println("s1 = " + s1);
```
- concat은 객체 자체를 합치는 것이 아닌 새로운 문자열을 생성해서 반환하는 것이다
  - 불변 객체 참고
```java
    String s1 = "hello";
    String s2 = s1.concat(" java");
    System.out.println("s1 = " + s1);
    System.out.println("s2 = " + s2);
```
- concat method
```java
    public String concat(String str) {
        if (str.isEmpty()) {
            return this;
        }
        return StringConcatHelper.simpleConcat(this, str);
    }
```
- method using OCP
```java
    static String simpleConcat(Object first, Object second) {
        String s1 = stringOf(first);
        String s2 = stringOf(second);
        if (s1.isEmpty()) {
            // newly created string required, see JLS 15.18.1
            return new String(s2);
        }
        if (s2.isEmpty()) {
            // newly created string required, see JLS 15.18.1
            return new String(s1);
        }
        // start "mixing" in length and coder or arguments, order is not
        // important
        long indexCoder = mix(initialCoder(), s1);
        indexCoder = mix(indexCoder, s2);
        byte[] buf = newArray(indexCoder);
        // prepend each argument in reverse order, since we prepending
        // from the end of the byte array
        indexCoder = prepend(indexCoder, buf, s2);
        indexCoder = prepend(indexCoder, buf, s1);
        return newString(buf, indexCoder);
    }
```

# V. Methods...
- 매우 다양한 기능을 제공하기에 모두 다룰 수 없음
- 외우기보다 주로 사용하는 기능이 있음을 알아두고 필요할때 검색하거나 [API 문서](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)를 검색한다.
- CharSequence: String, StringBuffer, StringBuilder 등 문자열 타입의 상위 타입
## A. 문자열 정보 조회
- `int` length(): 문자열의 길이
- `boolean` isEmpty(): 문자열이 비어있는지(길이가 0인지) 
- `boolean` isBlank(): 문자열이 비어있는지(길이가 0 or 모든 문자가 공백` `인지)
- `char` charAt(`int index`): 해당 인덱스의 문자 
```java
public static void main(String[] args) {
  String str = "Hello, Java";
  System.out.println("문자열 길이: "+str.length());

  System.out.println("empty \"\": "+"".isEmpty());
  System.out.println("empty str: "+str.isEmpty());
  System.out.println("empty \"     \": "+"     ".isEmpty());

  System.out.println("blank \"\": "+"".isBlank());
  System.out.println("blank str: "+str.isBlank());
  System.out.println("blank \"     \": "+"     ".isBlank());

  System.out.println("index 7th: "+str.charAt(7));
  System.out.println("J's index: "+str.indexOf('J'));
}
```
```
문자열 길이: 11
empty "": true
empty str: false
empty "     ": false
blank "": true
blank str: false
blank "     ": true
index 7th: J
J's index: 7
```
## B. 문자열 비교
- `boolean` equals(`Object anotherObj`): 호출한 인스턴스와 매개변수의 문자열이 동일한지 비교
  - equals()는 Object의 메서드를 재정의함(자바 라이브러리)
- `boolean` equalsIgnoreCase(`String anotherStr`): 두 문자열을 대소문자 구분없이 비교
- `int` compareTo(`String anotherStr`): 두 문자열을 사전 순으로 비교
- `int` compareToIgnoreCase(`String anotherStr`): 두 문자열을 대소문자 구분 없이 사전순으로 비교
- `boolean` startWith(`String prefix`): 문자열이 특정 문자열로 시작하는지 
- `boolean` endWith(`String suffix`): 문자열이 특정 문자열로 끝나는지
```java
public static void main(String[] args) {
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
}
```
```
equals: str1,str2: false
equals: str1,str3: false
equalsIgnoreCase: str1,str2: true
equalsIgnoreCase: str1,str3: false
b compareTo a: 1
a compareTo b: -1
a compareTo c: -2
str1 compareTo str3: 19
str1 compareToIgnoreCase str2: 0
str1 startWith 'hello'? true
str2 startWith 'hello'? false
str endWith 'java'? false
```
## C. 문자열 검색
- `boolean` contains(`CharSequence s`): 문자열이 특정 문자열을 포함하고 있는지
- `int` indexOf(`String ch`): 문자열 앞에서부터 특정 문자열이 등장하는 인덱스 
  - (`String ch`, `int fromIndex`): 문자열이 입력한 인덱스 이후부터 처음 등장하는 인덱스
- `int` lastIndexOf(`String ch`): 문자열 뒤에서부터 특정 문자열이 처음 등장하는 인덱스
```java
public static void main(String[] args) {
  String greeting = "Hello, java Welcome to Java world!";
  System.out.println("contains('ava') "+greeting.contains("ava"));
  System.out.println("indexOf('ava'): "+greeting.indexOf("ava"));
  System.out.println("indexOf('ava',10): "+greeting.indexOf("ava",10));
  System.out.println("lastIndexOf('ava'): "+greeting.lastIndexOf("ava"));
}
```
```
contains('ava') true
indexOf('ava'): 8
indexOf('ava',10): 24
lastIndexOf('ava'): 24
```
## D. 문자열 조작 및 변환
- `String` substring(`int beginIndex`): 인덱스부터 문자열 끝까지 
  - (`int beginIndex`,`int endIndex`): 시작 인덱스 부터 끝 인덱스 앞까지
- `String` concat(`String str`): 호출한 문자열 뒤에 매개변수 문자열을 붙임
- `String` replace(`CharSequence target`, `CharSequence replacement`): 특정문자열을 다른 문자열로 대체
- `String` replaceAll(`String regex`, `String replacement`): 특정 정규표현식과 일치하는 모든 부분을 새 문자열로 대체
- `String` replaceFirst(`String regex`, `String replacement`): 특정 정규표현식과 일치하는 첫 부분을 새 문자열로 대체
- `String` toLowerCase()/toUpperCase(): 문자열을 소문자/대문자로 변환
- `String` trim(): 문자열 양쪽 끝의 공백(whitespace) 제거
- `String` strip(): java 11. 문자열 끝의 whitespace, 유니코드 공백을 제거
```java
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
}
```
```
after index 7: Java! Welcome to Java Programming!
after index 7, before 12: Java!
use concat: Hello, Java! Welcome to Java Programming!!!!
use +operator: Hello, Java! Welcome to Java Programming!!!!
Java -> World: Hello, World! Welcome to World Programming!
first Java -> World: Hello, World! Welcome to Java Programming!
trim: Java  program      with  spaces
strip: Java  program      with  spaces
front space: Java  program      with  spaces     
next space:      Java  program      with  spaces
```
## E. 문자열 분할 및 조합
- `String[]` split(`String regex`): 기준이되는 문자열(정규표현식)을 분할기준으로 삼아 분할
- `String` join(`CharSequence delimiter`, `CharSequence... elements`): 주어진 구분자로 여러 문자열을 결합한다.
```java
public static void main(String[] args) {
  String fruits = "apple,banana,Orange";
  String[] fruitsArray = fruits.split(",");
  Arrays.stream(fruitsArray).forEach(System.out::println);
  System.out.println("re: "+String.join("-", fruitsArray));
}
```
```
apple
banana
Orange
re: apple-banana-Orange
```
## F. 기타
- `String` String.valueOf(Object obj): 모든 타입의 자료를 문자열로 변환
- `Char[]` toCharArray(): 문자열을 문자(char)의 배열로 반환
- `String` format(`String format`,`Object... args`): 형식문자열과 인자를 사용해 새로운 문자열 생성
- `boolean` matches(`String regex`): 문자열이 정규표현식과 일치하는지
```java
public static void main(String[] args) {
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
```
```
hi! -100-true-java.lang.Object@6537cf78
a p p l e , b a n a n a , O r a n g e 
num: 00100, flag: true, str: Hello, Java! Welcome to Java Programming!
false
```
- 외우는게 아니라 익숙해지는 것
# VI. mutable Char Array: StringBuilder, StringBuffer
- 불변인 String class 단점
```java
public static void main(String[] args) {
    //"A" + "B"
    String a = "A";//메모리 낭비
    String b = "B";//메모리 낭비
    String c = a.concat(b);
    System.out.println(c);
    
    //"a"+"b"+"c"+"d"
    String str = "a";//메모리 낭비
    str+="b";//메모리 낭비
    str+="c";//메모리 낭비
    str+="d";
    System.out.println(str);
}
```
- 자원 관리에 있어서 매우 큰 낭비
- 해결방법: 가변 문자 배열 사용
  - 가변 객체 사용시 주의사항
    1. 늘 사이드 이펙트에 주의해야한다. 
    2. 수정을 method를 사용해 진행한다(문자열 풀이 아님)
## A. 구조
- java 9 이전
```java
public final class StringBuilder
{
  char[] value;
}
```
- java 9 이후
```java
public final class StringBuilder
        extends AbstractStringBuilder
        implements Appendable, java.io.Serializable, Comparable<StringBuilder>, CharSequence 
{
    byte[] value;
}
```
## B. 사용 예시
- 생성은 constructor: `new StringBuilder(Object object);`
- 변형은 method 사용
  - append(`parameter`): 문자열 끝에 추가
  - insert(`int offsetIndex`, `charSequence`): 문자열 삽입 포인터 위치, 삽입 대상
  - delete(`int startIndex`,`int endIndex`): 시작 인덱스부터 끝 인덱스 앞까지의 문자 삭제
  - reverse(): 문자배열을 뒤집음
  - repeat(`Object targetObj`,`int count`): 타겟을 횟수만큼 반복
  - toString(): 지금까지 입력/수정된 가변 문자 배열을 불변문자열(String)로 반환
```java
public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("A");
    sb.append("B");
    sb.append("C");
    sb.append("D");
    System.out.println("sb = " + sb);
    
    sb.insert(3, "Java");
    System.out.println("sb = " + sb);
  
    sb.delete(3, 7);
    System.out.println("sb = " + sb);
  
    sb.reverse();
    System.out.println("sb = " + sb);
  
    sb.repeat(sb,3);
    System.out.println("sb = " + sb);
  
    String immutableCharacterSequence = sb.toString();
    System.out.println("immutableCharacterSequence = " + immutableCharacterSequence);
}
```
```
sb = ABCD
sb = ABCJavaD
sb = ABCD
sb = DCBA
sb = DCBADCBADCBADCBA
immutableCharacterSequence = DCBADCBADCBADCBA
```
- 하나의 객체가 계속 변환되기때문에 `String`과 달리 메모리의 과도한 낭비를 줄일 수 있다. 
## C. String 최적화
- Java의 String 최적화
  - 문자열 리터럴 최적화: 컴파일 과정에서 결과를 문자열 풀에 등록해 런타임에서는 연산을 진행하지 않아 메모리 누수를 줄인다
  ```java
  // before compile time
  String beforeCompile = "Hello"+" Java";
  // after compile time(build, runtime)
  String afterCompile = "Hello Java";
  ```
  - String variable 최적화: 단순 연산(`+`)은 원칙상 불가능. but 자바 내부에서 최적화 처리
    - 자바 9부터 `StringConcatFactory`를 사용해 최적화
```java
// 개발자 입력 소스 코드
String result = str1 + str2;
```
```java
// Java 컴파일시 처리
String result = new StringBuilder().append(str1).append(str2).toString();
```
- String 최적화가 어려운 이유
  - 루프(반복문) 내에서 문자열을 더하는 경우 최적화는 적용되지 않는다.  
  - 반복문은 runtime 예측할 수 없어(횟수를 동적 처리할 수 있어 컴파일러가 일할 수 없다) Java가 개입할 여지가 없다 
```java
public static void main(String[] args) {
    int count = 100000;
    
    long startTime = System.currentTimeMillis();
    String res = "";
    for(int i=0; i<count; i++) {
      res += "Hello World!";
    }
    long endTime = System.currentTimeMillis();
    System.out.println("duration using + operator: "+(endTime-startTime)+" ms");
  
    startTime = System.currentTimeMillis();
    String res2="";
    for(int i=0; i<count; i++) {
      res2 = new StringBuilder().append("Hello World!").toString();
    }
    endTime=System.currentTimeMillis();
    System.out.println("duration using mutable CharSequence: "+(endTime-startTime)+" ms");
}
```
```
duration using + operator: 3538 ms
duration using mutable CharSequence: 2 ms
```
- mutable CharSequence 사용이 더 좋은 경우
  - 반복문에서 매우 반복해서 문자를 연결할 때
  - 조건문을 통해 동적으로 문자열을 조합할 때 
  - 복잡한 문자열의 특정부분을 변경해야할 때
  - 매우 긴 대용량 문자열을 조작해야할 때
- StringBuilder vs StringBuffer
  - 둘 다 가변 문자 배열
  - StringBuffer
    - 내부에 동기화가 되어 있어서 멀티 스레드 상황에 안전
    - 동기화 오버헤드로 인해 성능이 느린편
    - 멀티 스레드에서 사용
  - StringBuilder
    - 멀티 스레드 상황에서 안전하지 않음
    - 동기화 오버헤드가 없어 속도가 빠르다
    - 단일 스레드에서 사용
# VII. method Chaining

# IIX. 실습 문제
## A. 문제1
```

```
[실습예제](../../src/step03_middleClass/chapter03_StringClass/)
## B. 문제2
```

```
[실습예제](../../src/step03_middleClass/chapter03_StringClass/)