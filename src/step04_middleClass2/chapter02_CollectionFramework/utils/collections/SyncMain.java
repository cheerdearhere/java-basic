package step04_middleClass2.chapter02_CollectionFramework.utils.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list : "+list.getClass().getName());
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println("synchronizedList className: "+synchronizedList.getClass().getName());
    }
}
