package step03_middleClass.chapter06_DateTime.periodDuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodMain {
    public static void main(String[] args) {
        //기간
        Period period = Period.ofDays(10);//ofMonths, ofYears
        System.out.println("period = " + period);
        // 기준 시간에 추가
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);
        LocalDate plusPeriod = nowDate.plus(period);
        System.out.println("+Period = " + plusPeriod);
        //기간 차이
        LocalDate birthday = LocalDate.of(1990, 1, 1);
        Period between = Period.between(birthday, plusPeriod);
        System.out.println("between = " + between);
        System.out.println(between.getYears()+"년 "+between.getMonths()+"월 "+between.getDays()+"일");
    }
}
