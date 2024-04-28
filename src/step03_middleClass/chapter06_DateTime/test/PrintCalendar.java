package step03_middleClass.chapter06_DateTime.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class PrintCalendar {
/*
문제: 달력 출력하기
실행 결과를 참고해서 달력을 출력해라.
  입력 조건: 년도, 월
  실행시 날짜의 간격에는 신경을 쓰지 않아도 된다. 간격을 맞추는 부분은 정답을 참고하자.
실행 결과
  년도를 입력하세요: 2024
  월을 입력하세요: 1
  Su Mo Tu We Th Fr Sa
   1 2 3 4 5 6
   7 8 9 10 11 12 13
  14 15 16 17 18 19 20
  21 22 23 24 25 26 27
  28 29 30 31

  년도를 입력하세요: 2025
  월을 입력하세요: 1
  Su Mo Tu We Th Fr Sa
   1 2 3 4
   5 6 7 8 9 10 11
  12 13 14 15 16 17 18
  19 20 21 22 23 24 25
  26 27 28 29 30 31
 */
    public static void main(String[] args) {
        int year;
        int month;
        int day;
        int startDate;
        int lastDayOfWeek;
        int lastDayOfMonth;
        StringBuilder sb;
        int lang;
        String[] languageArray = {
                "\tSu\tMo\tTu\tWe\tTh\tFr\tSa\n\t",
                "\t일\t월\t화\t수\t목\t금\t토\n\t"
        };

        Scanner sc = new Scanner(System.in);
        LANGUAGE: while(true){
            System.out.println("언어 선택: eng - 0, kor - 1");
            lang = sc.nextInt();
            if(lang == 0 || lang == 1){
                sc.nextLine();
                break LANGUAGE;
            }else{
                System.out.println("잘못입력하셨습니다.");
                continue LANGUAGE;
            }
        }

        PRINTER: while(true){
            System.out.println("년도를 입력하세요(1970~2500): ");
            year = sc.nextInt();
            sc.nextLine();
            if(year < 1970 || year > 2500) {
                System.out.println("입력값을 다시 확인해주세요: "+year);
                continue PRINTER;
            }
            System.out.println("월을 입력하세요: ");
            month = sc.nextInt();
            sc.nextLine();
            if(month < 1 || month > 12) {
                System.out.println("입력값을 다시 확인해주세요: "+month);
                continue PRINTER;
            }
            day = 1;
            LocalDate targetDt = LocalDate.of(year, month, day);
            DayOfWeek f = targetDt.getDayOfWeek();//첫날 요일

            sb = new StringBuilder(languageArray[lang]);
            for(int i = 0; i<f.getValue(); i++){
                sb.append("\t");
            }
            startDate = 7-f.getValue();
            for(int i = 0; i<startDate; i++){
                sb.append(day).append("\t");
                day++;
            }
            sb.append("\n\t");
            lastDayOfWeek = day-1;
            lastDayOfMonth= targetDt.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
            CALENDAR: for(int i = lastDayOfWeek; i<=lastDayOfMonth; i++) {
                sb.append(day);
                if(day%7==lastDayOfWeek) {
                    sb.append("\n").append("\t");
                }
                else sb.append("\t");
                day++;
                if(day>lastDayOfMonth) break CALENDAR;
            }
            sb.append("\n");
            System.out.print(sb);

            CONFIRM : while (true){
                System.out.println("종료하시겠습니까(y): ");
                String res = sc.nextLine().toLowerCase();
                if(res.equals("y")) {
                    sc.close();
                    break PRINTER;
                }
                else if(res.equals("n")) continue PRINTER;
                else continue CONFIRM;
            }
        }

    }
}
