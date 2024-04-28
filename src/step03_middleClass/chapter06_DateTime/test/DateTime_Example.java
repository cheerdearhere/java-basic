package step03_middleClass.chapter06_DateTime.test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTime_Example {
    //Question List
    //문제1 - 날짜 더하기
    //문제2 - 날짜 간격 반복 출력하기
    //문제3 - 디데이 구하기
    //문제4 - 시작 요일, 마지막 요일 구하기
    //문제5 - 국제 회의 시간
    public static void main(String[] args){
/*
문제1 - 날짜 더하기
문제 설명
  2024년 1월 1일 0시 0분 0초에 1년 2개월 3일 4시간 후의 시각을 찾아라.
  TestPlus 클래스에 문제를 풀어라.
실행 결과
  기준 시각: 2024-01-01T00:00
  1년 2개월 3일 4시간 후의 시각: 2025-03-04T04:00
 */
        LocalDateTime ldt = LocalDateTime.of(2024,1,1,0,0);
        System.out.println("기준 시각: "+ldt);
        LocalDateTime futureLdt = ldt.plusYears(1).plusMonths(2).plusDays(3).plusHours(4);
        System.out.println("1년 2개월 3일 4시간 후의 시각: "+futureLdt);
/*
문제2 - 날짜 간격 반복 출력하기
문제 설명
  2024년 1월 1일 부터 2주 간격으로 5번 반복하여 날짜를 출력하는 코드를 작성하세요.
  TestLoopPlus 클래스에 문제를 풀어라
실행 결과
  날짜 1: 2024-01-01
  날짜 2: 2024-01-15
  날짜 3: 2024-01-29
  날짜 4: 2024-02-12
  날짜 5: 2024-02-26
 */
        LocalDate date = LocalDate.of(2024,1,1);
        for(int i = 1;i<=5;i++){
            System.out.println("날짜 "+i+": "+date);
            date = date.plusDays(14);
        }
/*
문제3 - 디데이 구하기
문제 설명
  시작 날짜와 목표 날짜를 입력해서 남은 기간과 디데이를 구해라. 실행 결과를 참고하자.
  남은 기간: x년 x개월 x일 형식으로 출력한다.
  디데이: x일 남은 형식으로 출력한다.

  package time.test;
  import java.time.LocalDate;
  import java.time.Period;
  import java.time.temporal.ChronoUnit;
  public class TestBetween {
   public static void main(String[] args) {
   LocalDate startDate = LocalDate.of(2024, 1, 1);
   LocalDate endDate = LocalDate.of(2024, 11, 21);
   // 코드 작성
   }
  }
실행 결과 
  시작 날짜: 2024-01-01
  목표 날짜: 2024-11-21
  남은 기간: 0년 10개월 20일
  디데이: 325일 남음 
 */
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);
        System.out.println("시작 날짜: "+startDate);
        System.out.println("목표 날짜: "+endDate);
        Period period = Period.between(startDate,endDate);
        System.out.println("남은 기간: "+period.getYears()+"년 "+period.getMonths()+"개월 "+period.getDays()+"일");
        System.out.println("D-day: "+ ChronoUnit.DAYS.between(startDate,endDate));
/*
문제4 - 시작 요일, 마지막 요일 구하기
입력 받은 월의 첫날 요일과 마지막날 요일을 구해라.

  package time.test;
  import java.time.DayOfWeek;
  import java.time.LocalDate;
  import java.time.temporal.TemporalAdjusters;
  public class TestAdjusters {
   public static void main(String[] args) {
   int year = 2024;
   int month = 1;
   // 코드 작성
   }
  }
실행 결과
  firstDayOfWeek = MONDAY
  lastDayOfWeek = WEDNESDAY
 */
        int year = 2024;
        int month = 1;
        LocalDate date2 = LocalDate.of(year,month,1);
        System.out.println("firstDayOfWeek: "+date2.getDayOfWeek());
        System.out.println("lastDayOfWeek: "+date2.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
/*
문제5 - 국제 회의 시간
  서울의 회의 시간은 2024년 1월 1일 오전 9시다. 이때 런던, 뉴욕의 회의 시간을 구해라.
  실행 결과를 참고하자.
  TestZone 클래스에 문제를 풀어라.
실행 결과
  서울의 회의 시간: 2024-01-01T09:00+09:00[Asia/Seoul]
  런던의 회의 시간: 2024-01-01T00:00Z[Europe/London]
  뉴욕의 회의 시간: 2023-12-31T19:00-05:00[America/New_York]
 */
        LocalDateTime seoulLocalDateTime = LocalDateTime.of(2024,1,1,9,0);

        ZonedDateTime seoulZDT = ZonedDateTime.of(seoulLocalDateTime,ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonZDT = seoulZDT.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newYorkZDT = seoulZDT.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(
                "  서울의 회의 시간: "+seoulZDT+"\n" +
                "  런던의 회의 시간: "+londonZDT+"\n" +
                "  뉴욕의 회의 시간: "+newYorkZDT);
    }
}
