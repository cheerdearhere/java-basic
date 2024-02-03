# VII. Java Virtual Machine (w. static)
## A. Java 메모리 구조
![img.png](../img/JVMMemory.png)
- 메서드 영역: JVM 실행시 구동되는 영역. 최우선으로 클래스 영역이 확보된다. 
  - 클래스 정보, static 영역, 런타임 상수 풀(리터럴: int, long 등)
- 스택 영역: 매서드가 호출될때 스택 프레임이 쌓이고 매서드가 처리되고나면 줄어든다. 
  - 프로그램이 실행되는 영역(main method부터 쌓이기 시작).
```java
    public static void main(){} //스택 시작
```
  - 후입선출 LIFO(last in first out) 방식으로 메모리 관리 
  - thread 별로 하나의 실행 스택이 쌓이며 쓰레드 수 만큼 동시 처리가 가능하다. 다만 현재는 멀티쓰레드를 사용하지 않으므로 하나의 쓰레드로 이해
- 힙 영역: 객체(instance)가 생성되는 영역. 리터럴이 아닌 객체와 배열 등의 데이터가 저장된다. 
  - 선언(new - 생성자 키워드)을 하면 이 영역을 사용한다. 
  - 참조 주소의 대상이 된다. 
  - 더이상 참조되지 않는 데이터는 GC에 의해 제거된다. 
### 1. 메서드의 호출
method를 호출하는 위치와 매개변수, 지니는 멤버 변수는 다 다를 수 있다. 힙 영역에 저장된 value 위치는 다를 수 있지만 메서드 코드는 모두 같다. 같은 내용을 호출때마다 메모리에 올리는것은 너무 큰 낭비. 

메서드 코드는 메서드 영역 하나에만 올려놓고 공통으로 관리되고 실행된다. 
![img.png](../img/JVMMethodCall.png)

## B. 스택 영역
### 들어가기 전에: 기본 자료구조 - stack, queue
#### a. 스택 구조 - LIFO: 후입선출
- 출입구가 하나인 통 모양
- 오래 보관하고 끝까지 있어야 할 것이 가장 먼저 들어간다.
![img.png](../img/stack.png)
#### b. 큐 구조 - FIFO: 선입선출
- 아래가 출구인 통모양
- 순차적으로 처리한다.
![img.png](../img/queue.png)

### 1. 실행 확인
[실습코드](../../src/step02_basic/chapter07_virtalMachine/javaMemory1/JavaMemoryMain.java)
- 수행결과(console)
```dockerfile
main start
method1 start
method2 start
method2 end
method1 end
main end
```
- 자바는 스택영역을 사용해 메서드 호출과 지역변수(parameter 포함)를 관리한다.
- 스택 프레임이 종료되면 해당 스택에서 선언된 지역변수도 함께 종료

## C. 스택과 힙
- 클래스의 메서드는 메서드 영역, field인 값은 힙 영역에 저장
- method와 값을 호출해서 사용하는 곳은 스택
[실습](../../src/step02_basic/chapter07_virtalMachine/javaMemory2/Stack_HeapMain.java)
- console
```dockerfile
main start
method1 start
method2 start
data.value = 1
method2 end
method1 end
main end
```
- 실행순서
  - JVM 실행
    - main method 스택 프레임 실행
      - method1 스택 프레임 실행
      - <i>힙에 Data의 인스턴스 생성</i>
        - method2 스택 프레임 실행
        - <i>힙에 있던 Data의 인스턴스 참조</i>
        - method2 스택 프레임 종료 (<i>매개변수 참조 종료</i>)
      - method1 스택 프레임 종료 > <i>지역변수 참조 종료(GC)</i>
    - main method 스택 프레임 종료
  - JVM 종료

## D. static variable
### 1. static이 없으면...
- 생성된 객체의 수를 세려고 만들려고 시도
```java
public class Data {
    private String name;
    private int count;

    public Data(String name) {
        this.name = name;
        count++;
    }
//    ...getter/setter
}
```
[실습](../../src/step02_basic/chapter07_virtalMachine/javaMemory3/static_variable1)
- 같은 클래스라도 인스턴스는 결국 개별객체. 생성된 객체 수를 체크하기위한 count는 결국 무용하다.
- 물론 외부에 해당 인스턴스를 따로 보관하는 것도 방법. 
- 그러나
  - Data class와 관련된 것을 외부에 두는 것이 유지보수의 입장에서 맞는가?
  - 생성자가 복잡해지는 점
```java
public class Data {
    private String name;
    private Counter counter;

    public Data(String name, Counter counter) {
        this.name = name;
        counter.increaseCount;
    }
//    ...getter/setter
}
```
### 2. static 변수
- 클래스와 함께 라이프사이클을 공유하는 멤버변수를 만들고 싶을때 static을 사용한다.
- static으로 선언된 변수는 인스턴스가 아닌 클래스와 함께 메서드 영역에 보관된다.
- 호칭 방법
  - static 변수: 키워드
  - 정적 변수: 인스턴스와 관계없이 고정되는 특징
  - 클래스 변수: 클래스와 생애주기(lifecycle)를 공유하기 때문
- 변수 타입 앞에 키워드를 넣는다. 
```java
//  modifier (키워드) dataType variableName;
    public static int count;
```
- static 변수를 외부에서 접근할때는 인스턴스가 아닌 class로 접근한다. 다만 static 변수를 다루는 method는 객체로 접근할 수 있다. 
  - 물론 인스턴스로 정적변수에 접근 할 수도 있다. 하지만 사용자 입장에서 이것이 인스턴스변수인지 클래스변수인지 혼란을 줄 수 있어 권장하지 않는다. 
```java
//  static 변수에 접근하는 메서드가 static이 아닌경우 객체로 접근
    Data data3 = new Data("C");
    System.out.println("C count = "+data3.getCount());
//  인스턴스가 아닌 클래스로 접근
    System.out.println(Data.count);
```
- 클래스 내부의 메서드에서 접근하는 경우 클래스를 생략할 수있지만 매개변수 이름이 같은 경우 this(인스턴스 자신을 가리킴)대신 클래스 이름을 사용한다. 
```java
    public void setCount(int count) {
        Data.count = count;
    }
```
- static/class/정적 변수는 인스턴스의 틀인 클래스에서 특별하게 관리하는 변수이다. 객체는 여럿이지만 클래스는 하나뿐이므로 static/class/정적 변수도 하나만 존재한다. 
- 어떤 클래스에서 공용으로 관리하고 싶은 데이터가 있는경우 클래스 변수를 사용한다.

[실습](../../src/step02_basic/chapter07_virtalMachine/javaMemory3/static_variable1)

### 3. 변수와 생명주기
| 종류                                      | 보관 위치                                                 | 생명주기                                                                                                     |
|-----------------------------------------|-------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| local <br/>variable <br/>(parameter 포함) | 선언된 메서드가 있는 스택 메모리의 프레임에 보관                           | 스택 프레임과 함께 생성되고 사라진다. 메서드가 종료되면 사라진다.                                                                    |
| instance <br/>variable                  | 멤버 변수 중 한 종류. 각 인스턴스 별로 관리되므로 힙영역에 저장된다.              | 해당 인스턴스를 대상으로하는 참조가 없어지면 GC에 의해 사라지는데 이때 함께 제거된다.                                                        |
| class/static <br/>variable              | 멤버 변수 중 한 종류. 클래스가 관리하는 변수로 클래스 데이터와 함께 메서드 영역에 저장한다. | 메서드 영역은 해당 클래스가 JVM에 로딩되는 순간 생성되는데, JVM은 자바 프로그램이 시작하면 전체 클래스를 컴파일링하기에 JVM과 생명주기를 공유한다. 정적 변수 역시 이와 함께한다 |

## E. static method
### 1. 사용처
- 멤버 변수가 없고 단순히 기능만 제공하는 메서드인 경우 매번 인스턴스를 생성하는 것이 의미가 없다. 
```java
public class DecoUtil{
  public String decoStr(String str){
    return "*"+str+"*";
  }
}

public static void main(String[] args) {
    String str = "hello";
    DecoUtill decoUtil1 = new DecoUtil();
    decoUtill1.decoStr(str);
    DecoUtill decoUtil2 = new DecoUtil();
    decoUtill2.decoStr(str);
    DecoUtill decoUtil3 = new DecoUtil(); 
    decoUtill3.decoStr(str);
}
```
- method에 static을 붙이면 정적 메서드가 되면서 인스턴스 변수 없이 클래스로 호출해 바로 사용이 가능하다. 

[실습](../../src/step02_basic/chapter07_virtalMachine/javaMemory4/static_method1/DecoMain.java)
- 변수와 마찬가지로 
  - 클래스 변수는 접근제어자 뒤에 'static'을 사용
  - 메서드 영역의 클래스에서 관리하므로 클래스로 호출
  - 인스턴스를 사용하거나 반환하지 않음
  - static이 없는 메서드를 인스턴스 메서드라고한다. 

### 2. static과 istance
- static method는 static method나 static variable만 사용할 수 있다. 
  - 참조주소를 지닌 객체(포인터) 지정없이 대상을 참조하는 일이 되어 시스템을 중단시킨다. 
  - 다만 인스턴스 메서드에서는 정적 메서드나 정적 변수를 사용하는 것은 무관하다
- 사용하고 싶다면 값을 매개변수로 전달해서 사용
  - ```java
    public static void useInstance(DecoData decoData){
        decoData.instanceValue+="\n    value";
        decoData.instanceMethod();
    }
  ```
- 자주 호출하는 static method나 해당 클래스가 있다면 import 시켜서 사용
```java
//method가 여럿포함된 클래스
import static static_method2.DecoData.*;
//method 하나인 경우
import static static_method2.DecoData.staticCall;
```
[실습](../../src/step02_basic/chapter07_virtalMachine/javaMemory4/static_method2/DecoMain.java)

### 3. main()
- 인스턴스 없이 사용하는 대표적인 정적메서드
```java
public static void main(String[] args) { }
```

## F. 연습문제
```dockerfile
문제1: 구매한 자동차 수
다음 코드를 참고해서 생성한 차량 수를 출력하는 프로그램을 작성하자.
Car 클래스를 작성하자.

    public class CarMain {
     public static void main(String[] args) {
     Car car1 = new Car("K3");
     Car car2 = new Car("G80");
     Car car3 = new Car("Model Y");
     Car.showTotalCars(); //구매한 차량 수를 출력하는 static 메서드
     }
    }

실행 결과 
    차량 구입, 이름: K3
    차량 구입, 이름: G80
    차량 구입, 이름: Model Y
    구매한 차량 수: 3
```
[실습](../../src/step02_basic/chapter07_virtalMachine/ex/javaMemory1Question/CarMain.java)
```dockerfile
문제2: 수학 유틸리티 클래스
다음 기능을 제공하는 배열용 수학 유틸리티 클래스( MathArrayUtils )를 만드세요.
    sum(int[] array) : 배열의 모든 요소를 더하여 합계를 반환합니다.
    average(int[] array) : 배열의 모든 요소의 평균값을 계산합니다.
    min(int[] array) : 배열에서 최소값을 찾습니다.
    max(int[] array) : 배열에서 최대값을 찾습니다.
요구사항
    MathArrayUtils 은 객체를 생성하지 않고 사용해야 합니다. 누군가 실수로 MathArrayUtils 의 인스턴스
    를 생성하지 못하게 막으세요.
    실행 코드에 static import 를 사용해도 됩니다.
    실행 코드와 실행 결과를 참고하세요.
실행 코드 
    public class MathArrayUtilsMain {
     public static void main(String[] args) {
     int[] values = {1, 2, 3, 4, 5};
     System.out.println("sum=" + MathArrayUtils.sum(values));
     System.out.println("average=" + MathArrayUtils.average(values));
     System.out.println("min=" + MathArrayUtils.min(values));
     System.out.println("max=" + MathArrayUtils.max(values));
     }
    }

실행 결과 
    sum=15
    average=3.0
    min=1
    max=5
```
[실습](../../src/step02_basic/chapter07_virtalMachine/ex/javaMemory2Question/MathArrayUtilsMain.java)

