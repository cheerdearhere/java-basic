package step03_middleClass.chapter01_Object.objectClass01;

import step03_middleClass.chapter01_Object.objectClass01.poly.Car;
import step03_middleClass.chapter01_Object.objectClass01.poly.Cat;

public class ObjectMain {
    public static void main(String[] args){
        Child child = new Child();
        child.childMethod();

        String string = child.toString();// method in Object class
        System.out.println(string);//class name, reference(memory address)

        Car car = new Car();
        Cat cat = new Cat();

        action(car);
        action(cat);

    }
    private static void action(Object obj){
//        obj.move(); // super class에는 sub의 method가 없다.
//        obj.sound();// 컴파일 에러 발생
        // 객체에 따른 down casting
        if(obj instanceof Cat) ((Cat) obj).sound();
        else if(obj instanceof Car) ((Car) obj).move();
    }
}
