# V. 스코프와 형변환
## A. scope
- 선언한 위치에 따라 지역변수, 멤버변수(class, instance variable)로 분류한다. 
### 1. Local Variable(지역변수) 
- 지역변수는 해당 변수가 선언된 지역, 코드 블럭({})내에서만 사용할 수 있으며 이를 벗어난 곳에서는 사용할 수 없다. 
```java
public class ClassArea{
//    지역변수 v 없음
    public static void main(String[] args){
        int v = 10;//지역변수 선언, 초기화 
        if(true){
            int x = 20;//if 구문 내의 지역변수
            //지역변수 v, x 모두 존재
        }//지역변수 x 만료(제거)
        //지역변수 v만 사용가능
    }//지역변수 v 만료
//    지역변수 v 없음
}
```
- 접근범위(scope)는 효율적인 메모리사용, 코드 복잡성을 낮출 때 사용한다.
    - 메모리 효율: 필요한 곳에서 필요한 만큼만 사용하고 GC로 돌려 메모리효율을 높임
    - 코드 복잡성: 선언, 생성, 만료 등 변수의 생명주기(life cycle)가 지역 내에서만 관리되므로 그 외 지역에서는 신경쓰지 않아도 된다.
- while과 for에서의 scope
  - while: 반복문의 반복 횟수를 관리하는 변수가 반복문 외부에 존재.
  - for: 반복문의 반복 횟수를 관리하는 변수가 반복문 내부에 존재. 

[실습](../../src/chapter05_scope_casting/Scope1.java)

### 2. Member Variable (member/class/instance variable)
- 멤버변수는 stack memory에서 class가 생성되는 시점에서 생성되기때문에 전역에서 사용가능하다.

## B. 형변환
- 작은 범위에서 큰 범위로는 당연히 값을 넣을 수 있다. 
  - int > long > double
- 큰 범위에서 작은 범위로 넣으면 다음과 같은 문제가 발생할 수 있다. 
  - 표현 범위 외 모두 버림
  - 오버플로우 발생
### 1. 자동형변환
- 작은 범위의 값을 큰 범위의 변수에 대입하면 별다른 문제나 코드 없이 대입이 가능하다.
- 형변화를 표시하지 않고도 자동으로 형변환이 이뤄지기때문에 자동형변환, 묵시적형변환이라고 읽는다.
```java
    int intValue = 10;
    long longValue;
    double doubleValue;
    longValue = intValue;
    doubleValue = intValue;
```
- java는 기본적으로 같은 타입에 값을 대입할 수 있다. 
- 다른 타입인 경우라도 같은 유형(숫자, 문자 등), 더 큰 범위라면 대입가능
```java
  doubleValue = (double) intValue;
```

[실습](../../src/chapter05_scope_casting/Casting1.java)
### 2. 명시적 형변환
- 큰 범위에서 작은 범위로 대입하는 경우 크기를 벗어난(표현이 불가한) 값은 버리거나 overflow를 발생시킬 수 있어 개발자의 동의(명시)가 필요하다. 
```java
    double doubleValue = 1.4;
    int intValue;
    intValue = (int)doubleValue;//intValue == 1
```
- 이처럼 직접 작성해야만 동작하는 형변환을 명시적 형변환이라 한다.
- 명시적 형변환으로 인한 오차, 에러는 개발자의 책임
- overflow는 명백한 에러. 그 범위를 계산하기보다는 처음부터 어느정도 넓은 범위의 자료형을 쓰는 것이좋다. 
  - int > long
  - float > double

[실습](../../src/chapter05_scope_casting/Casting2.java)

### 3. 계산과 형변환
- 형변환은 대입뿐 아니라 연산 과정에서도 발생한다. 
- java에서
  - 같은 타입끼리의 계산은 같은 타입의 결과를 도출한다.
  - 다른 타입끼리의 계산은 더 큰 범위로의 자동형변환이 발생한다.
```java
        int div1 = 3/2; //int/int > int
        System.out.println("div1 = " + div1);//1
        double div2 = 3/2; //int/int > int > double 변수에 대입
        System.out.println("div2 = " + div2);//1.0
        double div3 = 3.0/2; // double/int > double 
        System.out.println("div3 = " + div3);//1.5
        double div4 = (double) 3 / 2; // (double)int/int > double/int > double
        System.out.println("div4 = " + div4);//1.5
```
- 리터럴이 아닌 변수도 마찬가지

[실습](../../src/chapter05_scope_casting/Casting3.java)