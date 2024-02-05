package step02_basic.chapter09_extends.extends6;

public class Child extends Parent{
    public String value = "child";
    @Override
    public void hello(){
        System.out.println("Child.hello");
    }
    public void call(){
        System.out.println("this.value = " + this.value);// this 생략 가능
        System.out.println("super.value = " + super.value);// parent 참조

        this.hello();
        super.hello();
    }
}
