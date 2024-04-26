package step03_middleClass.chapter06_DateTime.local;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);
        LocalDate birthday = LocalDate.of(1989,10,5);
        System.out.println("birthday = " + birthday);

        //계산
        LocalDate birthPlus10Day = birthday.plusDays(10);
        System.out.println("birth+10d = " + birthPlus10Day);
    }
}
