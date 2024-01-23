package chapter07_Array;

public class Array3 {
    public static void main(String[] args) {
        int[] numArr = {1,2,3,4,5};
//        일반 for
        for(int i = 0;i<numArr.length;i++){
            int num = numArr[i];
            System.out.println(num);
        }
//        향상된 for
        for(int num : numArr){
            System.out.println(num);
        }

    }
}
