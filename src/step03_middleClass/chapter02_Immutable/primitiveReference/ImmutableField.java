package step03_middleClass.chapter02_Immutable.primitiveReference;

public class ImmutableField {
    private final int field;
    public ImmutableField(int field) {
        this.field = field;
    }
//    public void setField(int field) {
//        this.field = field;
//    }

    public int getField() {
        return field;
    }
    @Override
    public String toString() {
        return String.valueOf(field);
    }
}
