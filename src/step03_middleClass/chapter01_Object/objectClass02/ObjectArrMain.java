package step03_middleClass.chapter01_Object.objectClass02;

public class ObjectArrMain {
    public static void main(String[] args) {
        Cat cat = new Cat("navi",2);
        Car car = new Car("dark",3);
        Object obj = new Object();

        Object[] objects = {car, cat, obj};
        size(objects);

        System.out.println(obj);
        System.out.println(obj.toString());

        System.out.println(cat);
        System.out.println(car);

        ObjectPrint.print(car);
        ObjectPrint.print(cat);
        ObjectPrint.print(obj);

        ObjectPrint.printRefAddr(cat);
    }

    private static void size(Object[] objects) {
        System.out.println("전달된 객체 수: "+objects.length);
    }
}
