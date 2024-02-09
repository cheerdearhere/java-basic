package step02_basic.chapter10_3_architecture.car1.car;

public class K3Car implements Car{
    @Override
    public void startEngine(){
        System.out.println("K3Car.startEngine");
    }
    @Override
    public void offEngine(){
        System.out.println("K3Car.offEngine");
    }
    @Override
    public void pressAccelerator(){
        System.out.println("K3Car.pressAccelerator");
    }
    @Override
    public void pressBrake(){
        System.out.println("K3Car.pressBrake");
    }
}
