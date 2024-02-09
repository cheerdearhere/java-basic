package step02_basic.chapter10_3_architecture.car1.car;

public class NewCar implements Car{

    @Override
    public void startEngine() {
        System.out.println("NewCar.startEngine");
    }
    @Override
    public void offEngine() {
        System.out.println("NewCar.offEngine");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("NewCar.pressAccelerator");
    }
    @Override
    public void pressBrake() {
        System.out.println("NewCar.pressBrake");
    }
}
