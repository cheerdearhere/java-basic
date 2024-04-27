package step03_middleClass.chapter06_DateTime.temporalInterface;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoFieldMain {
    public static void main(String[] args) {
        ChronoField[] fields = ChronoField.values();
        System.out.print("chronos fields: ");
        int count = 0;
        for (ChronoField field : fields) {
            if(count!=0) System.out.print(", ");
            System.out.print(field);
            count++;
            if(count == fields.length) System.out.println();
        }

        System.out.println("ChronoField.MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("ChronoField.DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());
    }
}
