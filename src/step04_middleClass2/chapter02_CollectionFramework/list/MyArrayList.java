package step04_middleClass2.chapter02_CollectionFramework.list;


import java.util.Arrays;

public class MyArrayList<E> implements MyList<E>{
    //members
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;
    //default constructor
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //required arguments constructor
    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }
    //public methods
    public int size(){
        return size;
    }
    public void add(E obj){
        if(size == elements.length) grow();
        elements[size] = obj;
        size++;
    }
    public void add(int index, E obj){
        if(size == elements.length) grow();
        shiftRightFrom(index);
        elements[index] = obj;
        size++;
    }
    @SuppressWarnings("unchecked")
    public E remove(int index){
        E oldValue = (E)elements[index];
        //이동하면 해당 위치 데이터는 자동으로 덮어씌워짐
        shiftLeftFrom(index);
        size--;
        return oldValue;
    }
    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E)elements[index];
    }

    public E set(int index, Object obj){
        E oldValue = get(index);
        elements[index] = obj;
        return oldValue;
    }
    public int indexOf(E obj){
        for(int i = 0; i < size; i++){
            if(obj.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(elements, size))+"/ size: "+size+"/ capacity: "+elements.length;
    }
    //private methods
    private void grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;

        elements = Arrays.copyOf(elements, newCapacity);
    }
    private void shiftRightFrom(int index) {
        for(int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }
    }
    private void shiftLeftFrom(int index) {
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
    }
}
