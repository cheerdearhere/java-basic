package step02_basic.chapter10_polymorphism.polymorphism3;

import java.util.Arrays;

public class PolymorphismMain {
    public static void main(String[] args) {
        // 같은 Parent 타입일때
        Parent parent1 = new Parent();
        Parent parent2 = new Child();
        Parent parent3 = new Grandson();
        Parent[] parents = {parent1,parent2,parent3};
        //어디를 참조하는지 확인해서 사용하면 안전하다.
        Arrays.stream(parents).forEach(PolymorphismMain::call);

        //instanceof
        System.out.println(new Parent() instanceof Child);//false
        System.out.println(new Child() instanceof Child);//true
        System.out.println(new Grandson() instanceof Child);//true

        //java16부터는 instanceof를 사용하면서 동시에 변수를 선언할 수 있다.
        java16Call(parent2);
    }
    private static void call(Parent parent){
        System.out.println("parent = " + parent);
        if(parent instanceof Grandson) {
            ((Grandson) parent).grandsonMethod();
        }
        if(parent instanceof Child) {
            ((Child) parent).childMethod();
        }
        if(parent instanceof Parent){
            parent.parentMethod();
        }
    }
    private static void java16Call(Parent parent){
        System.out.println("parent = " + parent);
        if(parent instanceof Grandson grandsonVariable) {
            grandsonVariable.grandsonMethod();
        }
        if(parent instanceof Child childVariable) {
            childVariable.childMethod();
        }
        if(parent instanceof Parent parentLocalVariable){
            parentLocalVariable.parentMethod();
        }
    }
}
