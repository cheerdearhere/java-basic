package step04_middleClass2.chapter01_Generic.animal;

public class Cat extends Animal{
    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
