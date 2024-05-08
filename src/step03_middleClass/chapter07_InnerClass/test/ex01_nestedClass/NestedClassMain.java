package step03_middleClass.chapter07_InnerClass.test.ex01_nestedClass;

public class NestedClassMain {
    public static void main(String[] args) {
        System.out.println("##문제 1: 정적 중첩 클래스");
        StaticNestedClass.NestedClass inner = new StaticNestedClass.NestedClass();
        inner.hello();

        System.out.println("##문제 2: 내부 클래스");
        InnerClass outer = new InnerClass();
        InnerClass.Inner innerInstance = outer.new Inner();
        innerInstance.hello();

        System.out.println("##문제 3: 지역 클래스");
        LocalClass outer2 = new LocalClass();
        outer2.myMethod();
/*
문제4 - 익명 클래스를 완성해라
package nested.test;
public interface Hello {
 void hello();
}

package nested.test;
class AnonymousMain {
 public static void main(String[] args) {
 // 여기에서 Hello의 익명 클래스를 생성하고 hello()를 호출해라.
 }
}

실행 결과
Hello.hello
 */
        System.out.println("##문제 4: 익명 클래스");
        Hello anonymous = new Hello() {
            @Override
            public void hello() {
                System.out.println("Hello.hello");
            }
        };
        anonymous.hello();
/*
문제5 - 람다식 사용
익명 클래스의 내용을 람다식 적용

실행 결과
Hello.hello
 */
        System.out.println("##문제 5: 람다식");
        Hello lambda = ()->System.out.println("Hello.hello");
        lambda.hello();
    }
}
