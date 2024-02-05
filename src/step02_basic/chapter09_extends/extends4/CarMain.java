package step02_basic.chapter09_extends.extends4;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.charge();
        electricCar.move();
        electricCar.openDoor();//공통 기능 추가

        GasCar gasCar = new GasCar();
        gasCar.fillUp();
        gasCar.move();
        gasCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar(); // 새로운 클래스 확장
        hydrogenCar.fillHydrogen();
        hydrogenCar.move();
        hydrogenCar.openDoor();
    }
}
