package step02_basic.chapter10_2_abstract.abstract3;

public class Chicken extends Animal implements Fly {
    @Override
    public void sound() {
        System.out.println("꼬끼오");
    }

    @Override
    public void fly() {
        System.out.println("닭이 뛴다");
    }
}
