package step02_basic.chapter10_polymorphism.ex.polimorph1Question;

import step02_basic.chapter10_polymorphism.ex.polimorph1Question.Animal.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class AnimalSoundMain {
    /*
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 종료");
        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 종료");
        System.out.println("동물 소리 테스트 시작");
        caw.sound();
        System.out.println("동물 소리 테스트 종료");
     */
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Dog(),new Cat(),new Caw()/*추가*/,new Duck()};
        for(Animal animal : animals) {
            animalSoundCall(animal);
        }

        System.out.println("###Stream interface 사용");
        Stream.of(animals).forEach(AnimalSoundMain::animalSoundCall);
    }

    private static void animalSoundCall(Animal animal){
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
