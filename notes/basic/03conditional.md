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
- if-else if문을 사용할때 너무 많은 조건을 검사하는 경우 가독성이 나빠짐. 
- 주어지는 변수의 리터럴 비교로만 분기를 정할경우 if문보다 switch문이 유용하다.
```java
    switch(조건식){
        case 값1 :
            코드블럭;
            break;
        case 값2: 
        case 값3: 
            코드블럭;
            break;
//      ...
        default:
//            else와 같은 역할
        
    }
```
- switch-case는 if문을 사용하는 예시 중 일부를 간결하게 작성하도록 도와준다.
- case문에 break가 없으면 아래의 case도 함께 실행
[실습](../../src/chapter03_condition/Condition2.java)

새로운 switch문(java 14)
```java
    int result = switch (조건문){
        case 값1 -> 반환값1;
        case 값2 -> 반환값2;
        case 값3 -> 반환값3;
        default -> 기본반환값; 
//   ...    
    }
```
## C. 삼항연산자
- 단순히 조건 하나를 기준으로 하나의 변수의 값을 변경할때 사용. 
- 필요에 따라 여러 조건을 중복으로 입력할 수 있으나 가독성이 떨어지므로 권장하지 않음
```java
    int var = 조건문 ? 참일때 반환값 : 거짓일때 반환값;
```
[실습](../../src/chapter03_condition/Condition3.java)
## D. 연습문제
```dockerfile
문제1. 학점계산하기
    학생의 점수를 기반으로 학점을 출력하는 프로그램을 작성
        90 이상 > A
        80 이상 90 미만 > B
        70 이상 80 미만 > C
        60 이상 70 미만 > D
        60 미만 F
        각 점수대에서 F를 제외하고 
            0~3 > -
            4~6 > 0
            7~9 > +
```
[실습](../../src/chapter03_condition/ex/Condition1Question.java)

```dockerfile
문제2. 거리에 따른 운송수단 선택
        1Km 이하 > 도보
        10Km 이하 > 자전거
        100km 이하 > 자동차
        그 이상 > 비행기
        거리는 변수 distance로 지정하고 운송수단을 출력
        ...를 이용하세요.
```
[실습](../../src/chapter03_condition/ex/Condition2Question.java)
```dockerfile
문제3: 환율계산하기
    특정 금액을 미국 달러에서 한국 원으로 변환하는 프로그램 작성. 환율은 1달러당 1300원이라고 가정.
        달러가 0미만이면 "잘못된 금액입니다."
        달러가 0일때 "환전할 금액이 없습니다."
        달러가 0초과일때 "환전 금액은 (계산 결과)원입니다."
```
[실습](../../src/chapter03_condition/ex/Condition3Question.java)
```dockerfile
    문제4. 평점에 따른 영화 추천하기
    요청한 평점 이상의 영화를 찾아서 추천하는 프로그램
        평점 9이상: 어바웃타임
        평점 8이상: 토이스토리
        평점 7이상: 고질라
        평점 6이상: 엄복동
    (영화이름)을 추천합니다.
```
[실습](../../src/chapter03_condition/ex/Condition4Question.java)
```dockerfile
    문제5. 학점에 따른 성취도 출력
    A > 탁월한 성과입니다.
    B > 좋은 성과입니다.
    C > 준수한 성과입니다.
    D > 향상이 필요합니다.
    F > 불합격입니다. 
    나머지 > 잘못된 학점입니다. 
```
[실습](../../src/chapter03_condition/ex/Condition5Question.java)
```dockerfile
    문제6.더 큰 숫자 찾기
    두개의 임의의 정수 a, b가 주어질때 삼항연산자를 사용해 두 수중 더 큰 숫자를 출력하는 코드를 작성하기
```
[실습](../../src/chapter03_condition/ex/Condition6Question.java)
```dockerfile
    문제7.홀수, 짝수 찾기
    임의의 정수 x가 주어졌을때
    x가 짝수면 "짝수"를 홀수면 "홀수를 출력"
```
[실습](../../src/chapter03_condition/ex/Condition7Question.java)
