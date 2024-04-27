package step03_middleClass.chapter06_DateTime.temporalInterface;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args){
        ChronoUnit[] values = ChronoUnit.values();
        System.out.print("chronos unit: ");
        int count = 0;
        for(ChronoUnit value : values){
            if(count!=0) System.out.print(", ");
            System.out.print(value);
            count++;
            if(count == values.length) System.out.println();
        }
        System.out.println("ChronoUnit.HOURS = " + ChronoUnit.HOURS);
        System.out.println("ChronoUnit.HOURS.getDuration().getSeconds() = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println("ChronoUnit.DAYS.getDuration().getSeconds() = " + ChronoUnit.DAYS.getDuration().getSeconds());

        // 차이 구하기
        LocalTime lt1 = LocalTime.of(1,10,0);
        LocalTime lt2 = LocalTime.of(1,20,0);
        long secondsBetween = ChronoUnit.SECONDS.between(lt1, lt2);
        System.out.println("secondsBetween = " + secondsBetween);
    }
}
