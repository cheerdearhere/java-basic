package step02_basic.chapter09_extends.extends4;

public class ElectricCar extends Car {
//    move()는 물려받음
    public void charge(){
        System.out.println("충전합니다.");
    }

    @Override
    public void move() {
        System.out.println("전기차가 자율 주행합니다.");
    }
}
