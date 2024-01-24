package step01_beginner.chapter07_Array;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args){
//        2x3 배열
        int[][] arr = new int[2][3];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;
        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
//        선언, 생성, 초기화
        int[][] initArr = /*new int[][]*/{
            {1,2,3},
            {4,5,6}
        };
//        Stream 사용해서 꺼내기
        Arrays.stream(initArr).flatMapToInt(Arrays::stream).forEach(System.out::print);
        System.out.println();
//        0행 출력
        System.out.print(arr[0][0]+" ");
        System.out.print(arr[0][1]+" ");
        System.out.print(arr[0][2]+" ");
//        행 변경 > 줄 바꿈
        System.out.println();
//        1행 출력
        System.out.print(arr[1][0]+" ");
        System.out.print(arr[1][1]+" ");
        System.out.print(arr[1][2]+" ");
        System.out.println();
//        반복문 사용하기
        for(int i = 0;i<arr.length;i++){
            for(int j = 0; j < arr[i].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
