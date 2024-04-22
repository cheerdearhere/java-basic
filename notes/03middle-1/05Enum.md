
[실습 코드](../../src/step03_middleClass/chapter05_Enum)

# I. 열거형이 필요한 이유
## A. 예제 1
```
- 회원 등급별 할인율
BASIC: 10% 할인
GOLD: 20% 할인
DIAMOND: 30% 할인
- 회원 등급과 가격을 입력하면 할인 대상 금액을 반환
```
```java
public int discount (String grade, int price){
    if(grade==null||grade.isBlank()||price<1) return price;
    
    int discountPercent = 0;
    
    if(grade.equals("BASIC")) discountPercent = 10;
    else if (grade.equals("GOLD")) discountPercent=20;
    else if (grade.equals("DIAMOND")) discountPercent=30;
    else System.out.println(grade+": 할인 x ");
    
    return price*discountPercent/100;
}
```
```java
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount("BASIC", price);
        int goldDiscount = discountService.discount("GOLD", price);
        int diamondDiscount = discountService.discount("DIAMOND", price);
        
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
```
- 작동은 하나 단점: 타입 안정성, 데이터 일관성 부족(값 제한 부족)
  - 타입 안정성
    - 개발자가 직접 입력(하드코딩)해야하다보니 오타의 여지가 있음
    - 유효하지 않은 값으로 인해 의도하지 않은 값이 나올 수 있음
  - 데이터 일관성
    - 소문자도 ignore 처리가 되지 않은 경우도 오타와 같음
- 또한 컴파일시 오류감지가 불가
```java
    int errorDiscount = discountService.discount("ERROR", price);
    int zeroDiscount = discountService.discount("ZERO", 0);
    int lowerClassDiscount = discountService.discount("gold",price);
```
- 해결방법: 특정범위 값 제한이 필요하다
## B. 예제2
- 미리 정의한 상수로 미리 지정해 입력가능한 값의 범위를 제한한다.  
```java
public class StringGrade {
    public static final String BASIC = "BASIC";
    public static final String GOLD = "GOLD";
    public static final String DIAMOND = "DIAMOND";
}
//method
public int discount (String grade, int price){
    if(grade==null||grade.isBlank()||price<1) return price;

    int discountPercent = 0;

    if(grade.equals(StringGrade.BASIC)) discountPercent = 10;
    else if (grade.equals(StringGrade.GOLD)) discountPercent=20;
    else if (grade.equals(StringGrade.DIAMOND)) discountPercent=30;
    else System.out.println(grade+": 할인 x ");

    return price*discountPercent/100;
}
//main
public static void main(String[] args) {
    int price = 10000;

    DiscountService discountService = new DiscountService();
    int basicDiscount = discountService.discount(StringGrade.BASIC, price);
    int goldDiscount = discountService.discount(StringGrade.GOLD, price);
    int diamondDiscount = discountService.discount(StringGrade.DIAMOND, price);

    System.out.print(
            "Basic: " + basicDiscount
                    + "\nGold: " + goldDiscount
                    + "\nDiamond: " + diamondDiscount
                    +"\n"
    );
}
```
- 장점: 컴파일 시점에서 체크 가능
- 한계
  - 지금까지 발생한 문제들의 근본적 해결책이 아님: StringGrade 타입을 사용하지 않고 직접 문자열 입력이 가능
  - 주석을 통해 표시할 수 있으나 여전히 제한이 부족함
    ```java
        int errorDiscount = discountService.discount("Error",price);
    ```
  - 상수의 위치를 모를 수 있음
  - 잘못된 입력이 되는 것은 결국 설계한 개발자 잘못
# II. 타입 안전 열거형 패턴(Type-Safe Enum Pattern)
- 열거형(enumeration): 어떤 항목을 나열하는 것
  - 나열한 항목 외에 다른 값을 사용할 수 없도록 제한
## A. 구현
- 등급을 나누는 클래스 생성, 각각 등급별로 상수를 선언
- 각각 상수마다 별도의 인스턴스를 생성하고 그것을 대입
  - 같은 타입이지만 다른 인스턴스
- 각각을 상수로 선언할 때 `static`, `final` 사용
  - `static`: 상수를 메서드 영역에 선언
  - `final`: 인스턴스(참조 값) 변경 제한
```java
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();
}
```
## B. 사용
- 매개변수에서부터 원치않는 값을 제한할 수있음
```java
    public int discount (ClassGrade classGrade, int price){
        if(price<1) return price;

        int discountPercent = 0;

        if(classGrade==ClassGrade.BASIC) discountPercent = 10;
        else if (classGrade==ClassGrade.GOLD) discountPercent=20;
        else if (classGrade==ClassGrade.DIAMOND) discountPercent=30;
        else System.out.println(": 할인 x ");

        return price*discountPercent/100;
    }
```
- main
```java
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(ClassGrade.BASIC, price);
        int goldDiscount = discountService.discount(ClassGrade.GOLD, price);
        int diamondDiscount = discountService.discount(ClassGrade.DIAMOND, price);
        
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
```
## C. 한계와 해결
- 오해로인해 객체를 생성해서 사용하면 아무런 작동을 안함
```java
    //parameter 정보를 오해해 객체를 사용하는 경우
    ClassGrade classGrade = new ClassGrade();
    int misunderDiscount = discountService.discount(classGrade, price);
```
: 생성자 접근을 private으로 처리
- null 값
```java
    //null 사용
    int nullDiscount = discountService.discount(null, price);
```
: null 값에 대한 대응

## D. 타입 안전 열거형 패턴(type-safe enum pattern)
- 내부에 사용할 인스턴스만 생성해 나열
- 생성자를 외부에서 접근 할 수 없도록 private으로 생성자 지정
```java
    //private default constructor
    private ClassGrade() {}
```
### 1. 장점
- 타입 안정성: 정해진 타입만 사용할 수 있음
- 데이터 일관성: 정해진 객체만 사용할 수 있음
- 제한된 인스턴스: 제한된 인스턴스만 사용하기때문에 미리 정의된 값으로 사용을 제한 시킬 수 있다. 
- 컴파일 체크: 사용되는 값에 있어서 잘못된 부분에 컴파일러가 체크한다

### 2. 보완 필요...
- 많은 코드를 적어야하는 불편함
- 자주 사용되다보니 Enum 타입으로 자바에서 제공

# III. 열거형(Enum type)
