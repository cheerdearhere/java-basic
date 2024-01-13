# VI. 조건문
위에서 아래로 한줄씩 실행되는 프로그램에서 특정 조건에 따라 다른 코드를 실행하도록함.
절차지향 프로그래밍에서 필수적인 구문으로 흐름을 제어한다.
## A. IF문
[실습](../../src/chapter03_condition/Condition1.java)

if문은 특정 조건이 참인지 확인하고, 그 조건이 참일경우 특정 코드블록을 실행한다. 
```java
    if(condition){
        //condition이 true일때 실행되는 코드블럭
    }
```
- if문만 사용하는 경우, 단점은 조건을 만족한 뒤에도 모든 조건문을 거쳐서 진행해, 조건이 많아질수록 리소스 낭비가 심하다.

else는 주어진 조건 외의 상황(조건문이 false)에서 작동할 코드블럭을 입력
```java
    if(condition){
        //condition이 true일때 실행
    }else{
        //condition이 false일때 실행
    }
```
else if는 여러 조건을 사용할 경우 불필요한 조건 검사를 줄일 수 있다. 
```java
    if(condition1){
        //condition1이 true일때
    }
    else if(condition2){
        //condition1이 false이면서 condition2가 true일때
    }
//        ...
    else{
        //모든 조건에 false일때
    }
```
- if-else-if문도 조건이 많아지면 길이가 길어지고 가독성이 나빠진다. 
- if문만 따로 쓰는 경우: 각 조건을 모두 체크하는 경우(독립조건일때)
- if-else if를 사용하는 경우: 조건들이 연계되어있어 그중 하나만 실행할 경우
- if, else를 사용할때 코드블럭이 한줄일때는 {}를 생략할 수 있다. 
```java
    if(condition) 
        System.out.println("true일때 출력");
        System.out.println("condition과 관계 없이 출력됨");
```
- 가독성을 낮춰 혼란을 줄 수 있으므로 권장하지는 않음.
- 유지보수를 진행할때 같은 조건 내에 다른 기능을 넣는 등의 유지보수에서 블럭이 있는 것이 좋다.
## B. switch - case
## C. 삼항연산자
## D. 연습문제