package step04_middleClass2.chapter01_Generic.generic05_wildcard;

import step04_middleClass2.chapter01_Generic.animal.Animal;
import step04_middleClass2.chapter01_Generic.animal.Dog;

public class Wildcard {
    //up to Object
    static <T> void printGeneric(Box<T> box){
        System.out.println("generic obj = "+box.get());
    }
    // use wildcard
    static void printWildcard(Box<?> obj){
        System.out.println("wildcard obj = "+obj.get());
    }

    //up to Animal
    static <T extends Animal> void printUptoAnimal(Box<T> box){
        T t = box.get();
        System.out.println("Animal print");
        System.out.println("\t이름 = "+t.getName());
        System.out.println("\t크기 = "+t.getSize());
    }
    // use wildcard
    static void printAnimalWildcard(Box<? extends Animal> box){
        Animal animal = box.get();// 상한 클래스로 꺼내짐
        System.out.println("Animal print with wildcard(?)");
        System.out.println("\t이름 = "+animal.getName());
        System.out.println("\t크기 = "+animal.getSize());
    }

    //up to Animal(print and return)
    static <T extends Animal> T printAndReturnGeneric(Box<T> box){
        T t = box.get();
        System.out.println("Animal print, return");
        System.out.println("\t이름 = "+t.getName());
        return t;
    }
    // use wildcard
    static Animal printAndReturnWildcard(Box<? extends Animal> box){
        Animal animal = box.get();
        System.out.println("Animal print, return with wildcard(?)");
        System.out.println("\t이름 = "+animal.getName());
        return animal;
    }

    //하한 와일드카드
    static void writeBox(Box<? super Animal> box){
        box.set(new Dog("하한",200));
    }

}
