package step04_middleClass2.chapter02_CollectionFramework.arrayList;

import java.util.Arrays;

public class MyArrayListV0 {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int size;
    //default constructor
    public MyArrayListV0() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //required arguments constructor
    public MyArrayListV0(int capacity) {
        elements = new Object[capacity];
    }
    //methods
    public int size(){
        return size;
    }
    public void add(Object obj){
        try {
            elements[size] = obj;
            size++;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getClass()+": "+e.getMessage()+" - "+obj);
        }
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
//        return Arrays.stream(elements)
//                .filter(Objects::nonNull)
//                .map(Object::toString)
//                .collect(Collectors.joining(", ","[","]"))+"/ size: "+size+"/ capacity: "+elements.length;
        return Arrays.toString(Arrays.copyOf(elements, size))+"/ size: "+size+"/ capacity: "+elements.length;
    }
}
