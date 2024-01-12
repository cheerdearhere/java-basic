# IV. 변수(Variable) - [코드 보기](../../src/chapter01_variable/Var1.java)
## A. 변수를 사용하면 좋은 점
- 코드 수정시 변경이 용이하고 오입력 가능성을 낮춤.
- 변수 명 자체가 용도를 표시하므로 코드의 가독성을 높임.
## B. 변수 처리 방식
### 1. 변수 선언
```java
    int i;//변수의 선언
```
- int: 변수의 자료유형
- i: 변수의 이름
  값은 지정되지 않은 상태로 값이 저장될 위치(보관소, 메모리 주소)를 확보
### 2. 변수 초기화(값 대입)
```java
//    i = 8; 초기화 후 대입
    int i = 8;//초기화와 동시에 대입 가능
    int a=3, b=4, c=5;//같은 값의 변수의 경우 한 번에 지정 가능
```
- =: 자바에서 '=' 기호는 equal 이 아닌 오른쪽 값을 왼쪽 변수에 입력함을 의미
- 선언과 초기화는 따로 진행할 수 있다.
- 변수를 선언하면 값을 가상 메모리에 값을 저장하고 필요할때 메모리 주소를 이용해 값을 읽어온다.
- 평소의 값은 메모리주소, 실제 값은 리터럴을 전달
### 3. 변수의 값 변경
- 저장된 메모리 주소의 값이 변경되어 그 line 이후 호출되는 해당 변수는 변경된 값으로 사용됨
```java 
    int a;  //변수 선언 a(지정되지 않음)
    a = 10; //변수 초기화 a(10)
    System.out.println(a);//10
    a = 50; // 값 변경 a(50)   
    System.out.println(a);//50
```
- 초기화하지 않고 변수를 사용하면 컴파일 단계에서 NullPointException 발생
- javascript에서는 undefinited 또는 null이 표기 됨
- 이런 오류를 방지하기위해 라이브러리와 프레임워크에서 사용하는 상수는 값을 미리 초기화해놓는다.

## C. 변수 타입 [실습 코드](../../src/chapter01_variable/Var2_type.java)
```java
//        기본단위 8bit
byte    b       = 125;            // -128 ~ 127
//        정수
short   sh      = 32000;          // 2bytes : -32,768 ~ 32,767
int     i       = 2100000000;     // 4bytes : -2,147,483,648 ~ 2,147,483,647
long    l       = 1000000000200L; // 8bytes : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
//        실수: 부동소수점 사용(부호용 1자리+부동소수점)
float   f       = 100.0F;         // 4bytes : 7자리 정밀도 
double  d       = 10.5;           // 8bytes : 15자리 정밀도
//        문자관련
char    c       = 'A';            // 1byte  : 문자 하나
String  str     = "String data";  //비정형(final로 선언된 문자 배열)
//        기타
boolean bool    = true;           // 1byte  : true, false
var     v       = 1;              // 비정형
```
- 타입이 이미 지정된 변수에 다른 타입의 값을 넣으면 컴파일 에러가 발생한다. 
- 리터럴 literal: 변수의 이름이 아닌 값 그 자체를 리터럴이라 한다. 변수의 값은 변경할 수 있어도 리터럴 그 자체를 변경할 수 없다.  
- 메모리 크기(숫자 범위)보다 큰 값을 넣으면 컴파일 에러가 발생(stack over flow)
- 숫자 타입의 경우 크기에 따라 여러 종류의 타입을 사용하므로 기본적으로 지정되는 리터럴 유형이 있다. 
```dockerfile
    정수: int
    실수: double
```
- 실무에서는 byte, short, float, char는 특별한 용도가 아닌이상 사용하지 않는다. 
```dockerfile
  byte: 파일을 전송하는 경우 바이트스트림을 주로 사용하므로 그때 배열용으로 사용.
  short: 정말 거의 사용안함.
  float: 길이와 정밀도가 낮아 거의 사용 안함.
  char: 문자 하나를 표현할때도 문자열(String)을 사용하는 경우가 많음. 검색 또는 암호화, 복호화 등 특별한 경우
```
## D. 변수 명명 규칙
- 규칙: 지키지 않으면 컴파일 에러 발생, 어차피 에러가 발생하므로 참고만
```java
    1num; //숫자가 제일 앞에는 못옴
    String name is; // 띄어쓰기 불가
    int class; //java의 예약어 불가
    String a^aa; // $, _, 숫자, 알파벳으로만
```
- 관례: 에러는 발생하지 않지만 일반적으로 사용하는 방식
```java
    String camelCase; //java에서 주로
    String snakeCase; //sql문, html에서 주로
```
- class는 대문자로, 그외 패키지, 변수 등은 소문자로
- 다만 상수는 대문자+'_'로 
```java
package packages.under.minorPackge;
class ClassName (){
    int variableName;   
    String snake_name;
    final static long  STATIC_VARIABLE_NAME;
}
```

## E. 연습 문제
```dockerfile
  문제1: 다음 코드에 반복해서 나오는 숫자 4, 3을 다른 숫자로 한번에 변경할 수 있도록 변경하세요.
     System.out.println(4+3);
     System.out.println(4-3);
     System.out.println(4*3);
```
[문제1 풀이](../../src/chapter01_variable/ex/VarEx1Question.java)
```dockerfile
    문제2: 다음과 같은 작업을 수행하는 프로그램을 작성하세요.
      1. 변수 num1을 선언하고 이에 10을 할당하세요.
      2. 변수 num2를 선언하고 이에 20을 할당하세요.
      3. 두 변수의 합을 구하고, 그 결과를 새로운 변수 sum에 저장하세요.
      4. sum 변수의 값을 출력하세요.
```
[문제2 풀이](../../src/chapter01_variable/ex/VarEx2Question.java)
```dockerfile
    문제 3: long 타입의 변수를 선언하고 그 변수를 100억으로 초기화한 후 출력하는 프로그램을 작성하세요.
        boolean 타입의 변수를 선언하고 그 변수를 true로 초기화한 후 출력하는 프로그램을 작성하세요.
```
[문제3 풀이](../../src/chapter01_variable/ex/VarEx3Question.java)
