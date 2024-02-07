package step02_basic.chapter10_polymorphism.polymorphism2;

public class PolymorphismMain {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child)parent1;
        child1.childMethod();// 문제 없음

//        Parent parent2 = new Parent();
//        Child child2 = (Child)parent2;
//        child2.childMethod();// ClassCastException

        //업캐스팅은 문제 없음
        Grandson grandson = new Grandson();
        Parent parent3 = grandson;
        Child child3 = grandson;
    }
}
