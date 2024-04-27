package step03_middleClass.chapter06_DateTime.useMethod;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class ChangeDateTimeWithMain {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2010, 1, 1, 12,0,0,0);
        System.out.println("ldt = " + ldt);

        LocalDateTime with10y = ldt.with(ChronoField.YEAR, 2020);
        System.out.println("with10y = " + with10y);
        LocalDateTime withYear = ldt.withYear(2020);
        System.out.println("withYear = " + withYear);
        LocalDateTime withMonth = ldt.withMonth(2);
        System.out.println("withMonth = " + withMonth);

        // TemporalAdjuster 사용
        LocalDateTime nextFriday = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("next Friday = " + nextFriday);
        LocalDateTime lastSunday = ldt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("last Sunday of month = " + lastSunday);
        LocalDateTime lastDayOfMonth = ldt.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth = " + lastDayOfMonth);
    }
}
