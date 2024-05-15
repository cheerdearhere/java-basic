package step04_middleClass2.chapter01_Generic.generic02_Basic;

import step04_middleClass2.chapter01_Generic.animal.Animal;
import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;

public class AnimalMain_V1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물",0);
        Dog dog = new Dog("개",100);
        Cat cat = new Cat("고양",70);

        Box_V1<Dog> dogBox = new Box_V1<>();
        dogBox.set(dog);
//        dogBox.set(cat);
        Dog findDog = dogBox.get();
        System.out.println("findDog = " + findDog);

        Box_V1<Cat> catBox = new Box_V1<>();
        catBox.set(cat);
        Cat findCat = catBox.get();
        System.out.println("findCat = " + findCat);

        Box_V1<Animal> animalBox = new Box_V1<>();
        animalBox.set(animal);
        System.out.println("animalBox = " + animalBox.get());
        animalBox.set(dog);
        System.out.println("animalBox = " + animalBox.get());
        animalBox.set(cat);
        System.out.println("animalBox = " + animalBox.get());
    }
}
