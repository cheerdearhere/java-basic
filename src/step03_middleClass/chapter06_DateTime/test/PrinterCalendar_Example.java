package step03_middleClass.chapter06_DateTime.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class PrinterCalendar_Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("년도를 입력하세요: ");
        int year = sc.nextInt();
        System.out.println("월을 입력하세요: ");
        int month = sc.nextInt();

        printCalendar(year,month);
    }

    private static void printCalendar(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);

        //월~일: 1~7 = offset % 7(1~0)
        int offsetWeekDays = firstDayOfMonth.getDayOfWeek().getValue() % 7;
        System.out.print("\tSu\tMo\tTu\tWe\tTh\tFr\tSa\n");
        for(int i = 0; i < offsetWeekDays; i++) {
            System.out.print("\t");
        }
        LocalDate dayIterator = firstDayOfMonth;
        while(dayIterator.isBefore(firstDayOfNextMonth)) {
            System.out.print("\t"+dayIterator.getDayOfMonth());
            if(dayIterator.getDayOfWeek() == DayOfWeek.SATURDAY)
                System.out.println();
            dayIterator = dayIterator.plusDays(1);
        }
    }
}
