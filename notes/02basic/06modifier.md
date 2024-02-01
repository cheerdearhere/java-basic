# VI. Modifier
## A. 접근제어가 필요한 이유
- 같은 프로젝트, 패키지에 있다해서 모든 데이터에 접근 가능한 것이 좋은 것은 아니다. 
  - 프로그램을 사용하는 고객(클라이언트)이 굳이 알 필요가 없는 정보도 있고, 
  - 라이브러리나 모듈의 개발자는 필요하지만 사용자는 필요없거나 알면 안되는 정보가 있다. 
  - 내부 필드를 조절하는 method에 제한 조건이 있어도 외부에서 필드에 접근하면 내부 로직에 심각한 에러를 발생시킬 수 있어 위험하다.
```java
    public class Speaker{
        int volume;//볼륨 100이 넘으면 기기 파손
        public Speaker(int volume){
            this.volume = volume;
        }        
        void volumeUp(){
            if(volume<100){
                volume++;
            }else {
                System.out.println("더 이상 볼륨을 올릴 수 없습니다.");
            }
        }
    }
```
```java
public class DeviceService{
    Display display = new Display();
    //외부 패키지에서 필드에 개입 가능
    Speaker speaker = new Speaker(150); //기기파손 
}
```

- 접근제어자의 핵심은 속성과 기능을 외부로부터 숨기는 것이다

## B. 접근제어자의 종류
| 접근제어자     | 설명                                                              |
|-----------|-----------------------------------------------------------------|
| private   | class 제외 모든 외부 호출을 막는다                                          |
| default   | 같은 패키지 안에서의 호출은 허용한다(package-private)<br/>접근제어자를 작성하지 않으면 기본 적용 |
| protected | 같은 패키지와 상속관계에 있는 클래스에서의 호출은 허용한다                                |
| public    | 모든 외부 호출을 허용한다                                                  |

- 허용 범위
```dockerfile
private > (default) > protected > public
```

## C. 접근 제어자 사용
- 적용 위치: class, method, field, constructor
  - 지역변수는 쓸 수도 없고 쓸 필요도 없다. 

### 1. class 내부(field, method, constructor)
- 주의할 것은 하위 패키지도 결국 별개의 패키지라는 점
- 접근이 제한된 field, method도 public으로 선언된 내부 메서드를 통해 사용은 가능

[실습 코드](../../src/step02_basic/chapter06_modifier/modifier1)

### 2.class 레벨
- 클래스 레벨에서는 public과 default만 사용가능
- public class 이름은 반드시 파일명(.java)과 같아야한다. 
  - 하나의 java 파일에 public class(public class는 단 하나만) 외에 default class 여러개를 선언할 수 있다
  - 권장 x
```java
public class PublicClass{
    
}
class DefaultClass1{
    
}
class DefaultClass2{
    
}
//...
```
- .java 파일은 하나지만 JVM을 통해 번역되는 .class 파일은 여러개(별개의 class로 처리)
```java
    //같은 파일에 있어도 똑같이 생성자 사용
    DefaultClass1 defaultClass1 = new DefaultClass();
    defaultClass1.publicMethod();
```
- default로 선언된 class는 다른 패키지에서 호출 할 수 없다 

[실습](../../src/step02_basic/chapter06_modifier/modifier2)

## D. 캡슐화(Encapsulation)
- 객체지향 프르그래밍의 중요한 개념 중 하나
- 캡슐화는 데이터와 그것을 처리하는 메서드를 하나로 묶어 외부에서의 접근을 제한한다. 
- 이를 통해 개발자가 의도한 부분만 외부에 드러내고 나머지는 접근을 제한 시켜 보안과 안정성을 확보한다.

### 1. 데이터(field, method)
- field(member variable): 객체가 지닌 속성을 드러내면 클래스 내부의 모든 로직을 무시하고 데이터를 변경할 수 있어 보안상의 이슈가 발생할 수 있다. 
- method: 마찬가지로 핵심 로직 method가 외부에 드러날 경우 재정의 등을 통해 무력화 할 수있다.
- 스마트폰을 쓴다 해서 그 내부의 모든 데이터와 세부 모듈을 직접 조작하지는 않는다. 그저 스마트폰이 외부에 제공하는 서비스(기능)를 사용할 뿐이다. 프로그램도 마찬가지.
### 2. 기능(내부 상세 로직)
- 객체의 기능 중 외부에서 사용하지 않고 내부에서만 사용하는 기능은 가독성을 낮추고 사용자의 피로도도 높인다. 
- 우리에게 필요한 것은 스마트폰의 버튼과 탭 기능이지 상세가 아니다.

거의 대부분의 데이터는 private, 외부에 보여주기로 결정한 method만 public을 사용한다.

### 3. [적용해보기](../../src/step02_basic/chapter06_modifier/modifier3/BankAccountMain.java)

## E. 연습 문제
```dockerfile
문제1 - 최대 카운터와 캡슐화
MaxCounter 클래스를 만드세요.
이 클래스는 최대값을 지정하고 최대값 까지만 값이 증가하는 기능을 제공합니다.
    int count : 내부에서 사용하는 숫자 입니다. 초기값은 0입니다.
    int max : 최대값 입니다. 생성자를 통해 입력합니다.
    increment() 숫자를 하나 증가합니다.
    getCount() 지금까지 증가한 값을 반환합니다.
요구사항
    접근 제어자를 사용해서 데이터를 캡슐화 하세요.
    해당 클래스는 다른 패키지에서도 사용할 수 있어야 합니다.
java
    public class CounterMain {
     public static void main(String[] args) {
     MaxCounter counter = new MaxCounter(3);
     counter.increment();
     counter.increment();
     counter.increment();
     counter.increment();
     int count = counter.getCount();
     System.out.println(count);
     }
    }

실행 결과 
    최대값을 초과할 수 없습니다.
    3
```
[실습](../../src/step02_basic/chapter06_modifier/ex/modifier1Question/CounterMain.java)
```dockerfile
문제2 - 쇼핑 카트
ShoppingCartMain 코드가 작동하도록 Item , ShoppingCart 클래스를 완성해라.
요구사항
    접근 제어자를 사용해서 데이터를 캡슐화 하세요.
    해당 클래스는 다른 패키지에서도 사용할 수 있어야 합니다.
    장바구니에는 상품을 최대 10개만 담을 수 있다.
    10개 초과 등록시: "장바구니가 가득 찼습니다." 출력
실행 결과
    장바구니 상품 출력
    상품명:마늘, 합계:4000
    상품명:상추, 합계:12000
    전체 가격 합:16000
     
    main class
        public class ShoppingCartMain {
         public static void main(String[] args) {
         ShoppingCart cart = new ShoppingCart();
         Item item1 = new Item("마늘", 2000, 2);
         Item item2 = new Item("상추", 3000, 4);
         cart.addItem(item1);
         cart.addItem(item2);
         cart.displayItems();
         }
        }
    Item 클래스 
        public class Item {
         private String name;
         private int price;
         private int quantity;
         //TODO 나머지 코드를 완성해라.
        }
    
    ShoppingCart 클래스 
        public class ShoppingCart {
         private Item[] items = new Item[10];
         private int itemCount;
         //TODO 나머지 코드를 완성해라.
        }
```
[실습](../../src/step02_basic/chapter06_modifier/ex/modifier2Question/ShoppingCartMain.java)