package step03_middleClass.chapter07_InnerClass.test.ex01_nestedClass;

public class InnerClass {
/*
문제2 - 내부 클래스를 완성해라
package nested.test;
public class OuterClass2 {
 // 여기에 InnerClass를 구현해라. 그리고 hello() 메서드를 만들어라.
}

package nested.test;
public class OuterClass2Main {
 public static void main(String[] args) {
 // 여기에서 InnerClass의 hello() 메서드를 호출해라.
 }
}

실행 결과
InnerClass.hello
 */
    class Inner{
        public void hello(){
            System.out.println("InnerClass.hello");
        }
    }
}
