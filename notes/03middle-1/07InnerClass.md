
[실습코드](../../src/step03_middleClass/chapter07_InnerClass)

# I. 중첩클래스? 
- 클래스 내부에 다른 클래스가 정의된 상태로 정의하는 위치에 따라 분류할 수 있다
![중첩클래스 분류](../img/middle/NestedClass.png)
  - 정적 중첩 클래스(static nested class): static이 붙은 클래스
  - 내부 클래스
    - 내부 클래스(inner class)
    - 지역 클래스(local class): 지역 변수에 접근하는 내부 클래스
    - 익명 클래스(anonymous class): 지역 클래스의 name을 사용하지 않음 > 단발성으로 사용
```java
class Outer {
    //static nested class
    static class StaticNested {

    }

    //inner class(like instance variable)
    class Inner {

    }

    //스코프 내부에서 선언한 클래스
    public void process() {
       int localVariable=  0;
        //local class
        class Local {
            public void localMethod(){
                System.out.printf(localVariable);
            };
        }
        //instance of Inner class
        Local local = new Local();
        local.localMethod();
    }
}
```
- 구분 비교 
  - 정적 중첩 클래스는 결국 현재 클래스와 별개인 외부 클래스로 인스턴스에 소속되지 않는다
  - 내부 클래스는 현재 클래스의 인스턴스에 속한다.
  - 실무에서는 중첩과 내부를 따로 구분하지 않고 사용하므로 상황과 문맥에 맞게 사용
- Outer class와 Inner class 사이에서만 긴밀한 연결이 있을때만 사용. 외부에서 접근할 이유가 있는 경우 내부 클래스에 부적합하다
- 사용하는 이유: 보안성을 강화시키기 위한 것으로 캡슐화를 깨뜨리는 경우 외부에 선언하는 것이 맞다. 
  - 논리적 그룹화
  - 캡슐화
# II. 정적 중첩 클래스(static class)
- 정적 중첩 클래스는 new 생성자로 인스턴스를 생성한다. 
- 외부클래스.중첩클래스로 정적 메서드에 접근
- 외부클래스의 인스턴스(`new Outer()`)와 내부클래스(`new Outer.Nested()`)는 별개의 인스턴스이므로 전혀 관련이 없다 
```java
public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested{
        private int nestedInstanceValue = 1;
        public void print(){
            //자신의 멤버
            //내부 클래스도 본인 클래스 내부이기때문에 private으로 선언해도 사용 가능
            System.out.println(nestedInstanceValue);

            //외부 클래스의 멤버(outer instance 접근 불가
//            System.out.printf(outInstanceValue);

            // static은 가능
            System.out.println(NestedOuter.outClassValue);
        }
    }
}
```
- main 호출
```java
public static void main(String[] args) {
    NestedOuter outer = new NestedOuter();
    NestedOuter.Nested nested = new NestedOuter.Nested();
    nested.print();

    System.out.println("Nested Class: "+nested.getClass());
}
``` 
- class 표시는 $로 구분
```
1
3
Nested Class: class step03_middleClass.chapter07_InnerClass.NestedOuter$Nested
```
- 그저 내부에 있을뿐 외부 다른 클래스와 차이가 없음
  - private 접근가능하다는 점