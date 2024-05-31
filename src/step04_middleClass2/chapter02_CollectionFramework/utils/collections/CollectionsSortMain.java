package step04_middleClass2.chapter02_CollectionFramework.utils.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);

        System.out.println("max: "+Collections.max(list));
        System.out.println("min: "+Collections.min(list));
        System.out.println("list: "+list);
        Collections.sort(list);
        System.out.println("sorted: "+list);
        Collections.shuffle(list);
        System.out.println("shuffled first: "+list);
        Collections.shuffle(list);
        System.out.println("shuffled second: "+list);
        Collections.reverse(list);
        System.out.println("reversed: "+list);



    }
}
