package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;

import java.util.Arrays;

public class SortMain2 {
    public static void main(String[] args) {
        MyUser m1 = new MyUser("a",11);
        MyUser m2 = new MyUser("a",31);
        MyUser m3 = new MyUser("a",21);
        MyUser m4 = new MyUser("a",21);

        MyUser[] users = {m1,m2,m3};
        System.out.println(Arrays.toString(users));
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));
        Arrays.sort(users, new IdComparator());
        System.out.println(Arrays.toString(users));

    }
}
