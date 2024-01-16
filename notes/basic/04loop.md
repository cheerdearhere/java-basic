# V. 반복문
절차를 진행하는 중 특정 코드를 반복해서 실행할때 사용
```java
    count = count+1;
    System.out.println("count: "+count);        
    count = count+1;
    System.out.println("count: "+count);
    count = count+1;    
    System.out.println("count: "+count);
    count = count+1;
    System.out.println("count: "+count);
```
## A. while
- while문은 조건식이 false가 될때까지 반복수행한다.
- 조건식이 언제나 true인 경우 무한 루프에 빠져 문제가 생길 수 있으므로 이에대한 대비가 필요하다.
- 증감시점에 따라 값이 달라질 수 있음을 기억
```java
    while(조건식){
        //반복할 코드블럭
    }
```
[실습](../../src/chapter04_loop/Loop1.java)
## B. do-while
- 조건에 상관 없이 한번을 수행하도록 함
- 조건(while)과 수행(do)을 분리해서 수행문을 우선 적용함
- 주의사항은 while문과 동일
```java
    do{
        //수행할 코드블럭
    }
    while(조건문);//조건에 관계없이 do를 한번은 수행함.
```
[실습](../../src/chapter04_loop/Loop2.java)
## C. break, continue
| keyword  | 수행            | 수행결과          |
|----------|---------------|---------------|
| break    | 반복문 전체 즉시 종료  | 반복문 다음문장 진행   |
| continue | 반복 중 해당 순번 종료 | 반복문의 다음 순번 진행 |

- 이 두 키워드는 while, do-while, for와 같은 모든 반복문에서 사용할 수 있다.
```java
//    break
    while(조건식){
        if(특정 조건){
            코드1;            
            break;
        }
        코드2;
    }
    코드 3;
    /*
            조건식이 true인 경우 코드2 반복수행 
            특정 조건을 만족하면 코드1을 수행하고 
            반복문을 빠져나가 코드3 수행
     */
//    continue
    while(조건식){
        if(특정 조건){
            코드1;            
            continue;
        }
        코드2;
    }
    코드 3;
    /*
            조건식이 true인 경우 코드2 반복수행 
            특정 조건을 만족하면 코드1을 수행하고 
            반복문의 다음 순번으로 진행 
            조건식의 결과가 false인 경우 
            반복문을 빠져나가 코드3 수행
     */
```
[실습](../../src/chapter04_loop/Loop3.java)
## D. for
- 반복횟수가 정해져있는 경우 주로 사용
- 카운터변수 i의 선언부터 조건, 증감식 모두를 하나에서 관리할 수 있다. 
- 구조
```java
    for(초기식;조건식;증감식){
        //코드블럭
    }
```
- 수행 순서
```dockerfile
1. 초기식 실행: 반복횟수와 관련된 변수를 선언, 초기화.
2. 조건식 검증: 반복할때마다 조건을 체크, false면 반복문 종료
3. 코드블럭 진행
4. 코드블럭 종료 후 증감식 진행
```
- 초기식, 조건식, 증감식을 비운경우 while(true)처럼 무한 반복한다
```java
    for(;;){
        //코드 블럭
    }
```
- enhancedFor문: 주로 list(arrayList)를 사용
```java
    for(사용할 요소: 대상 집합){
        //코드블럭
    }
```
- 수행 순서
```dockerfile
1. list(arrayList)의 index 순으로 요소를 꺼냄
2. 코드블럭에서 해당 요소를 사용해 진행
3. list(arrayList)의 길이만큼 진행하고 종료
```
- 이외에도 forEach method도 있음
- 만약 반복 횟수를 반복문 외부에서도 사용할 경우 while문이 유용하난 그런경우는 거의 없다.
- 복잡한 조건을 가진 경우 while문이 더 유용할 수 있다. 

[실습](../../src/chapter04_loop/Loop4.java)
## E. 중첩반복문
- 반복문은 내부에 또 반복문을 사용해 중첩으로 사용할 수 있다. 
```java
for(int i=1;i<=9;i++){
        //i번 실행 코드블럭
        for(int j=0;j<=9;j++){
            //i*j번 실행 코드 블럭
        }
    }
```
- 수행방식
```dockerfile
    i-j: 
        1-1
        1-2
        1-3
            ...
        2-1
        2-2
        2-3
            ...
```
[실습](../../src/chapter04_loop/Loop5.java)
## F. 연습문제
```dockerfile
문제: 자연수 출력
처음 10개의 자연수를 출력하는 프로그램을 작성해 보세요. 이때, count 라는 변수를 사용해야 합니다.
while문, for문 2가지 버전의 정답을 만들어야 합니다
```
[실습](../../src/chapter04_loop/ex/Loop1Question.java)
```dockerfile
문제: 짝수 출력
반복문을 사용하여 처음 10개의 짝수를 출력하는 프로그램을 작성해 보세요. 이때, num 이라는 변수를 사용하여 수를
표현해야 합니다.
while문, for문 2가지 버전의 정답을 만들어야 합니
```
[실습](../../src/chapter04_loop/ex/Loop2Question.java)
```dockerfile
문제: 누적 합 계산
반복문을 사용하여 1부터 max 까지의 합을 계산하고 출력하는 프로그램을 작성해 보세요. 이때, sum 이라는 변수를 사
용하여 누적 합을 표현하고, i 라는 변수를 사용하여 카운트(1부터 max까지 증가하는 변수)를 수행해야 합니다.
while문, for문 2가지 버전의 정답을 만들어야 합니다.
```
[실습](../../src/chapter04_loop/ex/Loop3Question.java)
```dockerfile
문제4. 피라미드 출력
int rows 를 선언해라.
이 수만큼 다음과 같은 피라미드를 출력하면 된다.
        *
        **
        ***
        ****
        *****
        ******
        ...
```
[실습](../../src/chapter04_loop/ex/Loop4Question.java)
