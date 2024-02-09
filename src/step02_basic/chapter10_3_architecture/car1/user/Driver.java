package step02_basic.chapter10_3_architecture.car1.user;

import step02_basic.chapter10_3_architecture.car1.car.Car;

public class Driver {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void drive(){
        System.out.println("자동차 운전 시작");
        car.startEngine();
        car.pressAccelerator();
        car.pressBrake();
        car.offEngine();
        System.out.println("자동차 운전 종료");
    }
}
