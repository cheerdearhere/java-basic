package step04_middleClass2.chapter02_CollectionFramework.array;

import java.util.Arrays;

public class ArrayMain2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        System.out.println("시작: "+Arrays.toString(arr));
//        index 0에 값 삽입
        int newValue = 10;
        System.out.println("insert 10 at first index: O(n)");
        addFirst(arr,newValue);
//        index 위치를 지정해 삽입
        System.out.println("insert 20 at index 2: O(n/2)");
        newValue = 20;
        int targetIdx = 2;
        addIndex(arr,newValue,targetIdx);
//        배열의 마지막에 삽입
        System.out.println("insert 30 at last index: O(1)");
        newValue = 30;
        addLast(arr,newValue);
    }

    private static void addLast(int[] arr, int insertValue) {
        int operateCount = 0;
        //위치 찾기
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
        //마지막 위치에 삽입
        arr[arr.length-1] = insertValue;
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
    }

    private static void addIndex(int[] arr, int insertValue, int index) {
        int operateCount = 0;
        //위치 찾기
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
        //해당 index까지만 하나씩 밀기
        for(int i = arr.length-1; i > index; i--) {
            arr[i]=arr[i-1];
            System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
        }
        //값 삽입
        arr[index]=insertValue;
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
    }

    private static void addFirst(int[] arr, int insertValue) {
        int operateCount = 0;
        //위치 찾기
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
        //전체를 하나씩 밀기
        for(int i = arr.length-1; i > 0; i--) {
            arr[i]=arr[i-1];
            System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
        }
        //값 삽입
        arr[0]=insertValue;
        System.out.printf("%d회 연산: %s\n",++operateCount,Arrays.toString(arr));
    }
}
