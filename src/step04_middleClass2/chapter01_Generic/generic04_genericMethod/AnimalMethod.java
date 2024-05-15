package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

import step04_middleClass2.chapter01_Generic.animal.Animal;

public class AnimalMethod {
    public static <T extends Animal> void checkup(T animal){
        System.out.println("동물 이름: "+animal.getName());
        System.out.println("크기: "+animal.getSize());
        animal.sound();
    }
    public static <T extends Animal> T bigger(T basicAnimal, T targetAnimal){
        return basicAnimal.getSize() > targetAnimal.getSize() ? basicAnimal : targetAnimal;
    }
}
