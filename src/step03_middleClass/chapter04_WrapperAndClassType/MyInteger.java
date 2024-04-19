package step03_middleClass.chapter04_WrapperAndClassType;

public class MyInteger {
    private final int value;//0

    public MyInteger(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int compareTo(int target) {
        if(value > target){
            return 1;
        }else if(value < target){
            return -1;
        }
        else return 0;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
