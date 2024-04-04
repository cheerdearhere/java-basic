
# I. Object class?
- 모든 객체 클래스의 최상위 부모 클래스는 Object 
- 따로 적혀있지 않아도(묵시적으로) `extends Object`
```java
public class AnyClass /* extends Object */ {
    //...
}
```
![most Super class](../img/middle/mostSuperClass_Object.png)
## A. Object 제공 이유
- 공통 기능 제공: 객체 정보와 객체 비교 메서드 제공
  - Object의 method : 상위 클래스들의 메서드는 따로 작성하지 않아도 상속하므로 사용할 수 있다.
      - toString(): 객체 정보를 문자열로 전달
        - package, class 정보
        - 해당 인스턴스 메모리 주소
      - equals(): 값 동등 확인 메서드
          - 메모리주소 기반 얕은 비교
      - getClass(): 객체 클래스 정보 제공
      - 그외 기타 여러 기능
      ```java
      String string = child.toString();// method in Object class
      System.out.println(string);//class name, reference(memory address)
      ```
- 다형성의 기본 제공
  - 부모 클래스는 자녀 클래스를 담을 수 있다
  - == 모든 클래스를 Object 클래스로 담을 수 있다. 
```java
List<Object> = new ArrayList<>();
Map<String, Object> = new HashMap<>();
```
## B. Object 다형성
- 모든 객체를 담을 수 있으나 자녀 클래스의 method를 다룰 수 없다
  - 필요에 따라 다운 캐스팅을 통해 처리
```java
private static void action(Object obj){
//        obj.move(); // super class에는 sub의 method가 없다.
//        obj.sound();// 컴파일 에러 발생
    // 객체에 따른 down casting
    if(obj instanceof Cat) ((Cat) obj).sound();
    else if(obj instanceof Car) ((Car) obj).move();
}
```
## C. Object 배열
- Object class는 모든 클래스를 담을 타입
```java
        Cat cat = new Cat();
        Car car = new Car();
        Object obj = new Object();

        Object[] objects = {car, cat, obj};
```
- Object를 사용하면 java의 모든 위치에서 사용할 수 있는 method
```java
    private static void size(Object[] objects) {
        System.out.println("전달된 객체 수: "+objects.length);
    }
```
![Object 타입 배열](../img/middle/Object_Array.png)
- Object 객체가 없으면 각 개발자들이 자신들의 여러가지 이유로 만든 클래스를 계속 만들어야한다. 

# II. Object의 method
## A. toString()
- 객체의 정보를 문자열로 제공
- Object.toString() 코드
```java
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```
### 1. toString()과 println()
```java
    Object object = new Object();
    String string = object.toString();
    // 두 내용이 같음
    System.out.println(string);
    System.out.println(object);
```
- System.out.println()은 toString()이 default
- println이 parameter의 형태에 따라 다양하게 처리하도록 Overloading 처리
```java
    public void println(String x) {
        if (getClass() == PrintStream.class) {
            writeln(String.valueOf(x));
        } else {
            synchronized (this) {
                print(x);
                newLine();
            }
        }
    }

    /**
     * Prints an Object and then terminates the line.  This method calls
     * at first String.valueOf(x) to get the printed object's string value,
     * then behaves as
     * though it invokes {@link #print(String)} and then
     * {@link #println()}.
     *
     * @param x  The {@code Object} to be printed.
     */
    public void println(Object x) {
        String s = String.valueOf(x);
        if (getClass() == PrintStream.class) {
            // need to apply String.valueOf again since first invocation
            // might return null
            writeln(String.valueOf(s));
        } else {
            synchronized (this) {
                print(s);
                newLine();
            }
        }
    }
```
### 2. default toString()의 한계
- 물론 패키지와 해시코드가 유용하긴 하지만 개별 개발자를 만족시키기엔 부족하다. 
- 필요에 따라 커스터마이징이 필요 => override
- 재정의 예시
```java
    @Override
    public String toString() {
        return "Override: Cat class" +
                "\n\tsound: "+sound+
                "\n\tcatName: "+catName+
                "\n\tage: "+age;
    }
```
- 콘솔 표시
```
Override: Cat class
	sound: 야옹
	catName: navi
	age: 2
step03_middleClass.chapter01_Object.objectClass02.Car@2dda6444
```
### 3. Object Printer
- 객체 정보를 출력하는 util class를 직접 만들어 관리하는 것도 좋음
```java
public class ObjectPrint {
    public static void print(Object obj){
        String string = "##객체 정보 출력: "+obj.toString();
        System.out.println(string);
    }
}
```
- call static method 
```java
    ObjectPrint.print(car);
    ObjectPrint.print(cat);
    ObjectPrint.print(obj);
```
>console
```
##객체 정보 출력: step03_middleClass.chapter01_Object.objectClass02.Car@2dda6444
##객체 정보 출력: Override: Cat class
	sound: 야옹
	catName: navi
	age: 2
##객체 정보 출력: java.lang.Object@312b1dae
```
- method 호출은 super로 호출해도 재정의된 매서드(sub)를 우선 사용함
- 이미 toString()이 재정의된 객체의 참조 주소를 보고싶으면 System.identityHashCode() 사용
```java
    public static void printRefAddr(Object obj){
        int i = System.identityHashCode(obj);// 10진수
        String hexStr = Integer.toHexString(i);// 16진수 문자열
        System.out.println("##객체 참조 위치: "+hexStr);
    }
```
### 4. OCP(Open-closed Principle: 개방 폐쇄 원칙)
- `Object class`와 toString()이 없다면 서로 아무 관계가 없는 객체의 정보를 출력하기위해 개별 method를 따로 만들어야한다.
  - 각 개발자마다 이러한 클래스를 모두 만들어야한다. 
  - BadPrinter 클래스는 Car, Dog에 의존한다
    - 구체적인 것에 추상적인 것이 의존하면 변경되거나 추가될때마다 코드가 변형됨 > 나쁜 코드
```java
public class BadPrinter{
    public static print(Cat cat){
        //...
    }
    public static print(Car car){
        //...
    }
    //...
}
```
- toString()이 좋은 점은 어떤 객체라도 균일한 방식으로 사용할 수 있도록 해둔 것이며 그것을 각 클래스에서 필요에 따라 수정해도 일정 규칙성을 갖도록 할 수 있다.
- ObjectPrint 클래스는 위와 달리 추상적인 Object 클래스에 의존하기때문에 구체적인 클래스(Cat, Car, ... etc.)의 추가, 변경에 대응할 필요가 없다.
    - 부모 타입은 자녀 타입보다 더 추상적이다. 
- 다형성을 잘 활용한다 ==
  - 다형적 참조: 추상적인 것에 의존(인자를 추상적인 타입으로 받음)
  - 메서드 오버라이딩: 부모 클래스의 method를 상속해 override. runtime에 각 인스턴스에서 재정의(override)한 메서드를 사용하도록해 각 객체의 특이성을 살리면서도 공통된 형상을 유지
  - 클래스가 추상적인 것에 의존
- OCP 원칙
  - Open: 새로운 클래스 추가, method overriding으로 기능을 확장할 수 있다. 
  - Close: 변경사항이 생기더라도 추상적인 타입(Object)과 method(toString())를 사용하는 클래스(ObjectPrint)는 변경할 필요가 없다. 
- System.out.println()은 이러한 점에서 잘 만들어져있는 메서드다.
  - Object 클래스를 의존함
  - 물론 변형 가능성이 없는 리터럴은 Overload 
```java
    public void println(Object x) {
        String s = String.valueOf(x);
        if (getClass() == PrintStream.class) {
            // need to apply String.valueOf again since first invocation
            // might return null
            writeln(String.valueOf(s));
        } else {
            synchronized (this) {
                print(s);
                newLine();
            }
        }
    }
```
### 5. 참고: 정적 의존 관계와 동적 의존관계
- 정적 의존 관계: 컴파일 단계에서 의존관계가 확정되어 실행하지 않고도 의존관계를 알 수 있는 상태
```java
public void print(Car car){
    //...
}
Car car = new Car();
print(car);//Car 타입에 의존되어있음을 실행하지 않고도 확인 가능
```
- 동적 의존 관계: 런타임으로 넘어가야 어떤 대상에 의존되는지 확정되는지가 확인되는 상태
```java
public void print(Object obj){
    //...
}
Car car = new Car();
Cat cat = new Cat();
print(car);// 실행되기 전까지는 함수를 호출할때 어떤 타입에 의존하는지 알수 없음
print(cat);
```
## B. equals()

# III. 
