package step03_middleClass.chatper02_Immutable.primitiveReference;

public class ReferenceObject {
    private int field;
    public ReferenceObject(int field) {
        this.field = field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }
    public ReferenceObject deepCopy() {
        return new ReferenceObject(this.field);
    }
    @Override
    public String toString() {
        return String.valueOf(field);
    }
}
