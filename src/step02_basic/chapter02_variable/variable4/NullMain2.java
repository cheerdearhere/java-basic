package step02_basic.chapter02_variable.variable4;

import java.util.Arrays;

public class NullMain2 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // null
        System.out.println("bigData.data.value = " + bigData.data.value); //null.value >> NullPointException
    }
}
