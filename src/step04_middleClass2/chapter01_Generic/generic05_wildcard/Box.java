package step04_middleClass2.chapter01_Generic.generic05_wildcard;

public class Box <T> {
    private T value;
    public void set(T value){
        this.value = value;
    }
    public T get(){
        return value;
    }
}
