package step02_basic.chapter09_extends.extends7;

public class ClassB extends ClassA{
    public ClassB(int a){
        super();//생략 가능
        System.out.println("ClassB 생성자 a="+a);
    }
    public ClassB(int a, int b){
        super();//생략 가능
        System.out.println("ClassB 생성자 a="+a+"/ b="+b);
    }
    public ClassB(String a){
        this(a.length(),20);
        System.out.println("ClassB 생성자 use this "+a);
    }
}
