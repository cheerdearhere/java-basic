package step02_basic.chapter09_extends.extends5.child;

import step02_basic.chapter09_extends.extends5.parent.Parent;

public class Child extends Parent {
    public void call(){
        System.out.println("====print in Child====");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue); //다른 패키지지만 상속관계라 사용가능
//        System.out.println("defaultValue = " + defaultValue); 다른 패키지
//        System.out.println("privateValue = " + privateValue); 다른 클래스

        publicMethod();
        protectedMethod(); //다른 패키지지만 상속관계라 사용가능
//        defaultMethod(); 다른 패키지
//        privateMethod(); 다른 클래스
        
        printParent();//parent 클래스 내부 호출
    }
}
