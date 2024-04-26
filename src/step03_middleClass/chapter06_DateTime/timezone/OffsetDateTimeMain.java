package step03_middleClass.chapter06_DateTime.timezone;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {
    public static void main(String[] args) {
        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("nowOdt = " + nowOdt);
        LocalDateTime ofLocalDt = LocalDateTime.of(2024,12,25,12,01,11,100);
        OffsetDateTime ofOffsetDt = OffsetDateTime.of(ofLocalDt, ZoneOffset.of("+01:00"));
        System.out.println("ofOffsetDt = " + ofOffsetDt);
    }
}
