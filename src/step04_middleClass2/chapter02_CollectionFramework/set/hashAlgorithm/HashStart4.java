package step04_middleClass2.chapter02_CollectionFramework.set.hashAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//HashStart3와 같으나 LinkedList[]사용
public class HashStart4 {
    private static final int CAPACITY = 10;
    public static void main(String[] args) {
        List<Integer>[] buckets = new LinkedList[CAPACITY];
        System.out.println("buckets: " + Arrays.toString(buckets));
        for(int i = 0; i < CAPACITY; i++){
            buckets[i] = new LinkedList<>();
        }
        System.out.println("buckets: " + Arrays.toString(buckets));

        add(buckets,1);
        add(buckets,2);
        add(buckets,5);
        add(buckets,7);
        add(buckets,13);
        add(buckets,56);
        add(buckets,22);
        add(buckets,78);
        add(buckets,99);
        add(buckets,19);
        add(buckets,29);
        add(buckets,29);
        System.out.println("buckets: " + Arrays.toString(buckets));

        int searchValue = 29;
        System.out.println("search result: "+contains(buckets,searchValue));
    }
    private static boolean contains(List<Integer>[] buckets, int value){
        int hashIdx = getHashIdx(value);
        List<Integer> bucket = buckets[hashIdx];
        return bucket.contains(value);
    }
    private static void add(List<Integer>[] buckets, int value) {
        int hashIdx = getHashIdx(value);
        List<Integer> bucket = buckets[hashIdx];
        if(!bucket.contains(value)){
            bucket.add(value);
        }else{
            System.out.println("duplicated value: " + value);
        }
    }
    private static int getHashIdx(int value){
        return value % CAPACITY;
    }
}
