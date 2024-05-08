package step03_middleClass.chapter07_InnerClass.test.ex01_nestedClass;

public class LocalClass {
/*
문제3 - 지역 클래스를 완성해라
package nested.test;
class OuterClass3 {
 public void myMethod() {
 // 여기에 지역 클래스 LocalClass를 구현하고 hello() 메서드를 호출해라.
 }
}

package nested.test;
class OuterClass3Main {
 public static void main(String[] args) {
 OuterClass3 outerClass3 = new OuterClass3();
 outerClass3.myMethod();
 }
}

실행 결과
LocalClass.hello
 */
    public void myMethod(){
        final String message = "LocalClass.hello";
        class LocalInner{
            public void hello(){
                System.out.println(message);
            }
        }
        LocalInner localInstance = new LocalInner();
        localInstance.hello();
    }
}
