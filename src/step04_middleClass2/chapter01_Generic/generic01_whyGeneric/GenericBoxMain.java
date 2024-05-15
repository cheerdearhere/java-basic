package step04_middleClass2.chapter01_Generic.generic01_whyGeneric;

public class GenericBoxMain {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.set(100);
        System.out.println(integerBox.get());
//        integerBox.set("string type value");

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get());
//        stringBox.set(111);
    }
}

