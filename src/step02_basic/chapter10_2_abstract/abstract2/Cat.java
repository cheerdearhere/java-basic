package step02_basic.chapter10_2_abstract.abstract2;

public class Cat implements AnimalInterface {
    @Override
    public void sound(){
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이가 움직입니다.");
    }
}
