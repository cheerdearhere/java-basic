package step02_basic.chapter10_polymorphism.polymorphism4;

public class Child extends Parent {
    public String value = "child";
    @Override
    public void method(){
        System.out.println("Child.method");
    }
}
