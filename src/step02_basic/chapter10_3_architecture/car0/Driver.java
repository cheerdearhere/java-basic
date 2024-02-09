package step02_basic.chapter10_3_architecture.car0;

public class Driver {
    private K3Car k3Car;
    public void setK3Car(K3Car k3Car) {
        this.k3Car = k3Car;
    }

//  Model3Car가 추가되면서 추가
    private Model3Car model3Car;
    public void setModel3Car(Model3Car model3Car) {
        this.model3Car = model3Car;
    }

    public void drive(){
        System.out.println("자동차 운전 시작");
        if(k3Car!=null){
            k3Car.startEngine();
            k3Car.pressAccelerator();
            k3Car.pressBrake();
            k3Car.offEngine();
        }else if(model3Car!=null){
            model3Car.startEngine();
            model3Car.pressAccelerator();
            model3Car.pressBrake();
            model3Car.offEngine();
        }
        System.out.println("자동차 운전 종료");
    }
}
