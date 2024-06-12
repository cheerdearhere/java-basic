package step05_designPatterns.factoryMethod;

import java.util.Calendar;
import java.util.Locale;

public class SimpleFactoryCalendar {
    public static void main(String[] args) {
        //단순 팩토리로 만들어진 calendar
        System.out.println(Calendar.getInstance().getClass());
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).getClass());
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).getClass());
        /*
        class java.util.GregorianCalendar
        class sun.util.BuddhistCalendar
        class java.util.JapaneseImperialCalendar
         */
    }
}
