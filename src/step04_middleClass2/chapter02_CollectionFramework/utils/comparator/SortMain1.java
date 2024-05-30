package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain1 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,5,3,2,4,9,7,8,6};
        System.out.println("before: "+Arrays.toString(arr));
//        Arrays.sort(arr,new AscComparator());
//        Arrays.sort(arr,new DescComparator());
        Arrays.sort(arr,new AscComparator().reversed());
        System.out.println("after: "+Arrays.toString(arr));
    }
    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1: "+o1+" / o2: "+o2);
            return (o1<o2)?-1:(o1==o2) ?0 :1;
        }
    }
    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return ((o1<o2)?-1:(o1==o2) ?0 :1) * -1;
        }
    }
}
