package step03_middleClass.chapter06_DateTime.local;

import java.time.LocalTime;

public class LocalTimeMain {
    public static void main(String[] args) {
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);
        LocalTime ofTime = LocalTime.of(12,10,30,0);
        System.out.println("ofTime = " + ofTime);

        LocalTime plus4000s = ofTime.plusHours(4000);
        System.out.println("+4000s = " + plus4000s);
    }
}
