package step03_middleClass.chapter06_DateTime.useMethod;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportedMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        if(now.isSupported(ChronoField.SECOND_OF_MINUTE)){
            int dateSeconds = now.get(ChronoField.SECOND_OF_MINUTE);
            System.out.println("dateSeconds = " + dateSeconds);
        }else{
            System.out.println("SECOND_OF_MINUTE is not supported");
        }
    }
}
