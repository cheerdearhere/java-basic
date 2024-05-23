package step04_middleClass2.chapter02_CollectionFramework.set.hashAlgorithm;

import java.util.Arrays;

public class HashStart3 {
    private static final int ROW_CAPACITY = 10;
    private static final int COL_CAPACITY = 10;
    public static void main(String[] args) {
        Integer[][] intArr = new Integer[ROW_CAPACITY][COL_CAPACITY];
        add(intArr,1);
        add(intArr,2);
        add(intArr,5);
        add(intArr,7);
        add(intArr,13);
        add(intArr,56);
        add(intArr,78);
        add(intArr,99);
        add(intArr,19);
        add(intArr,29);
        add(intArr,29);
        System.out.println("result: "+ Arrays.deepToString(intArr));

        int searchValue = 99;
        System.out.println("search result: "+ intArr[getRowHashIdx(searchValue)][getColumnHashIdx(searchValue)]);

        //같은 index가 나오면?
        add(intArr,19);
        System.out.println("99??? "+Arrays.deepToString(intArr));
    }
    private static void add(Integer[][] arr, int value){
        arr[getRowHashIdx(value)][getColumnHashIdx(value)] = value;
    }
    private static int getColumnHashIdx(int value){
        int unitOfTen = value-getRowHashIdx(value);
        System.out.println(unitOfTen);
        return Math.floorDiv(unitOfTen,COL_CAPACITY);//(int) unitOfTen / COL_CAPACITY;
    }
    private static int getRowHashIdx(int value){
        return value % ROW_CAPACITY;
    }
}
