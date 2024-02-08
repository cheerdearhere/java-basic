package step02_basic.chapter10_1_polymorphism.polymorphism4;

public class PolymorphismMain {
    public static void main(String[] args) {
        System.out.println("C -> C");
        Child child = new Child();
        System.out.println("child.value = " + child.value);
        child.method();

        System.out.println("C -> P");
        ((Parent)child).method();

        System.out.println("P -> P");
        Parent parent = new Parent();
        System.out.println("parent.value = " + parent.value);
        parent.method();

        System.out.println("P -> C");
        Parent poly = new Child();
        System.out.println("poly.value = " + poly.value);
        poly.method();
    }
}
