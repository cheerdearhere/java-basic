package step03_middleClass.chatper02_Immutable.primitiveReference;

public class ReferenceMain {
    public static void main(String[] args) {
        ReferenceObject a = new ReferenceObject(10);
        ReferenceObject b = a;
        b.setField(10+1);
        System.out.println("a, b: " + a + ", "+b);
        ReferenceObject c = a.deepCopy();
        c.setField(20);
        System.out.println("a, c: " + a+", "+c);
    }
}
