package step04_middleClass2.chapter02_CollectionFramework.set.hashAlgorithm;

import java.util.Arrays;

public class HashStart2 {
    private static final int CAPACITY = 10;
    public static void main(String[] args) {
        Integer[] intArr = new Integer[CAPACITY];
        add(intArr,1);
        add(intArr,2);
        add(intArr,5);
        add(intArr,7);
        add(intArr,13);
        add(intArr,56);
        add(intArr,78);
        add(intArr,99);

        System.out.println("result: "+ Arrays.toString(intArr));

        int searchValue = 99;
        System.out.println("search result: "+ intArr[getHashIdx(searchValue)]);

        //같은 index가 나오면?
        add(intArr,19);
        System.out.println("99??? "+Arrays.toString(intArr));
    }
    private static void add(Integer[] arr, int value){
        arr[getHashIdx(value)] = value;
    }
    private static int getHashIdx(int value){
        return value % CAPACITY;
    }
}
