package step02_basic.chapter10_2_abstract.abstract2;

public class Dog implements AnimalInterface{
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
    @Override
    public void move() {
        System.out.println("강아지가 움직입니다.");
    }
}
