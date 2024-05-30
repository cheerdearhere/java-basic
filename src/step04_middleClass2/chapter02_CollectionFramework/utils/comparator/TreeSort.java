package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;


import javax.sql.rowset.serial.SQLOutputImpl;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        MyUser m1 = new MyUser("a",11);
        MyUser m2 = new MyUser("b",31);
        MyUser m3 = new MyUser("c",21);

        //MyUser 기본 비교자
        TreeSet<MyUser> users = new TreeSet<MyUser>();
        users.add(m1);
        users.add(m2);
        users.add(m3);
        System.out.println("default: "+users);
        //외부 비교자
        TreeSet<MyUser> users2 = new TreeSet<MyUser>(new IdComparator());
        users2.add(m1);
        users2.add(m2);
        users2.add(m3);
        System.out.println("id comparator: "+users2);
    }
}
