package step04_middleClass2.chapter02_CollectionFramework.array;

import java.util.Arrays;

public class ArrayMain1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println("=== index 입력: O(1) ===");
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(Arrays.toString(arr));

        System.out.println("=== index 변경: O(1) ===");
        arr[2]= 10;
        System.out.println(Arrays.toString(arr));

        System.out.println("=== index 조회: O(1) ===");
        System.out.println("arr[2]: "+arr[2]);

        System.out.println("=== 배열 검색: O(n) ===");
        System.out.println(Arrays.toString(arr));
        int searchingValue = 10;
        for(int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]: "+arr[i]);
            if(arr[i]==searchingValue){
                System.out.println("index: "+i);
                break;
            }
        }
    }
}
