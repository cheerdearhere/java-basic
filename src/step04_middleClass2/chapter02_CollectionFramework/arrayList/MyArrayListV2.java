package step04_middleClass2.chapter02_CollectionFramework.arrayList;

import java.util.Arrays;

public class MyArrayListV2 {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int size;
    //default constructor
    public MyArrayListV2() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //required arguments constructor
    public MyArrayListV2(int capacity) {
        elements = new Object[capacity];
    }
    //public methods
    public int size(){
        return size;
    }
    public void add(Object obj){
        if(size == elements.length) grow();
        elements[size] = obj;
        size++;
    }
    public void add(int index, Object obj){
        if(size == elements.length) grow();
        shiftRightFrom(index);
        elements[index] = obj;
        size++;
    }
    public Object remove(int index){
        Object oldValue = elements[index];
        //이동하면 해당 위치 데이터는 자동으로 덮어씌워짐
        shiftLeftFrom(index);
        size--;
        return oldValue;
    }
    public Object get(int index){
        return elements[index];
    }
    public Object set(int index, Object obj){
        Object oldValue = get(index);
        elements[index] = obj;
        return oldValue;
    }
    public int indexOf(Object obj){
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
        System.out.println("size up: "+oldCapacity+" -> "+newCapacity);
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
