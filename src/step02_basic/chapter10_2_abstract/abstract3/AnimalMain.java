package step02_basic.chapter10_2_abstract.abstract3;


public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Chicken chicken = new Chicken();
        soundAnimal(dog);
        soundAnimal(bird);
        soundAnimal(chicken);

//        flyAnimal(dog); dog은 Fly를 구현하지 않음
        flyAnimal(bird);
        flyAnimal(chicken);
    }
//    Animal 사용 가능
    private static void soundAnimal(Animal animal){
        System.out.println("## 동물 울음 소리 시작 ##");
        animal.sound();
        System.out.println("## 동물 울음 소리 종료 ##");
    }
//    Fly 사용 가능
    private static void flyAnimal(Fly flyAnimal){
        System.out.println(">> 날개 테스트 시작 <<");
        flyAnimal.fly();
        System.out.println(">> 날개 테스트 종료 <<");
    }
}
