
불변객체
---

- 자바에서 제공하는 클래스들이 불변 객체로 이뤄져있음.

[실습 코드 모음](../../src/step03_middleClass/chatper02_Immutable)

# I. 기본형과 참조형의 공유
- Primitive Type vs Reference Type
  - 기본형: 하나의 값을 여러 변수에서 공유하지 않는다. 
    - 복사된 기본형 변수를 수정해도 원본 기본형 변수에 영향을 주지 않는다.
  - 참조형: 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다. 
    - 얕은 복사된 참조형 변수를 수정하면 원본 참조형 변수와 공유하므로 변경점을 공유한다. 
- 기본형 
```java
public static void main(String[] args) {
    int a = 10;
    int b = a;
    b++;
    System.out.println("a = " + a);//10
    System.out.println("b = " + b);//11
}
```
- 참조형
    - 얕은 복사는 참조값(인스턴스 위치)만 복사(공유)하므로 원본에 영향을 미친다.
```java
    public static void main(String[] args) {
        ReferenceObject a = new ReferenceObject(10);
        ReferenceObject b = a;
        b.setA(10+1);
        System.out.println("a, b: " + a + ", "+b);
    }
```

# II. Side Effect
- 어떤 계산이 주된 작업외에 추가적인 부수효과를 일으키는 것.
  - 의도한 것이라면 다행이지만 대다수 의도하지 않은 부작용인 경우가 대다수
  - 참조 변수의 얕은 복사에서 값 변형이 일어나 의도하지 않은 결과를 발생시킬 수 있음
  - 다른 개발자와 협업할때 혼선을 줄 수 있어 안주는 것이 좋음
- 깊은 복사를 진행(새로운 참조 주소 생성)하면 값이 변경되지 않는다.
## A. 사이드 이팩트 해결 방안
- 방법1: 인스턴스의 클래스에서 깊은 복사용 메서드 제작
```java
    private int a;
//...
    public ReferenceObject deepCopy() {
        return new ReferenceObject(this.a);
    }
//...
```
- 방법2: 인스턴스 내부의 값을 같게할뿐 새롭게 객체를 생성
```java
ReferenceObject a = new ReferenceObject(10);
ReferenceObject b = new ReferenceObject(10);
```
- 사실... 둘다 같은 방법. 어디서 처리하느냐의 문제
- 물론 인스턴스를 복사해서 사용하는 경우는 거의 없다.
## B. 그럼에도... 막을 방법이 없다.
- 여러 변수가 하나의 객체를 공유하는 것을 막을 방법이 없다. 
- java 문법상 문제가 없기때문.. 
- 짧은 연습용 코드라면 몰라도 복잡한 소스코드에서는 문제가 크다.
## C. 불변객체를 도입하기