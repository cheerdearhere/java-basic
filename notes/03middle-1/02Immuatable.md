
불변객체
---

- 자바에서 제공하는 클래스들이 불변 객체로 이뤄져있음.

[실습 코드 모음](../../src/step03_middleClass/chapter02_Immutable)

# I. 기본형과 참조형의 공유
- Primitive Type vs Reference Type
  - 기본형: 하나의 값을 여러 변수에서 공유하지 않는다. 
    - 복사된 기본형 변수를 수정해도 원본 기본형 변수에 영향을 주지 않는다.
  - 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다. 
    - 얕은 복사된 참조형 변수를 수정하면 원본 참조형 변수와 공유하므로 변경점을 공유한다. 
- 기본형 
```java
public static void main(String[] args) {
    int a = 10;
    int b = a;
    b++;
    System.out.println("a = " + a);//10
    System.out.println("b = " + b);//11
}
```
- 참조형
    - 얕은 복사는 참조값(인스턴스 위치)만 복사(공유)하므로 원본에 영향을 미친다.
```java
    public static void main(String[] args) {
        ReferenceObject a = new ReferenceObject(10);
        ReferenceObject b = a;
        b.setA(10+1);
        System.out.println("a, b: " + a + ", "+b);
    }
```

# II. Side Effect
- 어떤 계산이 주된 작업외에 추가적인 부수효과를 일으키는 것.
  - 의도한 것이라면 다행이지만 대다수 의도하지 않은 부작용인 경우가 대다수
  - 참조 변수의 얕은 복사에서 값 변형이 일어나 의도하지 않은 결과를 발생시킬 수 있음
  - 다른 개발자와 협업할때 혼선을 줄 수 있어 안주는 것이 좋음
- 깊은 복사를 진행(새로운 참조 주소 생성)하면 값이 변경되지 않는다.
## A. 사이드 이팩트 해결 방안
- 방법1: 인스턴스의 클래스에서 깊은 복사용 메서드 제작
```java
    private int a;
//...
    public ReferenceObject deepCopy() {
        return new ReferenceObject(this.a);
    }
//...
```
- 방법2: 인스턴스 내부의 값을 같게할뿐 새롭게 객체를 생성
```java
ReferenceObject a = new ReferenceObject(10);
ReferenceObject b = new ReferenceObject(10);
```
- 사실... 둘다 같은 방법. 어디서 처리하느냐의 문제
- 물론 인스턴스를 복사해서 사용하는 경우는 거의 없다.
## B. 그럼에도... 막을 방법이 없다.
- 여러 변수가 하나의 객체를 공유하는 것을 막을 방법이 없다. 
- java 문법상 문제가 없기때문.. 
- 짧은 연습용 코드라면 몰라도 복잡한 소스코드에서는 문제가 크다.
## C. 불변객체를 도입하기
- 공유하면 안되는 객체를 여러 변수에서 공유했기 때문에 발생하는 문제
- 하지만 공유를 막을 방법은 없다. 다만 근본적 원인을 생각해보자 
### 1. 근본적 원인
- 객체를 공유하는 것은 근본적 문제가 아니다. 
- 다만 공유된 객체의 값을 변경할때 문제가 발생한다. 
- 인스턴스를 하나만 사용하는 것이 시간적, 메모리 효율에서 모두 절약된다.
```java
ReferenceObject a = new ReferenceObject(10);
ReferenceObject b = a;
```
```java
ReferenceObject a = new ReferenceObject(10);
ReferenceObject c = new ReferenceObject(10);
```
- 문제는 복사된 참조 객체의 값을 변경했을때 발생한다. 
```java
b.setValue(20);
c.setValue(30);
System.out.println("a:"+a+" b:"+b+" c:"+c);
```
> a:20 b:20 c:30 

### 2. 객체 내부의 값(멤버변수/field)을 변경할 수 없도록 선언
- final 키워드 사용
- constructor 사용 후에는 필드 수정을 불가하게 처리
```java
public class ImmutableField {
    private final int field;// 값 변경 금지
    public ImmutableField(int field) {
        this.field = field;// 생성자에서 입력
    }
}
```
- 사실 `final`을 넣지 않아도 setter를 만들지 않으면 접근자체가 불가하여 안전하나 개발자의 의도가 명확히 표시되어 이후 수정, 관리에서도 이 상태를 유지할 수 있어 final 사용 
```java
  ImmutableField c = new ImmutableField(10);
//        c.setField(20); 수정불가
  c = new ImmutableField(20);//새로운 객체 생성으로 유도
```
- 결과적으로 복사후 값 변경을 막아 사이드 이펙트를 방지할 수 있다. 
- 가변 객체와 불변 객체는 각각 상황에 맞춰 사용하면 된다.\
# III. [예제](../../src/step03_middleClass/chapter02_Immutable/example_immutableObject)
- Address 객체는 불변 객체이지만 Member 객체는 변경 가능
  - 필요에 따라 선택
# IV. 불변 객체의 값 변경
- 불변 객체를 사용하고 있을때 만약 변경하고 싶다면?
  - 수정할 필드 값을 포함한 새 객체를 생성해 반환
```java
  public ImmutableObject add(int num){
      int result = value + num;
      return new ImmutableObject(result);
  }
```
- 단, 결과를 변수로 받지 않으면 사라진다
```java
    memberA.add(50);// return이 메모리에 저장 안됨
   ImmutableObject memberB = memberA.add(20); // 메모리에 저장
```
# V. 실습 문제
```
문제 설명
MyDate 클래스는 불변이 아니어서 공유 참조시 사이드 이펙트가 발생한다. 이를 불변 클래스로 만들어라.
새로운 불변 클래스는 ImmuableMyDate 로 이름 지으면 된다.
새로운 실행 클래스는 ImmuableMyDateMain 으로 이름 지으면 된다.


public class MyDate {
 private int year;
 private int month;
 private int day;
 public MyDate(int year, int month, int day) {
 this.year = year;
 this.month = month;
 this.day = day;
 }
 public void setYear(int year) {
 this.year = year;
 }
 public void setMonth(int month) {
 this.month = month;
 }
 public void setDay(int day) {
 this.day = day;
 }
 @Override
 public String toString() {
 return year + "-" + month + "-" + day;
 }
}

package lang.immutable.test;
public class MyDateMain {
 public static void main(String[] args) {
 MyDate date1 = new MyDate(2024,1,1);
 MyDate date2 = date1;
 System.out.println("date1 = " + date1);
 System.out.println("date2 = " + date2);
 System.out.println("2025 -> date1");
 date1.setYear(2025);
 System.out.println("date1 = " + date1);
 System.out.println("date2 = " + date2);
 }
}

실행 결과 
date1 = 2024-1-1
date2 = 2024-1-1
2025 -> date1
date1 = 2025-1-1
date2 = 2025-1-1
```
[실습 코드](../../src/step03_middleClass/chapter02_Immutable/exam01_Immutable)

# VI. 불변객체를 자세히 다루는 이유?
- Java에서 제공하는 기본 라이브러리 클래스들이 불변 객체로 설계됨
  - String, Integer(Wrapper), LocalDate, URI, ResponseEntity ...
- 모든 클래스를 불변으로 만드는 것은 아니다. 필요에 따라 선택
- 불변 클래스로 설계하는 이유: 동시성을 추구하는 프로젝트에서 데이터의 안정성을 확보할 수 있다.
  - 캐시 안정성
  - 멀티 쓰레드 안정성
  - 엔티티의 값 타입
- 지금은 이론 이해 정도만. 실제로 사용하면서 익숙해지면된다
- 불변 클래스를 자바에서 더 유용하게 사용할 수 있는 이유는 참조 관계가 사라진 인스턴스를 자동으로 삭제해주는 JVM의 GC 덕분.
  - C 언어의 경우 메모리 누수, 스택이나 힙의 오버플로우, 오염, 데드 섹터 증가로 인한 메모리 누수 등의 문제가 발생할 수 있다. 
- 사이드 이펙트 이슈의 원인 