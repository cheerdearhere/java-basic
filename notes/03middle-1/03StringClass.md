
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

# VI. mutable Char Array: StringBuilder, StringBuffer

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