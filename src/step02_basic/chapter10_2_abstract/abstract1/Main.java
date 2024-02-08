package step02_basic.chapter10_2_abstract.abstract1;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal();// 추상 클래스의 인스턴스 생성 불가 > 내부 클래스는 가능
        AnimalInterface dog = new Dog();
        AnimalInterface cat = new Cat();
        Caw caw = new Caw();
        Duck duck = new Duck();

        Stream.of(new AnimalInterface[]{dog,cat,caw,duck}).forEach(Main::animalSoundCall);
    }
    private static void animalSoundCall(AnimalInterface animal){
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
