package step04_middleClass2.chapter02_CollectionFramework.set;

import step04_middleClass2.chapter02_CollectionFramework.set.objectHash.Member;

public class MyHashSetMainCustom {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2();
        // Member instance
        Member hi = new Member("hi");
        Member dupHi = new Member("hi");
        Member jpa  = new Member("JPA");
        Member java = new Member("java");
        Member spring = new Member("spring");

        System.out.println("hi.hashCode() = " + hi.hashCode());
        System.out.println("dupHi.hashCode() = " + dupHi.hashCode());
        System.out.println("jpa.hashCode() = " + jpa.hashCode());
        System.out.println("java.hashCode() = " + java.hashCode());
        System.out.println("spring.hashCode() = " + spring.hashCode());

        set.add(hi);
        set.add(jpa);
        set.add(java);
        set.add(spring);

        System.out.println(set);
        System.out.println("add duplicated data: "+set.add(dupHi));
        String searchValue = "A";
        System.out.println("search A: "+set.contains(searchValue));
        searchValue = "Z";
        System.out.println("search Z: "+set.contains(searchValue));

    }
}
