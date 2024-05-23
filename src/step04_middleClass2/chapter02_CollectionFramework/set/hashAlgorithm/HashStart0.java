package step04_middleClass2.chapter02_CollectionFramework.set.hashAlgorithm;

import java.util.Arrays;

public class HashStart0 {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[4];
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 5;
        intArr[3] = 8;
        System.out.println("inputArr: "+ Arrays.toString(intArr));
        int searchValue = 8;
        // loop를 사용한 반복 사용
        for(int intValue: intArr){
            if(intValue == searchValue){
                System.out.println(intValue);
            }
        }
        // 데이터와 index를 일치시키면 검색에 index를 사용할 수 있지 않나?
        Integer[] intArr2 = new Integer[10];
        intArr2[1] = 1;
        intArr2[2] = 2;
        intArr2[5] = 5;
        intArr2[8] = 8;
        System.out.println("inputArr: "+ Arrays.toString(intArr2));
        int searchValue2 = 8;
        System.out.println("search: "+intArr2[searchValue2]);
    }
}
