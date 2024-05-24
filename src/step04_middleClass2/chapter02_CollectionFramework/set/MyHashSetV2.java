package step04_middleClass2.chapter02_CollectionFramework.set;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyHashSetV2 {
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Object>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV2() {
        initBucket();
    }
    public MyHashSetV2(int initialCapacity) {
        this.capacity = initialCapacity;
        initBucket();
    }
    public boolean add(Object value){
        int hashIndex = getHashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if(bucket.contains(value)) {
            System.out.println("has duplicated value: "+value);
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }
    public boolean contains(Object searchValue) {
        int hashIndex = getHashIndex(searchValue);
        LinkedList<Object> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }
    public boolean remove(Object value) {
        int hashIndex = getHashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if(!bucket.contains(value)) {
            System.out.println("no data: "+value);
            return false;
        }
        //기본형인 int가 전달되면 index 기준으로 삭제함
        bucket.remove(value);
        return true;
    }
    public int getSize() {
        return size;
    }

    private void initBucket() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    private int getHashIndex(Object value){
        return Math.abs(value.hashCode()) % capacity;
    }

    @Override
    public String toString() {
        return "MyHashSetV2: " +
                IntStream.range(0, buckets.length)
                        .mapToObj(index ->"\n\t" + index + ". " + buckets[index].toString())
                        .collect(Collectors.joining("")) +
                "\nsize: " + size;
    }

}
