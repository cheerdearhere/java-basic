
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
- 열거형 패턴(Type-Safe Enum Pattern)을 매우 쉽게 사용할 수 있는 열거형(Enum type) 제공
- 열거형의 장점
  - 타입 안정성 제공
  - 코드 가독성 향상
  - 예상 가능한 값들의 집합 표현
## A. 생성
- 직접 입력하면 각각 인스턴스를 묵시적으로 생성함
- 생성자도 private 
- class 키워드 위치에 enum 입력
```java
public enum Grade {
    BASIC, GOLD, DIAMOND
}
```
- 열거형도 enum을 위한 class
```
class Basic: class step03_middleClass.chapter05_Enum.useEnum.Grade
class Gold: class step03_middleClass.chapter05_Enum.useEnum.Grade
class Diamond: class step03_middleClass.chapter05_Enum.useEnum.Grade
ref: 7291c18f
ref: 34a245ab
ref: 7cc355be
```
- 사용자체는 type-safe enum pattern과 같음
## B. Enum type 장점
- 타입 안정성 향상
- 간결성 및 일관성
- 확장성
- 유용한 매서드가 사용을 도움
- `import`로 해당 클래스를 입력한 경우 Enum 타입을 표시하지 않을 수 있어 가독성을 더 확보할 수 있다.  
```java
import static step03_middleClass.chapter05_Enum.useEnum.Grade.*;
//...
    public int discount (Grade grade, int price){
        if(grade==null||price<1) return price;

        int discountPercent = 0;

        if(grade==BASIC) discountPercent = 10;
        else if (grade==GOLD) discountPercent=20;
        else if (grade==DIAMOND) discountPercent=30;
        else System.out.println(": 할인 x ");

        return price*discountPercent/100;
    }
```
## C. 주요 매서드
- 모든 Enum 형은 java.lang.Enum을 상속받으므로 그 기능을 사용할 수 있다. 
- `values()`: 모든 Enum 반환
  - `name()`: ENUM 상수의 이름(name)을 문자열로 반환
  - `ordinal()`: ENUM 상수의 선언 순서(배열 index)
    - 가능한 사용 x. 상수가 추가되거나 변경되면 사용된 모든 곳에서 사이드이펙트 발생
    - 단순한 열거형 자료는 대비가 되지만 에러코드, RESPONSE_CODE 등 복잡한 열거형은 큰 문제를 야기시킨다
  - `toString()`: ENUM 상수의 이름을 문자열을 반환. name과 같은 기능
    - Object의 메서드 toString을 사용하는 곳에서 처리하기위한 재정의 매서드

```java
    Grade[] values = Grade.values();
    System.out.println("Grade values: "+ Arrays.toString(values));
    Stream.of(values).forEach(value->{
    System.out.println("name: "+value.name()+"/ ordinal: "+value.ordinal());
    });
```
```
Grade values: [BASIC, GOLD, DIAMOND]
name: BASIC/ ordinal: 0
name: GOLD/ ordinal: 1
name: DIAMOND/ ordinal: 2
```
- `valueOf(String str)`: Enum의 name과 같은 문자열을 Enum으로 변환
  - 단, 본래 등록된 Enum이 아닌 경우 IllegalArgumentException 에러 발생
  - 대소문자 구분
```java
    String lowerGold = "gold";
    String upperGold = lowerGold.toUpperCase();
    Grade lowerGoldEnum = Grade.valueOf(lowerGold);
    Grade upperGoldEnum = Grade.valueOf(upperGold); 
    System.out.println(lowerGoldEnum);
    System.out.println(upperGoldEnum);
```
```
Exception in thread "main" java.lang.IllegalArgumentException: No enum constant step03_middleClass.chapter05_Enum.useEnum.Grade.gold
	at java.base/java.lang.Enum.valueOf(Enum.java:293)
	at step03_middleClass.chapter05_Enum.useEnum.Grade.valueOf(Grade.java:3)
	at step03_middleClass.chapter05_Enum.useEnum.EnumMethodMain.main(EnumMethodMain.java:17)
```
## D. 더 리팩토링
### 1. Type-Safe enum pattern에 값 넣어 사용하기
- 각각 등급마다 할인율이 달라짐 => 개별 할인율 정보를 enum에 담아 사용
  - 열거형 자료(인스턴스)를 생성할때 할인율도 처리
```java
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(10);
    public static final ClassGrade GOLD = new ClassGrade(20);
    public static final ClassGrade DIAMOND = new ClassGrade(30);

    private final int discountPercent;

    //private default constructor
    private ClassGrade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
```
- 사용하는 곳에서 if문을 남발하지 않고 바로 처리
```java
public int discount (ClassGrade grade, int price){
    if(grade==null||price<1) return price;
    return price * grade.getDiscountPercent() / 100;
//        int discountPercent = 0;
//
//        if(grade==BASIC) discountPercent = 10;
//        else if (grade==GOLD) discountPercent=20;
//        else if (grade==DIAMOND) discountPercent=30;
//        else System.out.println(": 할인 x ");
//
//        return price*discountPercent/100;
}
```
### 2. Enum type으로 값 사용하기
- 같은 방식이지만 여러부분을 간략히 처리
  - `new 생성자`를 직접 표시하지않음
```java
public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30), VIP(40);

    private final int discountPercent;

    Grade (int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
      return discountPercent;
    }
}
```
```java
import static step03_middleClass.chapter05_Enum.refactoring.Grade.*;

public class DiscountMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 10000;

        int basicDiscount = discountService.discount(BASIC, price);
        int goldDiscount = discountService.discount(GOLD, price);
        int diamondDiscount = discountService.discount(DIAMOND, price);

//        Grade grade = new Grade();
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
```
### 3. Enum의 데이터를 사용하는 계산 내부화시키기
- 굳이 Service 객체에 Enum의 데이터를 노출할 필요가 없다 
- 캡슐화 원칙에 좀더 알맞도록 계산도 Enum으로 내부화시켜 데이터 노출을 최소화한다
```java
public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30), VIP(40);

    private final int discountPercent;

    Grade (int discountPercent) {
        this.discountPercent = discountPercent;
    }
    public int getDiscountPercent() {
        return discountPercent;
    }
    public int getDiscountPrice(int price){
        return price * discountPercent / 100;
    }
}
```
- 함수 단순화
```java
public int discount (Grade grade,int price){
    return grade.getDiscountPrice(price);
}
```
- Service의 개입 제거
  - 등급별로 할인율이 적용되기에 사용 가능
  - 캡슐링 
```java
//        int basicDiscount = discountService.discount(BASIC, price);
//        int goldDiscount = discountService.discount(GOLD, price);
//        int diamondDiscount = discountService.discount(DIAMOND, price);
        System.out.print(
            "Basic: " + BASIC.getDiscountPrice(price)
            + "\nGold: " + GOLD.getDiscountPrice(price)
            + "\nDiamond: " + DIAMOND.getDiscountPrice(price)
            +"\n"
                    );
```
- 출력부분(main)에서 중복 제거
```java
    private static void printDiscountInfo(int price) {
        System.out.print(
                "## information about the discount\n"
                + "\t - " + BASIC.name() + " 등급의 할인 금액: " + BASIC.getDiscountPrice(price) + "\n"
                + "\t - " + GOLD.name() + " 등급의 할인 금액: " + GOLD.getDiscountPrice(price) + "\n"
                + "\t - " + DIAMOND.name() + " 등급의 할인 금액: " + DIAMOND.getDiscountPrice(price) + "\n"
        );
    }
```
### 4. Enum 반복 돌리기
- 이런 함수를 사용하는 경우
```java
private static void printDiscountInfo(Grade grade, int price) {
    System.out.print(grade.name() + " 등급의 할인 금액: " + grade.discount(price));
}
```
- 열거형의 내부 객체가 추가될때 매번 추가해야함
```java
    printDiscountInfo(BASIC, price);
    printDiscountInfo(GOLD, price);
    printDiscountInfo(DIAMOND, price);
```
- 열거형의 반복
  - 반복문으로 순회를 만들면 등급 변경에도 따로 수정이 필요없다
```java
    for(Grade grade: Grade.values()){
        printDiscountInfo(grade.getDiscountPrice(price));
    }
```
# IV. 실습 문제
## A. 문제 1: 회원 시스템
```
문제1-1 - 인증 등급 만들기
문제 설명
패키지의 위치는 enumeration.test 를 사용하자.
회원의 인증 등급을 AuthGrade 라는 이름의 열거형으로 만들어라.
인증 등급은 다음 3가지이고, 인증 등급에 따른 레벨과 설명을 가진다. 레벨과 설명을 getXxx() 메서드로 조회할 수
있어야 한다.
    GUEST(손님)
        level=1
        description=손님
    LOGIN(로그인 회원)
        level=2
        description=로그인 회원
    ADMIN(관리자)
        level=3
        description=관리자

문제1-2 - 인증 등급 열거형 조회하기
문제 설명
AuthGradeMain1 이라는 클래스를 만들고 다음 결과가 출력되도록 코드를 작성해라.
앞서 만든 AuthGrade 을 활용하자
grade=GUEST, level=1, 설명=손님
grade=LOGIN, level=2, 설명=로그인 회원
grade=ADMIN, level=3, 설명=관리자

문제1-3 - 인증 등급 열거형 활용하기
문제 설명
AuthGradeMain2 클래스에 코드를 작성하자.
인증 등급을 입력 받아서 앞서 만든 AuthGrade 열거형으로 변환하자.
인증 등급에 따라 접근할 수 있는 화면이 다르다.
예를 들어 GUEST 등급은 메인 화면만 접근할 수 있고, ADMIN 등급은 모든 화면에 접근할 수 있다.
각각의 등급에 따라서 출력되는 메뉴 목록이 달라진다.
다음 출력 결과를 참고해서 코드를 완성하자.
GUEST 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: GUEST
    당신의 등급은 손님입니다.
    ==메뉴 목록==
    - 메인 화면
LOGIN 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: LOGIN
    당신의 등급은 로그인 회원입니다.
    ==메뉴 목록==
    - 메인 화면
    - 이메일 관리 화면
ADMIN 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ADMIN
    당신의 등급은 관리자입니다.
    ==메뉴 목록==
    - 메인 화면
    - 이메일 관리 화면
    - 관리자 화면
잘못된 값이 입력되는 경우
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: x
    Exception in thread "main" java.lang.IllegalArgumentException: No enum constant
    enumeration.test.AuthGrade.X
    at java.base/java.lang.Enum.valueOf(Enum.java:293)
    at enumeration.test.AuthGrade.valueOf(AuthGrade.java:3)
    at enumeration.test.AuthGradeMain2.main(AuthGradeMain2.java:12)
    참고: Enum.valueOf() 를 사용할 때 잘못된 값이 입력되면 예와 같이 IllegalArgumentException 예외가 발
    생한다. 해당 예외를 잡아서 복구하는 방법은 예외 처리에서 학습한다.
```
[실습 코드](../../src/step03_middleClass/chapter05_Enum/test/exam01)
## B. HttpStatus 
```
문제와 풀이2
문제 설명
enumeration.test.http 패키지를 사용하자.
HttpStatus 열거형을 만들어라.
HTTP 상태 코드 정의
    OK
        code: 200
        message: "OK"
    BAD_REQUEST
        code: 400
        message: "Bad Request"
    NOT_FOUND
        code: 404
        message: "Not Found"
    INTERNAL_SERVER_ERROR
        code: 500
        message: "Internal Server Error"
참고: HTTP 상태 코드는 200 ~ 299사이의 숫자를 성공으로 인정한다.

다음 HttpStatus 열거형을 완성해라. HttpStatusMain 코드와 실행 결과를 참고하자. 
    package enumeration.test.http;
    public enum HttpStatus {
     // 코드 작성
    }
    
    package enumeration.test.http;
    import java.util.Scanner;
    public class HttpStatusMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("HTTP CODE: ");
    int httpCodeInput = scanner.nextInt();
    HttpStatus status = HttpStatus.findByCode(httpCodeInput);
    if (status == null) {
    System.out.println("정의되지 않은 코드");
    } else {
    System.out.println(status.getCode() + " " + status.getMessage());
    System.out.println("isSuccess = " + status.isSuccess());
    }
    }
    }

실행 결과 
    HTTP CODE: 200
    200 OK
    isSuccess = true
    
    HTTP CODE: 400
    400 Bad Request
    isSuccess = false
    
    HTTP CODE: 404
    404 Not Found
    isSuccess = false
    
    HTTP CODE: 500
    500 Internal Server Error
    isSuccess = false
```
[실습 코드](../../src/step03_middleClass/chapter05_Enum/test/exam02)