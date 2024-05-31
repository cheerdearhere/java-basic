package step04_middleClass2.chapter02_CollectionFramework.utils.collections;

import java.util.*;

public class OfMain {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        list.set(2,99);//Immutable object is modified
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3, "d", 4);

        System.out.println("list: " + list.getClass().getName());
        System.out.println("set: " + set.getClass()  .getName());
        System.out.println("map: " + map.getClass()  .getName());

        //가변 리스트로 변환하기
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.remove(2);
        System.out.println(mutableList);
        // mutable Collection -> immutable Collection
        List<Integer> immutableList = Collections.unmodifiableList(mutableList);
//        immutableList.remove(2);
    }
}
