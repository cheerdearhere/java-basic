package step03_middleClass.chapter03_StringClass.methodChaining;

public class ValueAdder {
    private int value;
    public ValueAdder add(int addValue){
        this.value += addValue;
        return this;
    }
    public int getValue(){
        return value;
    }
}
