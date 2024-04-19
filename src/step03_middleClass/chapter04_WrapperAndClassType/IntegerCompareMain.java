package step03_middleClass.chapter04_WrapperAndClassType;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerCompareMain {
    public static void main(String[] args) {
        int value = 10;
        int i1 = compareTo(value,5);
        int i2 = compareTo(value,10);
        int i3 = compareTo(value,20);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

        MyInteger myInteger = new MyInteger(value);
        int m1 = myInteger.compareTo(5);
        int m2 = myInteger.compareTo(10);
        int m3 = myInteger.compareTo(20);

        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);
        System.out.println("m3 = " + m3);

        int[] intArr = {-1,0,1,1,3};
        System.out.println("1 몇 개? "+findValue(intArr,1));
        System.out.println("1 몇 개? "+findValue(intArr,-1));
        System.out.println("100 몇 개? "+findValue(intArr,100));

        MyInteger[] myIntegerArr = {new MyInteger(-1), new MyInteger(0), new MyInteger(1), new MyInteger(2), new MyInteger(3)};
        System.out.println("1 몇 개? "  +findMyInteger(myIntegerArr,1));
        System.out.println("1 몇 개? "  +findMyInteger(myIntegerArr,-1));
        System.out.println("100 몇 개? "+findMyInteger(myIntegerArr,100));
    }
    private static MyInteger findMyInteger(MyInteger[] arr, int value) {
        for(MyInteger i : arr) {
            if(i.getValue() == value) {
                return i;
            }
        }
        return null;
    }
    private static int findValue(int[] arr, int value) {
//        return (int)(Arrays.stream(arr).filter(i->i==value).count());
        for(int i : arr){
            if(i==value) return value;
        }
        return -1;
    }

    private static int compareTo(int value, int target){
        if(value < target){
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }
}
