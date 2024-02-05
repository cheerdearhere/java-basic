package step02_basic.chapter09_extends.extends7;

public class ClassC extends ClassB{
//부모 클래스에 매개변수를 요구하는 생성자만 있는 경우 super 생략 불가
    public ClassC(){
        super(10, 20);
        System.out.println("ClassC 생성자");
    }
    public ClassC(int a){
        super(a);
        System.out.println("ClassC 생성자 a 전달");
    }
    public ClassC(int a, int b){
        super(a, b);
        System.out.println("ClassC 생성자 a와 b 전달");
    }
}
