package step02_basic.chapter10_2_abstract.abstract3;

public class Bird extends Animal implements Fly {

    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("새가 난다");
    }
}
