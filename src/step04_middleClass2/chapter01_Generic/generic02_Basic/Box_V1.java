package step04_middleClass2.chapter01_Generic.generic02_Basic;

public class Box_V1<T> {
    private T value;
    public void set(T value) {
        this.value = value;
    }
    public T get() {
        return value;
    }
}
