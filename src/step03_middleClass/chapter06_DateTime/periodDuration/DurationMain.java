package step03_middleClass.chapter06_DateTime.periodDuration;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime time = LocalTime.of(1, 0, 0, 0);
        System.out.println("time = " + time);
        LocalTime plus30min = time.plus(duration);
        System.out.println("plus30min = " + plus30min);

        LocalTime now = LocalTime.now();
        Duration between = Duration.between( plus30min,now);
        System.out.println("between = " + between);
        System.out.println("분 = "+between.toMinutes());
        System.out.println("초 = " + between.getSeconds());
        System.out.println("시, 분, 초 = "+between.toHours()+"시 "+between.toMinutesPart()+"분 "+between.toSecondsPart()+"초");
        
    }
}
