package step04_middleClass2.chapter02_CollectionFramework.set.objectHash;

import java.util.Objects;

public class JavaHashCodeMain {
    public static void main(String[] args) {
        System.out.println("## Object default hashCode() ##");
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());
        String obj1HexRef = Objects.toIdentityString(obj1);
        System.out.println("obj1 reference address = " + obj1HexRef);
        System.out.println("obj1 hexadecimal hashCode() = " + obj1HexRef.substring(obj1HexRef.indexOf("@") + 1));

        System.out.println("## java's libraries HashCode ##");
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";

        System.out.println("10.hashCode() = " + i.hashCode());
        System.out.println("strA.hashCode() = " + strA.hashCode());
        System.out.println("strAB.hashCode() = " + strAB.hashCode());
        System.out.println("Integer.valueOf(-1).hashCode() = " + Integer.valueOf(-1).hashCode());

        System.out.println("## Customized class ##");
        Member member1 = new Member("idA");//인스턴스는 다르지만 equals는 같다
        Member dupMember1 = new Member("idA");

        System.out.println("member1 == dupMember1 = " + (member1==dupMember1));
        System.out.println("member1.equals(dupMember1) = " + member1.equals(dupMember1));
        System.out.println("identity String(member1) = " + Objects.toIdentityString(member1));
        System.out.println("identity String(dupMember1) = " + Objects.toIdentityString(dupMember1));
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("dupMember1.hashCode() = " + dupMember1.hashCode());
    }
}
