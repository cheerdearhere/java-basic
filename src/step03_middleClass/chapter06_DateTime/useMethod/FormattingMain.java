package step03_middleClass.chapter06_DateTime.useMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024,12,25);

        //formatting: TemporalAccessor => String
        System.out.println("date.toString(): " + date);
        System.out.println("직접작성 (date.getYear()+\"년 \"...) : " + date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        System.out.println("use DateTimeFormatter: " + date.format(formatter));

        //parsing: String => TemporalAccessor
        String dateStr = "2030년 12월 23일";
        LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
        System.out.println("parsedDate = " + parsedDate);

        //DateTime 사용하기
        LocalDateTime ldt = LocalDateTime.of(2024,12,25,12,59,0);
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dtStr = ldt.format(dtFormatter);
        System.out.println("dtStr = " + dtStr);

        String dateTimeStr = "2025-01-01 10:00:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeStr, dtFormatter);
        System.out.println("parsedDateTime = " + parsedDateTime);
    }
}
