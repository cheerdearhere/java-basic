package step04_middleClass2.chapter02_CollectionFramework.set.hashEquals;

import step04_middleClass2.chapter02_CollectionFramework.set.MyHashSetV2;
import step04_middleClass2.chapter02_CollectionFramework.set.objectHash.Member;

public class HashAndEqualsMain {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2();

        //test
//        MemberAllNo m1 = new MemberAllNo("A12");
//        MemberAllNo m2 = new MemberAllNo("A12");
//        MemberAllNo searchTarget = new MemberAllNo("A12");
//        MemberNoEquals m1 = new MemberNoEquals("A12");
//        MemberNoEquals m2 = new MemberNoEquals("A12");
//        MemberNoEquals searchTarget = new MemberNoEquals("A12");
        Member m1 = new Member("A12");
        Member m2 = new Member("A12");
        Member searchTarget = new Member("A12");

        //hashCode
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        //equals
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        //값 추가
        set.add(m1);
        set.add(m2);
        System.out.println(set);

        //값 검색
        System.out.println("searchTarget.hashCode() = " + searchTarget.hashCode());
        System.out.println("set.contains(searchTarget) = " + set.contains(searchTarget));

    }
}
