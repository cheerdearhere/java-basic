package step04_middleClass2.chapter01_Generic.test.ex01_basic;

public class Container<T> {
    private T item;

    public boolean isEmpty(){
        return item==null || item.equals("");
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem(){
        return item;
    }
}
