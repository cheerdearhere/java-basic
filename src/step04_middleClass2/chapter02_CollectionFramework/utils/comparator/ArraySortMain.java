package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;

import java.util.Arrays;

public class ArraySortMain {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,5,3,2,4,9,7,8,6};
        System.out.println(Arrays.toString(arr));
        //for
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=0 ; j<arr.length - 1 - i ; j++){
//                if(arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
        //Arrays.sort
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
