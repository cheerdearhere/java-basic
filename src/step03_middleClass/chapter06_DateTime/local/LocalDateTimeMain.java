package step03_middleClass.chapter06_DateTime.local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime nowDt = LocalDateTime.now();
        System.out.println("nowDt = " + nowDt);
        LocalDateTime ofDt = LocalDateTime.of(2018, 10, 10, 10, 10, 10, 0);
        System.out.println("ofDt = " + ofDt);

        LocalDateTime plus20000s = ofDt.plusSeconds(20000);
        System.out.println("+20000s = " + plus20000s);
        LocalDateTime minus2years = ofDt.minusYears(2);
        System.out.println("- 2y = " + minus2years);
        
        // 날짜와 시간 데이터 분리 가능
        LocalDate date = ofDt.toLocalDate();
        System.out.println("date = " + date);
        LocalTime time = ofDt.toLocalTime();
        System.out.println("time = " + time);

        // LocalDate+LocalTime
        LocalDateTime newDt = LocalDateTime.of(date,time);
        System.out.println("newDt = " + newDt);

        // 비교
        System.out.println("오늘 기준 ofDt는 과거인가? "+nowDt.isBefore(ofDt)); // false
        System.out.println("오늘 기준 ofDt는 미래인가? "+nowDt.isAfter(ofDt)); // true
        System.out.println("오늘 기준 newDt는 과거인가? "+nowDt.isBefore(newDt)); // false

    }
}
