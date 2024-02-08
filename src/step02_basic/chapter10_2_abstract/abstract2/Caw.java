package step02_basic.chapter10_2_abstract.abstract2;


public class Caw implements AnimalInterface {
    @Override
    public void sound(){
        System.out.println("음머");
    }

    @Override
    public void move() {
        System.out.println("소가 움직입니다.");
    }
}
