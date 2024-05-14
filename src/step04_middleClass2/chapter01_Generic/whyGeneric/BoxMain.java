package step04_middleClass2.chapter01_Generic.whyGeneric;

public class BoxMain {
    public static void main(String[] args) {
        IntegerBox intBox = new IntegerBox();
        intBox.set(10);
        Integer integer = intBox.get();
        System.out.println("integer = " + integer);

        StringBox stringBox = new StringBox();
        stringBox.set("hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        ObjectBox objectBox = new ObjectBox();
        objectBox.set(10);
        Object object = objectBox.get();
        Integer integerObj = (Integer) object;// 캐스팅
        System.out.println("integerObj = " + integerObj);
        objectBox.set("no Integer");
        System.out.println("stringObj= " + (String)objectBox.get());//캐스팅

        ObjectBox integerBox2 = new ObjectBox();
        integerBox2.set("아차차");
        Integer integer2 = (Integer) integerBox2.get();
        System.out.println("integer2 = " + integer2);

        ObjectBox stringBox2 = new ObjectBox();
        stringBox2.set(123);
        boolean checked = ((String)stringBox2.get()).equals("aaa");
        System.out.println("is aaa? " + checked);
    }
}
