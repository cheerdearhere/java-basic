package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

import step04_middleClass2.chapter01_Generic.animal.Animal;
import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;

public class ComplexBox <T extends Animal>{
    private T animal;
    public void set(T animal){
        this.animal = animal;
    }
    public <T> T printAndReturn(T t) {
        System.out.println("animal.className = " + animal.getClass().getName());
        System.out.println("u.className = " + t.getClass().getName());
        return t;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("멍개",100);
        Cat cat = new Cat("냐옹", 50);

        ComplexBox<Dog> box = new ComplexBox<>();
        box.set(dog);// Generic type T set
        // Dog
        Cat returnCat = box.printAndReturn(cat);// Generic method T set
        // Cat
    }
}
