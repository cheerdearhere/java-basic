package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        MyUser m1 = new MyUser("a",11);
        MyUser m2 = new MyUser("a",31);
        MyUser m3 = new MyUser("a",21);
        MyUser m4 = new MyUser("a",21);

        List<MyUser> list = new ArrayList<MyUser>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        System.out.println(list);
        list.sort(null);//기본 정렬(Comparable)
        System.out.println(list);
        list.sort(new IdComparator());//비교자 사용
        System.out.println(list);
        Collections.sort(list);//Collections 가능
        Collections.sort(list, new IdComparator());
    }
}
