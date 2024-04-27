package step03_middleClass.chapter06_DateTime.useMethod;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class GetDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2030,1,2,13,34,59,123);
        // 원하는 데이터 입력
        System.out.println("Year: " + dt.get(ChronoField.YEAR));
        System.out.println("Month of year: " + dt.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("Day of month: " + dt.get(ChronoField.DAY_OF_MONTH));
        System.out.println("Hour of day: " + dt.get(ChronoField.HOUR_OF_DAY));
        System.out.println("Minute of hour: " + dt.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("Nano of Second = " + dt.get(ChronoField.NANO_OF_SECOND));
        System.out.println();
        // 편의 메서드
        System.out.println("get Year: " + dt.getYear());
        System.out.println("get Month value: " + dt.getMonthValue());
        System.out.println("get Month object: "+dt.getMonth());
        System.out.println("get Day of month: " + dt.getDayOfMonth());
        System.out.println("get Hour of day: " + dt.getHour());
        System.out.println("get Minute of hour: " + dt.getMinute());
        System.out.println("get Nano of Second = " + dt.getNano());
        System.out.println();
        // 편의 메서드에 없는 경우
        System.out.println("Minute of day: "+dt.get(ChronoField.MINUTE_OF_DAY));
        System.out.println("Second of day: "+dt.get(ChronoField.SECOND_OF_DAY));
    }
}
