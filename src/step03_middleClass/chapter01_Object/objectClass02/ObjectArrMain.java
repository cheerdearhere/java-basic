package step03_middleClass.chapter01_Object.objectClass02;

import step03_middleClass.chapter01_Object.objectClass01.poly.Car;
import step03_middleClass.chapter01_Object.objectClass01.poly.Cat;

public class ObjectArrMain {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Car car = new Car();
        Object obj = new Object();

        Object[] objects = {car, cat, obj};
        size(objects);

    }

    private static void size(Object[] objects) {
        System.out.println("전달된 객체 수: "+objects.length);
    }
}
