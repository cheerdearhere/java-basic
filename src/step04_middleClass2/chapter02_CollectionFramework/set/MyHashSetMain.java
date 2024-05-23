package step04_middleClass2.chapter02_CollectionFramework.set;

public class MyHashSetMain {
    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();
        System.out.println("add new data: "+set.add(1));
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);
        System.out.println("add duplicated data: "+set.add(1));
    }
}
