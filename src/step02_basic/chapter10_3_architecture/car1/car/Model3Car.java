package step02_basic.chapter10_3_architecture.car1.car;

public class Model3Car implements Car {
    @Override
    public void startEngine(){
        System.out.println("Model3Car.startEngine");
    }
    @Override
    public void offEngine(){
        System.out.println("Model3Car.offEngine");
    }
    @Override
    public void pressAccelerator(){
        System.out.println("Model3Car.pressAccelerator");
    }
    @Override
    public void pressBrake(){
        System.out.println("Model3Car.pressBrake");
    }
}
