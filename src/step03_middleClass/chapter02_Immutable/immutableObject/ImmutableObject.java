package step03_middleClass.chapter02_Immutable.immutableObject;

public class ImmutableObject {
    private final int value;

    public ImmutableObject(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableObject add(int num){
        int result = value + num;
        return new ImmutableObject(result);
    }

    @Override
    public String toString() {
        return "value:" + value;
    }
}
