package step03_middleClass.chapter02_Immutable.immutableObject;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableObject memberA = new ImmutableObject(10);
        ImmutableObject memberB = memberA.add(20);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
