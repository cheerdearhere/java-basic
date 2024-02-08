package step02_basic.chapter10_2_abstract.abstract2;


import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        AnimalInterface animal = new AnimalInterface();// 인터페이스의 인스턴스 생성 불가 > 내부 클래스는 가능
        AnimalInterface dog = new Dog();
        AnimalInterface cat = new Cat();
        Caw caw = new Caw();

        Stream.of(new AnimalInterface[]{dog,cat,caw}).forEach(AnimalInterface::soundTest);
    }
}
