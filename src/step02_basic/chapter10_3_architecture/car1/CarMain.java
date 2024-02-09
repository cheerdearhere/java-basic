package step02_basic.chapter10_3_architecture.car1;

import step02_basic.chapter10_3_architecture.car1.car.K3Car;
import step02_basic.chapter10_3_architecture.car1.car.Model3Car;
import step02_basic.chapter10_3_architecture.car1.car.NewCar;
import step02_basic.chapter10_3_architecture.car1.user.Driver;

public class CarMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();
    }
}
