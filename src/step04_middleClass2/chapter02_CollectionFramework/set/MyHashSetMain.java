package step04_middleClass2.chapter02_CollectionFramework.set;

public class MyHashSetMain {
    public static void main(String[] args) {
        //only use Integer instance
//        MyHashSetV0 set = new MyHashSetV0();
//        MyHashSetV1 set = new MyHashSetV1();
//        System.out.println("add new data: "+set.add(1));
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        set.add(5);
//        set.add(32);
//        set.add(17);
//        set.add(28);
//        set.add(99);
//        set.add(9);
//        set.add(97);
//        System.out.println(set);
//        System.out.println("add duplicated data: "+set.add(99));

        // use Object's children class
        MyHashSetV2 set = new MyHashSetV2(10);
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("AB");
        set.add("SET");
        System.out.println(set);
        System.out.println("add duplicated data: "+set.add("A"));
        String searchValue = "A";
        System.out.println("search A: "+set.contains(searchValue));
        searchValue = "Z";
        System.out.println("search Z: "+set.contains(searchValue));
    }
}
