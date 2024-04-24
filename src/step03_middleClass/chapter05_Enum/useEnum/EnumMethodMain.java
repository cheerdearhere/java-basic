package step03_middleClass.chapter05_Enum.useEnum;

import java.util.Arrays;
import java.util.stream.Stream;

public class EnumMethodMain {
    public static void main(String[] args) {
        // 모든 Enum 반환
        Grade[] values = Grade.values();
        System.out.println("Grade values: "+ Arrays.toString(values));
        Stream.of(values).forEach(value->{
            System.out.println("name: "+value.name()+"/ ordinal: "+value.ordinal());
        });
        // String -> Enum/ throws IllegalArgumentException
        String upperGold = "GOLD";
//        String lowerGold = upperGold.toLowerCase();
//        Grade lowerGoldEnum = Grade.valueOf(lowerGold);
        Grade upperGoldEnum = Grade.valueOf(upperGold);
//        System.out.println(lowerGoldEnum);
        System.out.println(upperGoldEnum);
    }
}
