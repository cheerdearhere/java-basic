

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
- 객체 생성하기
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
- 값 사용하기
```java
int n1 = i.intValue();
long n2 = l1.longValue();
```
- 값 비교하기 
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
# III. Boxing & Unboxing
- 리터럴을 래퍼 클래스로 변형하는 것을 박싱이라 한다.
  - Boxing: literal -> Wrapper object
  - 마치 상품을 박스로 감싸듯
  - 값 자체인 리터럴을 객체로 감싸는 것
- 래퍼 클래스의 값을 기본형으로 꺼내는 것을 언박싱이라 한다. 
  - Unboxing: Wrapper object -> literal
  - 마치 선물 상자에서 상품을 꺼내듯
  - 객체 형태에서 값을 꺼냄
  - 꺼낼때 기본형 타입을 지정할 수 있음
## A. Auto Boxing




# IV. 