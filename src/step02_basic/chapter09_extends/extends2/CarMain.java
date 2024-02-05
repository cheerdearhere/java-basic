package step02_basic.chapter09_extends.extends2;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.charge();//특이 기능 > sub
        electricCar.move();//공통 기능 > super

        GasCar gasCar = new GasCar();
        gasCar.fillUp();
        gasCar.move();
    }
}
