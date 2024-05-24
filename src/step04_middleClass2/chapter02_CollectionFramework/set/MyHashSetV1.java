package step04_middleClass2.chapter02_CollectionFramework.set;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyHashSetV1 {
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1() {
        initBucket();
    }
    public MyHashSetV1(int initialCapacity) {
        this.capacity = initialCapacity;
        initBucket();
    }
    public boolean add(int value){
        int hashIndex = getHashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if(bucket.contains(value)) {
            System.out.println("has duplicated value: "+value);
            return false;
        }
        bucket.add(value);
        size++;
        return true;
    }
    public boolean contains(int searchValue) {
        int hashIndex = getHashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }
    public boolean remove(int value) {
        int hashIndex = getHashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if(!bucket.contains(value)) {
            System.out.println("no data: "+value);
            return false;
        }
        //기본형인 int가 전달되면 index 기준으로 삭제함
        bucket.remove(Integer.valueOf(value));
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
    private int getHashIndex(int value){
        return value % capacity;
    }

    @Override
    public String toString() {
        return "MyHashSetV1: " +
                IntStream.range(0,size)
                        .mapToObj(index -> "\n\t" + index + ". " + buckets[index].toString())
                        .collect(Collectors.joining())
//                Arrays.stream(buckets)
//                        .map(bucket->{
//                            int i=0;
//                            return (i++)+bucket.toString();
//                        })
//                        .collect(Collectors.joining("\n\t"))
                +"\nsize: " + size;
    }
}
