

[실습 코드 모음](../../src/step03_middleClass/chapter04_WrapperAndClassType)

# I. 기본형의 한계
- Java는 객체지향 언어 
- but 기본형은 객체 소속이 아닌 데이터: int, boolean, ...(literal)
- 기본형이 객체(Object) 소속이 아니어서 생기는 한계
  - 객체 지향 프로그래밍의 장점을 살릴 수 없다. 
    - 객체가 아니기에 기능(method)을 구현하여 공용으로 사용할 수 없다. 
    - Collection framework 사용 불가
    - Generic 사용 불가
  - null 값을 가질 수 없다.
## A. 메서드를 사용할 수 없음
- 한계 상황 예시
  - value를 비교하는데 value와 전혀 관계없는 외부 메서드를 사용해야함
  - 본래 value가 객체였다면 자신.method()로 비교할 수 있다. 
```java
public static void main(String[] args) {
    int value = 10;
    int i1 = compareTo(value,5);
    int i2 = compareTo(value,10);
    int i3 = compareTo(value,20);
}
private static int compareTo(int value, int target){
    if(value < target){
        return -1;
    } else if (value > target) {
        return 1;
    } else {
        return 0;
    }
}
```
- int를 감싸서 객체처럼 사용하게 하는 클래스: wrapper class
```java
public class MyInteger {
    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int compareTo(int target) {
        if(value > target){
            return 1;
        }else if(value < target){
            return -1;
        }
        else return 0;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
```
- 관련있는 속성과 기능이 모여있는 객체지향적 특징을 적용
```java
MyInteger myInteger = new MyInteger(value);
int m1 = myInteger.compareTo(5);
int m2 = myInteger.compareTo(10);
int m3 = myInteger.compareTo(20);
```
## B. 기본형과 null
- 때로는 데이터가 없는 상태가 필요할 수 있다. 
- but 기본형은 항상 값을 갖는다. 필드인 경우 default 0를 갖는다.
```java
public static void main(String[] args) {
    int[] intArr = {-1,0,1,1,3};
    System.out.println("1 몇 개? "+findValue(intArr,1));//1
    System.out.println("1 몇 개? "+findValue(intArr,-1));//-1
    System.out.println("100 몇 개? "+findValue(intArr,100));//-1
}
private static int findValue(int[] arr, int value) {
    for(int i : arr){
        if(i==value) return value;
    }
    return -1;
}
```
- 값이 없을때는 값이 없다고 반환해야함
  - -1을 찾을때: -1
  - 100(없는 수)을 찾을 때: -1  

- Wrapper 사용
```java
public static void main(String[] args) {
    MyInteger[] myIntegerArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1), new MyInteger(2), new MyInteger(3)};
    System.out.println("1 몇 개? "  +findMyInteger(myIntegerArr,1));//1
    System.out.println("1 몇 개? "  +findMyInteger(myIntegerArr,-1));//-1
    System.out.println("100 몇 개? "+findMyInteger(myIntegerArr,100));//null
}
private static MyInteger findMyInteger(MyInteger[] arr, int value) {
    for(MyInteger i : arr) {
        if(i.getValue() == value) {
            return i;
        }
    }
    return null;
}
```
- 항상 값이 있어 `null`을 회피할 수 있다는 것은 참좋은 것이지만
- 의도적으로 `null`을 사용할 필요가 있을때가 있음을 깅억

# II. Java Wrapper Class
- 자바가 제공하는 Wrapper class: 기본형을 감싼 객체
  - byte    ->    Byte
  - short   ->    Short
  - int     ->    Int
  - long    ->    Long
  - float   ->    Float
  - double  ->    Double
  - char    ->    Character
  - boolean ->    Boolean
- 기본 래퍼 클래스 특징
  - 불변 객체
  - equals()를 사용
## A. 객체 생성하기
  - valueOf()를 권장하는 이유는 자주 사용하는 -128 ~ 127 사이의 수가 문자열 풀처럼 미리 생성된 객체를 반환하므로 성능 향상에 도움이 되기 때문 
```java
Integer i = new Integer(10);//deprecated 예정
// 대신 valueOf 사용 권장... but 언제 몇버전에서 적용될지 모름
Integer i2 = Integer.valueOf(10);
// 생략 가능
Integer i3 = 10;
Double d1 = 10.0;
Float f1 = 10.2F;
Long l1 = 10000000L;
Boolean b1 = true;
Character c1 = 'A';
```
## B. 값 사용하기
```java
int n1 = i.intValue();
long n2 = l1.longValue();
```
## C. 값 비교하기 
```java
public static void main(String[] args) {
    //비교
    i3 = 20;
    System.out.println("(i==i2) = " + (i==i2));
    System.out.println("(i.equals(i2)) = " + (i.equals(i2)));
    System.out.println("(i.equals(i3)) = " + (i.equals(i3)));
}
```
```
(i==i2) = false
(i.equals(i2)) = true
(i.equals(i3)) = false
```
## D. Boxing & Unboxing
- 리터럴을 래퍼 클래스로 변형하는 것을 박싱이라 한다.
  - Boxing: literal -> Wrapper object
  - 마치 상품을 박스로 감싸듯
  - 값 자체인 리터럴을 객체로 감싸는 것
- 래퍼 클래스의 값을 기본형으로 꺼내는 것을 언박싱이라 한다. 
  - Unboxing: Wrapper object -> literal
  - 마치 선물 상자에서 상품을 꺼내듯
  - 객체 형태에서 값을 꺼냄
  - 꺼낼때 기본형 타입을 지정할 수 있음
## E. Auto Boxing/Unboxing
- 직접 메서드를 표시
```java
int value = 7;
// Primitive -> Wrapper
Integer boxedValue = Integer.valueOf(value);
// Wrapper -> Primitive
int unboxedValue = boxedValue.intValue();
```
- 용도가 기본형을 위한 객체이다보니 java 5부터 컴파일러가 auto boxing, auto unboxing 지원
```java
int value = 7;
// Auto: Primitive -> Wrapper
Integer boxedValue = value;
// Auto: Wrapper -> Primitive
int unboxedValue = boxedValue;
```
- 언어도 사용자 편의와 흐름에 따라 변경되는 부분이 있음
# III. wrapper class 주요 메서드
- parsers
  - `Wrapper` valueOf(`Object obj`): 래퍼 클래스로 변환, 문자열도 가능
  - `Primitive` parse{해당타입}(`String numeric`): 해당 객체(특히 문자열)를 해당 타입(기본형)으로 변환
```java
    Integer i1 = Integer.valueOf(10);// 숫자 -> 래퍼
    Integer i2 = Integer.valueOf("10");// 문자열도 가능
    int i = Integer.parseInt("10");// 문자열을 바로 기본형 int
```
- 비교
```java
    // 비교
    int compareResult = i1.compareTo(20);
    System.out.println("compareResult = " + compareResult);
```
- 기본 산술연산
```java
    //산술연산
    System.out.println("sum = " + Integer.sum(10, 20));
    System.out.println("min = " + Integer.min(10, 20));
    System.out.println("max = " + Integer.max(10, 20));
```
- 편리한 래퍼의 존재에도 기본형을 사용하는 이유 : 성능
```java
public static void main(String[] args) {
  // 기본형 사용
  long sumPrimitive = 0;
  startTime = System.currentTimeMillis();
  for(int i = 0; i<iterations; i++) sumPrimitive++;
  endTime=System.currentTimeMillis();
  System.out.println("primitive: " + (endTime-startTime));

  //래퍼 사용
  Long sumWrapper = 0L;
  startTime = System.currentTimeMillis();
  for(int i = 0; i<iterations; i++) sumWrapper++;
  endTime=System.currentTimeMillis();
  System.out.println("wrapper: " + (endTime-startTime));
}
```
```
primitive: 3
wrapper: 4165
```
- 기본형은 이미 존재하는 풀에서 값을 사용하기에 정해진 용량만큼만 사용
- 래퍼는 인스턴스이므로 내부에 있는 객체를 위한 메타 데이터를 포함해 더 많은 메모리를 사용

- 무엇을 사용해야 하는가? 
  - 왠만한 연산은 거의 차이가 안남
  - CPU에서 연산을 아주 많이 수행하거나 수만 ~ 수십만 이상 연속 수행하는 경우 기본형 권장
  - 유지보수나 관리적 측면에서 편한 것 선택
- 유지보수 vs 최적화
  - 둘 모두 가져가면 좋겠지만 생각보다 쉽지 않다. 
  - 또한 최근 컴퓨터들의 성능이 워낙 좋다보니 최적화가 의미없이 느껴지기도 한다. 
  - 그렇다해도 성능을 완전 포기할 수 없다
    - 코드 변경 없이 성능 최적화를 하면 best 
      - 하지만 대부분의 최적화는 단순함보다는 복잡함을 요구하고 
      - 더 많은 코드들을 추가로 만들며
      - 복잡한 과정을 통해 진행되는 경우가 많다. 
    - 여러 노력으로 최적화를 한다 한들 애플리케이션(응용프로그램) 입장에서 극적인 효과를 보는 경우는 거의 없으며
    - 대다수 불필요한 최적화를 진행하는 경우가 많다. 
    - 자바 내부의 연산을 한번 줄이는 것보다 네트워크 호출을 한번 줄이는게 성능을 확보하는 경우가 많다. 
    - 우선 처리한 뒤 개발이후 성능 테스트에서 중대 문제사항이 발생하는지, 최적화의 영향이 극적인지 체크한뒤 적용
# IV. java.lang.Class
- `Class`는 클래스의 정보(메타데이터)를 다루는데 사용한다
- 주요기능
  - 타입 정보: 클래스명, 부모 클래스, 구현 인터페이스, 접근 제한자 등 정보 조회
  - reflection: 클래스에 정의된 메서드, 필드, 생성자 등 조회, 이들을 통해 인스턴스 생성 및 메서드 호출 등 작업 진행
    - getDeclareFields(): 클래스의 모든 필드 조회
    - getDeclareMethods(): 클래스의 모든 메서드 조회
    - getSuperclass(): 클래스의 부모클래스 조회
    - getInterfaces(): 클래스의 인터페이스 조회
  - dynamic Loading, create instance
    - `Class.forName()`: 클래스를 동적으로 호출
      - DataSource, DB connection 관리 등을 처리할때 동적으로 처리
    - newInstance(): 해당 클래스의 인스턴스 생성
  - annotation 처리: 클래스에 적용된 애노테이션을 조회하고 처리하는 기능을 제공
```java
public static void main(String[] args) throws Exception{
  // Class 조회
  Class<String> stringClass1 = String.class;// 1. class에서 조회
  Class<? extends String> stringClass2 = new String().getClass(); // 2. instance에서 조회
  Class<?> stringClass3 = Class.forName("java.lang.String");// 3. 문자열로 라이브러리 조회(Exception 처리 필요)

  // 모든 필드 출력
  Field[] fields = stringClass1.getDeclaredFields();
  System.out.println("### "+stringClass1.getName()+"fields>> ");
  Arrays.stream(fields).forEach(field -> {
      System.out.print(field.getType()+" "+field.getName()+" : "+field+"\n");
  });

  System.out.println();

  //모든 메서드 출력
  Method[] methods = stringClass1.getMethods();
  System.out.println("### "+stringClass1.getName()+"methods>> ");
  Arrays.stream(methods).forEach(method -> {
      System.out.print(method.getReturnType()+" "+method.getName()+" : "+method+"\n");
  });

  // super class
  System.out.println("### "+stringClass1.getName()+"super class>> "+stringClass1.getSuperclass());

  //Interface info
  Class[] interfaces = stringClass1.getInterfaces();
  System.out.println("### "+stringClass1.getName()+"interfaces>> ");
  Arrays.stream(interfaces).forEach(interfaceClass -> {
      System.out.print(interfaceClass.getName()+": "+interfaceClass+"\n");
  });
}
```
```
### java.lang.Stringfields>> 
class [B value : private final byte[] java.lang.String.value
byte coder : private final byte java.lang.String.coder
int hash : private int java.lang.String.hash
...
### java.lang.Stringmethods>> 
boolean equals : public boolean java.lang.String.equals(java.lang.Object)
int length : public int java.lang.String.length()
class java.lang.String toString : public java.lang.String java.lang.String.toString()
...
### java.lang.Stringsuper class>> class java.lang.Object
### java.lang.Stringinterfaces>> 
java.io.Serializable: interface java.io.Serializable
java.lang.Comparable: interface java.lang.Comparable
java.lang.CharSequence: interface java.lang.CharSequence
...
```
- 동적으로 입력받아 인스턴스 사용하기
  - `forName()`에서 동적으로 받아 처리
  - 애노테이션을 사용해 좀 더 편리하게 사용 가능
  - 리플렉션(reflection)을 깊이 있게 이해하기보다 이렇게 사용할 수 있음 정도만
    - 고급 후반부에서 필요할때 도전하자
```java
// create instance
Class helloClass = Class.forName("step03_middleClass.chapter04_WrapperAndClassType.Hello");
Hello hello =(Hello) helloClass.getDeclaredConstructor().newInstance();
System.out.println("hello: "+hello.sayHello());
```
# V. java.lang.System
- 시스템의 여러 정보를 사용할 수 있음. 
- 시스템 시간
```java
        //현재 시간
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis   = " + currentTimeMillis);
        long currentTimeNanos = System.nanoTime();
        System.out.println("currentTimeNanos    = " + currentTimeNanos);
```
- 시스템 환경변수
```java
//운영체제가 사용하는 시스템 환경변수
Map<String,String> osEnv = System.getenv();
System.out.println("map = " + osEnv);
//자바가 사용하는 환경변수
Properties javaProperties = System.getProperties();
javaProperties.list(System.out);
System.out.println("java version: "+javaProperties.getProperty("java.version"));
```
- 빠른 배열 복사
```java
// 배열 고속 복사
char[] originalArray = {'h','e','l','l','o'};
char[] newArray = new char[originalArray.length];
//반복문이 아닌 객체 깊은 복사: 메모리 자체에 접근
System.arraycopy(originalArray,0,newArray,0,originalArray.length);
Stream.of(newArray).forEach(System.out::println);
```
- 이 프로그램 종료
  - 프로그램을 갑작스럽게 종료하는 것은 매우 신중해야하므로 권장하지 않음
  - System.exit(`int status`)
    - 0: 정상종료
    - ...
- console 사용: 표준 입출력
  - System.out
    - print
    - println
    - printf ...
  - System.in
    - Scanner
- 표준 오류 스트링 처리: System.err
# VI. Meth, Random
## A. Math
- 수학문제를 해결해주는 클래스
- 워낙 많은 기능(메서드)을 제공하기때문에 외우기 보다 필요에따라 찾아쓰기
- method
  - 기본 연산
    - `abs(x)`: 절대값
    - `max(a,b)`: 최대값
    - `min(a,b)`: 최소값
  - 지수 로그 연산
    - `exp(x)`: e^x 계산
    - `log(x)`: 자연로그
    - `log10(x)`: log 10
    - `pow(a,b)`: a^b 계산
  - 반올림 및 정밀도 메서드
    - `ceil(x)`: 올림
    - `floor(x)`: 내림
    - `rint(x)`: 가장 가까운 정수로 반올림
    - `round(x)`: 반올림
  - 삼각함수 메서드
    - `sin(x)`
    - `cos(x)`
    - `tan(x)`
  - 기타
    - `sqrt(x)`: 제곱근
    - `cbrt(x)`: 세제곱근
    - `random()`: 0~1사이의 무작위 값 생성
```java
public static void main(String[] args) {
    //기본 연산
    System.out.println("max(10,23): "+Math.max(10,23));
    System.out.println("min(10,23): "+Math.min(10,23));
    System.out.println("abs(-10): "+Math.abs(-10));

    //반올림, 정밀도
    System.out.println("올림 - ceil(2.1): "+Math.ceil(2.1));
    System.out.println("내림 - floor(2.1): "+Math.floor(2.1));
    System.out.println("가까운 정수 - rint(2.1): "+Math.rint(2.1));
    System.out.println("반올림 - round(2.1): "+Math.round(2.1));

    //기타
    System.out.println("제곱근 - sqrt(10): "+Math.sqrt(16));
    System.out.println("세제곱근 - cbrt(-8): "+Math.cbrt(-8));
    System.out.println("0~1 랜덤 - random(): "+Math.random());
}
```
- 참고: 수를 정밀하게 관리할때 BigDecimal class 사용 권장
  - 필요할때 찾아써도 됨
```java
BigDecimal bigDecimal = new BigDecimal("0.1");
```
## B. Random
- Math.random의 기능을 강화
```java
public static void main(String[] args) {
    Random random = new Random();
    //정수 범위 내 랜덤
    int randomInt = random.nextInt();
    System.out.println("randomInt = " + randomInt);
    //0~1 사이 랜덤
    double randomDouble = random.nextDouble();
    System.out.println("randomDouble = " + randomDouble);
    // true or false
    boolean randomBoolean = random.nextBoolean();
    System.out.println("randomBoolean = " + randomBoolean);

    // 범위로 조회
    int range9 = random.nextInt(10);// 0~9
    System.out.println("range9 = " + range9);
    int range10 = random.nextInt(10)+1;// 1~10
    System.out.println("range10 = " + range10);

    // seed를 지정해 일정 값을 얻을 수 있음
    Random seedRandom = new Random(1);
        //개별 수행은 다른 값을 갖지만 개별 결과의 값은 일정함(내부 연산을 동일하게 진행)
    int seed1 = seedRandom.nextInt(10);
    int seed2 = seedRandom.nextInt(10);
    System.out.println("seed: " + seed1 + " " + seed2);

}
```
```
randomInt = -1493907866
randomDouble = 0.8431618096737828
randomBoolean = true
range9 = 5
range10 = 7
seed: 5 8
```
- seed는 주로 게임, 도박에서 자주사용
  - 마인크래프트의 지형
  - 각종 랜덤 게임 등
# VII. 실습 문제
## A. Wrapper class 사용
- [실습코드](../../src/step03_middleClass/chapter04_WrapperAndClassType/test/Exam01_Wrapper.java)
```
문제1 - parseInt()
문제 설명
문자로 입력된 str1 , str2 두 수의 합을 구하자.

package lang.wrapper.test;
public class WrapperTest1 {
 public static void main(String[] args) {
 String str1 = "10";
 String str2 = "20";
 // 코드 작성
 }
}

실행 결과 
두 수의 합: 30
```
```
문제2 - parseDouble()
문제 설명
배열에 입력된 모든 숫자의 합을 구하자. 숫자는 double 형이 입력될 수 있다.

package lang.wrapper.test;
public class WrapperTest2 {
 public static void main(String[] args) {
 String[] array = {"1.5", "2.5", "3.0"};
 // 코드 작성
 }
}

실행 결과 
sum = 7.0
```
```
문제3 - 박싱, 언박싱
문제 설명
String str 을 Integer 로 변환해서 출력해라.
Integer 를 int 로 변환해서 출력해라.
int 를 Integer 로 변환해서 출력해라.
오토 박싱, 오토 언박싱을 사용하지 말고 직접 변환해야 한다.

package lang.wrapper.test;
public class WrapperTest3 {
 public static void main(String[] args) {
 String str = "100";
 // 코드 작성
 }
}

실행 결과 
integer1 = 100
intValue = 100
integer2 = 100
```
## B. 로또 번호 자동 생성기
[실습 코드](../../src/step03_middleClass/chapter04_WrapperAndClassType/test/Exam02_LottoNumber.java)
```
문제 - 로또 번호 자동 생성기
문제 설명
로또 번호를 자동으로 만들어주는 자동 생성기를 만들자
로또 번호는 1~45 사이의 숫자를 6개 뽑아야 한다.
각 숫자는 중복되면 안된다.
실행할 때 마다 결과가 달라야 한다.
실행 결과 
로또 번호: 11 19 21 35 29 16
```