
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
- 내부에 위치하여 `private`에도 접근할수있음
- 그외에는 별개 클래스와 다를게 없음
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

            //외부클래스더라도 static은 가능
            System.out.println(outClassValue);
        }
    }
}
```
- 사용 예시
  - [원본](../../src/step03_middleClass/chapter07_InnerClass/ex_network) >refactoring> [정적 중첩 클래스 적용](../../src/step03_middleClass/chapter07_InnerClass/ex_nested)
```java
public class Network {
    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
    private static class NetworkMessage{
        private final String content;
        public NetworkMessage(String content){
            this.content = content;
        }
        private void print(){
            System.out.println("network message: "+content);
        }
    }
}
```
# III. 내부 클래스

# IV. 