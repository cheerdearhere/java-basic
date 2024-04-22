[Java 강의](https://inf.run/2zsZz)
____
# I. 개요
- 복습용 자바 기초 강의
- 자바 복습 후 다른 과정 진행 예정

# II. 맛 보기
## A. Hallo Java - [예제 파일](../src/step01_beginner/HelloJava.java)
## B. 주석(comment) - [예제 파일](../src/step01_beginner/Comment.java)
### 1. 사용처
- 소스 코드가 복잡한경우 이해를 도울 때
- 특정 코드를 지우지 않고 잠시 실행을 막아두고 싶을때
### 2. 처리 
- 주석이 있는 곳을 무시한다. 
### 3. 주석의 종류
- 한 줄 주석(single line comment)
```java
    // 이 기호 이후의 모든 텍스트는 주석으로 처리된다. 
```
- 여러 줄 주석(multi line comment)
```java
    /* 시작 기호
        이 사이의 모든 코드는 주석으로 처리된다. 
     */ //끝 기호 다음은 모두 수행된다. 
```
# III. 자바란?
## A. 자바 표준 스팩
![자바표준스팩](img/beginner~basic/javaLanguageSpecification.jpg)

컴파일러, 실행 라이브러리, 가상 머신이라는 표준 스팩을 기반으로 여러 회사에서 자바를 생성한다. 
동작은 같으나 최적화나 작은 차이가 있다. 다만 각 회사들이 자신들의 프로그램에 최적화된 jdk를 사용하면 된다. 

[JDK에 대한 페이지](https://whichjdk.com/)

표준 스팩의 장점: 구현은 다른 버전을 사용해도 표준 스팩을 따르기 때문에 사용에 있어서는 문제가 되지 않는다. 

## B. 컴파일과 실행
![컴파일과실행](img/beginner~basic/comfileAndRuntime.jpeg)

- .java 소스 코드는 개발자가 작성.
- javac라는 프로그램을 사용해 .java를 .class파일로 변환하면서 바이트코드로 번역과 함께 문법 오류를 체크한다. 
```dockerfile
    # 원래는 cmd를 통해 명령해야하지만 IDE가 자동으로 처리
    javac step01_beginner.HelloJava.java
```
- 프로그램을 실행(Runtime)하면 자바 가상 머신(JVM)이 동작. 그 위에 소스코드가 동작
```dockerfile
    # 실행도 마찬가지. IDE가 처리
    java step01_beginner.HelloJava
```

## C. 자바의 운영체제 독립성
일반적인 프로그램은 운영체제 위에서 움직이기때문에 다른 운영체제 위에서는 작동하지 않는다.
자바의 경우 가상머신 위에서 작동하기때문에 java만 설치되어있다면 virtual machine 위에서 똑같이 동작한다. 

![자바와 OS](img/beginner~basic/java&OS.jpeg)

각 OS에 맞춰 JVM이 명령어가 세팅되어있으므로 운영체제에 얽매이지 않고 Java에만 맞춰 작성하면 됨.

# IV. 입문
[변수 노트](01beginner/01variable.md)로 이동

[연산자 노트](01beginner/02operater.md)로 이동

[조건문 노트](01beginner/03conditional.md)로 이동

[반복문 노트](01beginner/04loop.md)로 이동

[스코프와 형변환 노트](01beginner/05scope&casting.md)로 이동

[Scanner 적용 훈련 노트](01beginner/06scanner.md)

[배열 노트](01beginner/07Array.md)로 이동

[메서드 노트](01beginner/08Method.md)로 이동

# V. 기본
[클래스 노트](02basic/01class.md): C언어의 구조체. 클래스와 데이터만 이해하기

[변수 노트](02basic/02variable.md): 기본형과 참조형에 대한 이해. 특히 참조형

[객체지향 노트](02basic/03oop.md): 객체 지향에 대한 이해. 클래스, 변수 하나로 이해하기

[생성자 노트](02basic/04constructor.md)

[패키지 노트](02basic/05package.md)

[접근제어자 노트](02basic/06modifier.md): 캡슐화의 기본

[메모리 관리와 static 노트](02basic/07virtualMachine.md): 자바 가상 머신의 기초

[final 노트](02basic/08final.md)

[상속 노트](02basic/09extends.md)

[다형성 노트 1: 다형성](02basic/10-1polymorphism.md): 객체지향의 꽃이자 자바 언어의 장점

[다형성 노트 2: 추상클래스와 인터페이스](02basic/10-2Abstract.md): 제약을 통한 안정성, 유지보수 준비

[다형성 노트 3: 다형성과 설계](02basic/10-3polymorphism&architecture.md)

# VI. 중급 - 1
- java의 기본 라이브러리 중 기본으로 알아야하는 지식을 체크하는 시간
  - java.lang package: 자바 언어를 이루는 가장 기본 클래스들 집합
  - 대표 클래스
    - Object: 모든 자바 객체의 부모 클래스
    - String: 문자열
    - (Wrapper): literal(기본형 데이터 타입)을 객체로 만든 것
      - Integer
      - Long
      - Double ...
    - Class: 클래스 메타 정보
    - System: 시스템과 관련된 기본 기능들을 제공
- import를 해야하는 외부 라이브러리와 달리 java.lang은 필수/기본 라이브러리이기 때문에 import가 필요없다.
  - `import java.lang.*` 생략

[Object 클래스](03middle-1/01ObjectClass.md)

[불변 객체](03middle-1/02Immuatable.md)

[String 클래스](03middle-1/03StringClass.md)

[Wrapper, Class 클래스](03middle-1/04WrapperAndClass_type.md)

[열거형-Enum](03middle-1/05Enum.md)

[Date/Time]

[중첩클래스/내부클래스]

[Exception]
