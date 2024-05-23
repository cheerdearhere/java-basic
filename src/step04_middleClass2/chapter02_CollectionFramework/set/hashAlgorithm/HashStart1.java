package step04_middleClass2.chapter02_CollectionFramework.set.hashAlgorithm;

import java.util.Arrays;

public class HashStart1 {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[100];
        intArr[1]=1;
        intArr[2]=2;
        intArr[5]=5;
        intArr[7]=7;
        intArr[13]=13;
        intArr[56]=56;
        intArr[78]=78;
        intArr[99]=99;
//        Random random = new Random();
//        int counter = 10;
//        for(int i = 0; i < counter; i++){
//            int randomInt = random.nextInt(100);
//            if(intArr[randomInt] == null){
//                intArr[randomInt]=randomInt;
//            }else {
//                System.out.println("중복: "+randomInt);
//            }
//        }
//        System.out.println("result: "+ Arrays.toString(Arrays.stream(intArr).filter(Objects::nonNull).toArray()));
        System.out.println("result: "+ Arrays.toString(intArr));

        int searchValue = 99;
        System.out.println("search result: "+ intArr[searchValue]);

    }
}
