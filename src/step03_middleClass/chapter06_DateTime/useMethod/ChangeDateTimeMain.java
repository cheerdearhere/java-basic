package step03_middleClass.chapter06_DateTime.useMethod;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2010, 1, 1, 12,0,0,0);
        System.out.println("ldt = " + ldt);

        //plus(amount, ChronoUnit)
        LocalDateTime plus10y = ldt.plus(10, ChronoUnit.YEARS);
        System.out.println("+10y = "+plus10y);
        //plusYears(amount)
        LocalDateTime plus10yMethod = ldt.plusYears(10);
        System.out.println("+10y(Method)= "+plus10yMethod);
        //plus(Period)
        Period p10y = Period.ofYears(10);
        LocalDateTime plus10yPeriod = ldt.plus(p10y);
        System.out.println("+10y(period): "+plus10yPeriod);
    }
}
