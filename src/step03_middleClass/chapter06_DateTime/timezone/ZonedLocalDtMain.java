package step03_middleClass.chapter06_DateTime.timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedLocalDtMain {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime ofLocalDt = LocalDateTime.of(2024,12,25,12,01,11,100);
        ZonedDateTime ofZonedDt = ZonedDateTime.of(ofLocalDt, ZoneId.systemDefault());
        System.out.println("ofLocalDt = " + ofLocalDt);
        System.out.println("ofZonedDt = " + ofZonedDt);

        ZonedDateTime minus365d = ofZonedDt.plusDays(365);
        System.out.println("- 365d = " + minus365d);
        ZonedDateTime transUTC = ofZonedDt.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("transUTC = " + transUTC);
        ZonedDateTime transParis = ofZonedDt.withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println("transParis = " + transParis);

    }
}
