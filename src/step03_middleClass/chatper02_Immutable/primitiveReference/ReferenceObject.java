package step03_middleClass.chatper02_Immutable.primitiveReference;

public class ReferenceObject {
    private int a;
    public ReferenceObject(int a) {
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
    public ReferenceObject deepCopy() {
        return new ReferenceObject(this.a);
    }
    @Override
    public String toString() {
        return String.valueOf(a);
    }
}
