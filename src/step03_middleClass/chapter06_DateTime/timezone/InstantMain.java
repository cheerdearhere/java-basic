package step03_middleClass.chapter06_DateTime.timezone;

import java.time.*;

public class InstantMain {
    public static void main(String[] args) {

        Instant now = Instant.now();
        System.out.println("now = " + now);

        //LocalDateTime은 TimeZone 정보가 없어 사용할 수 없음
        ZonedDateTime znow = ZonedDateTime.now();
        System.out.println("znow = " + znow);
        Instant fromZoned = Instant.from(znow);
        System.out.println("fromZoned = " + fromZoned);

        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("epochStart = " + epochStart);
        Instant epochPlus3600 = epochStart.plusSeconds(3600);
        System.out.println("epochPlus3600 = " + epochPlus3600);
        long epochSeconds = epochPlus3600.getEpochSecond();
        System.out.println("epoch 기준 경과시간 = " + epochSeconds);
    }
}
