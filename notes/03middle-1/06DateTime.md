
# I. 날짜와 시간 라이브러리가 필요한 이유 
## A. 날짜와 시간 차이 계산
- 특정 날짜에서 다른 날짜까지의 정확한 일수를 계산하는 것은 매우 복잡하다
  - 윤년: 보통 4년에 한 번씩 발생. 하지만 100년 단위일때는 윤년이 아니고, 400면 단위일때는 다시 윤년
  - 각 달의 일수: 28일? 29일? 30일? 31일?
  - 언어에 따른 표현
  - 일광 절약시간(Daylight Saving Time, DST) 변환: 한국엔 없지만 미국에서는 사용 중
  - TimeZone: UTC 기준 시간을 공유하는 영역이 정해져있음
    - 세계 표준시: 
      - Europe/London
      - GMT(Greenwich Mean Time - 그리니치 천문대 기준 세계 표준시, UTC로 대체 됨)
      - UTC(Universal Time Coordinated - GMT를 대체하는 시간으로 원자시로 더 정확한 표준시)
    - 나머지 지역에서는 표준시 기준 
      - US/Arizona-07:00 
      - America/New_York-05:00 
      - Asia/Seoul+09:00
      - Asia/Dubai+
      - 04:00...
    - 서울(UTC+9)과 독일(UTC+1)의 시간계산
      - DST 적용: 8~10 시간
      - DST 미적용: 8시간
## B. Java 날짜/시간 라이브러리의 역사
- 직접 작성하면 사람마다 오차가 발생할 수 있으므로 라이브러리 사용이 안전
- JDK 1.0 : java.util.Date
  - 문제점
    - Timezone 처리 부족
    - 날짜와 시간 연산 불편
    - 불변객체 부재
- JDK 1.1: java.util.Calendar
  - 보완
    - 타임존 지원 개선
    - 날짜, 시간 연산을 위한 method 제공
 - 문제점
   - 복잡하고 직관적이지 않음
   - 일부 사례에서 성능저하
   - 불변객체 부재
 - 해결을 위해 Joda-Time Library(Open Source)를 사용
   - 표준 라이브러리가 아님 => 매번 추가
- JDK 8(1.8): java.time(JSR-310) 
  - 보완
    - 표준라이브러리에 기능을 추가
    - 이전 API 문제점 해결
    - 사용성, 성능, 스레드 안정성, 타임존 처리 등으로 개선
    - 직관적으로 작성
    - 연산 단순화
    - Joda-Time open library에서 많은 기능을 표준 플랫폼으로 가져옴
  - 포함된 class
    - LocalDate
    - LocalTime
    - LocalDateTime
    - ZoneDateTime
    - Instant...
> JPA도 유사하게 편입됨
## C. 라이브러리 소개
![사진](../img/middle/javaTimePackage.png)
[dateTime docs](https://docs.oracle.com/javase/tutorial/datetime/iso/overview.html)
### 1. LocalDate, LocalTime, LocalDateTime
- 특정지역(시스템 정보)에서만 사용하는 경우(세계표준시나 타임존을 고려하지 않는다)
  - LocalDate: 날짜(`2023-01-01`)
  - LocalTime: 시간(`08:01:01.211`)
  - LocalDateTime: 날짜와 시간(`2023-01-01T08:01:01.211`)
### 2. ZonedDateTime, OffsetDateTime
- 세계 협정시 기준 차이를 표시
  - ZonedDateTime: 시간대를 고려한 날짜와 시간을 표현할 때 사용
    - `2023-01-01T08:01:01.211+9:00[Asia/Seoul]`
    - 타임존 표시
    - 일광 절약 시간제 적용
  - OffsetDateTime: 시간대를 고려한 날짜와 시간을 표현. 타임존은 표시되지 않음
    - `2023-01-01T08:01:01.211+9:00`
    - 일광 절약 시간제 미적용
### 3. Year, Month, YearMonth, MonthDay, DayOfWeek
- 날짜 데이터 중 일부 자료만 사용할때
- 자주 사용되지는 않음
- DayOfWeek: 요일 표시 Enum
### 4. Instant
- UTC를 기준으로 시간의 한 지점을 나타냄.
- 전자 측정이 시작된 1970.01.01T00:00:00.000을 기준으로 경과한 초
- 나노초 정밀도로 표현
- 날짜 시간을 위한 자료로는 잘 사용안함(모듈 내부 시간측정 등)
### 5. Period, Duration
- 특정 지점의 시간(시각)이 아닌 시간의 간격(기간)을 표시
- amount of time
  - Period: 날짜(년, 월, 일) 단위 기간
  - Duration: 시간(시, 분, 초) 단위 기간

# II. 자주 사용하는 java.time class
## A. 기본 날짜와 시간(LocalDateTime)
[실습코드](../../src/step03_middleClass/chapter06_DateTime/local)
- 보통은 한국의 앱은 TimeZone 내에서 사용하므로 다른 시간이나 표준시를 고려할 필요가 없다
  - 글로벌 서비스에서 상대 시간 체크가 필요한 경우가 아닌 이상 거의..
- LocalDate(날짜만), LocalTime(시간만)을 내부로 갖는 것이 LocalDateTime
- local date 
  - 생성
```java
public static void main(String[] args) {
    LocalDate nowDate = LocalDate.now();
    System.out.println("nowDate = " + nowDate);//현재시간
    LocalDate birthday = LocalDate.of(1989,10,5);//특정시간
    System.out.println("birthday = " + birthday);
}
```
```
nowDate = 2024-04-26
birthday = 1989-10-05
```
  - 계산: LocalDate/Time/DateTime은 불변객체
```java
public static void main(String[] args) {
    //계산
    LocalDate birthPlus10Day = birthday.plusDays(10);
    System.out.println("birth+10d = " + birthPlus10Day);
}
```
- local Time: 시간자료 사용
```java
public static void main(String[] args) {
    LocalTime nowTime = LocalTime.now();
    System.out.println("nowTime = " + nowTime);
    LocalTime ofTime = LocalTime.of(12,10,30,0);
    System.out.println("ofTime = " + ofTime);

    LocalTime plus4000s = ofTime.plusHours(4000);
    System.out.println("+4000s = " + plus4000s);
}
```
```
nowTime = 15:47:51.043899700
ofTime = 12:10:30
+4000s = 04:10:30
```
- local Date Time
  - 기본적인 연산은 같음
```java
public static void main(String[] args) {
    LocalDateTime nowDt = LocalDateTime.now();
    System.out.println("nowDt = " + nowDt);
    LocalDateTime ofDt = LocalDateTime.of(2018, 10, 10, 10, 10, 10, 0);
    System.out.println("ofDt = " + ofDt);

    LocalDateTime plus20000s = ofDt.plusSeconds(20000);
    System.out.println("+20000s = " + plus20000s);
    LocalDateTime minus2years = ofDt.minusYears(2);
    System.out.println("- 2y = " + minus2years);
}
```
```
nowDt = 2024-04-26T15:51:49.230605300
ofDt = 2018-10-10T10:10:10
+20000s = 2018-10-10T15:43:30
- 2y = 2016-10-10T10:10:10
```
  - 날짜와 시간 데이터 분리, 재조합 가능
```java
public static void main(String[] args) {
    // 날짜와 시간 데이터 분리 가능
    LocalDate date = ofDt.toLocalDate();
    System.out.println("date = " + date);
    LocalTime time = ofDt.toLocalTime();
    System.out.println("time = " + time);

    // LocalDate+LocalTime
    LocalDateTime newDt = LocalDateTime.of(date,time);
    System.out.println("newDt = " + newDt);
}
```
  - 비교
    - isBefore/isAfter : 전후 비교 
    - isEquals: 시간적으로 같은지 비교
      - 시간으로만 비교(TimeZone 무시, UTC 기준 비교): 서울 9시 == UTC 0시
      - equals는 내부 데이터의 모든 구조가 같아야함: 서울 9시 != UTC 0시
```java
public static void main(String[] args) {
    System.out.println("오늘 기준 ofDt는 과거인가? "+nowDt.isBefore(ofDt)); // false
    System.out.println("오늘 기준 ofDt는 미래인가? "+nowDt.isAfter(ofDt)); // true
    System.out.println("오늘 기준 newDt는 과거인가? "+nowDt.isBefore(newDt)); // false
}
```
## B. TimeZone(ZonedDateTime)
[실습코드](../../src/step03_middleClass/chapter06_DateTime/timezone)
- UTC로부터의 오프셋(offset: 시간 차이) 정보를 포함
### 1. Zone Id 
- [zoneId 문서](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html)
- zoneId 사용
  - 직접 문자여로 입력도 가능 but...
```java
public static void main(String[] args) {
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    int count = 0;
    System.out.println("### Available ZoneIds");
    for(String zoneId : availableZoneIds) {
        count++;
        System.out.println("\t"+count+". "+zoneId+": "+ZoneId.of(zoneId).getRules());
    }

    System.out.println("input ZoneID - "+ZoneId.of("Asia/Seoul").getRules());
    //input ZoneID - ZoneRules[currentStandardOffset=+09:00]
}
```
- 시스템 기본: OS 기준 처리
```java
public static void main(String[] args) {
    ZoneId sysDefault = ZoneId.systemDefault();
    System.out.println("### System Default: zoneId - "+sysDefault + " | "+sysDefault.getRules());
}
```
### 2. ZonedDateTime: LocalDateTime + ZoneId
```java
public final class ZonedDateTime
        implements Temporal, ChronoZonedDateTime<LocalDate>, Serializable {
    /**
     * The local date-time.
     */
    private final LocalDateTime dateTime;
    /**
     * The offset from UTC/Greenwich.
     */
    private final ZoneOffset offset;
    /**
     * The time-zone.
     */
    private final ZoneId zone;
```
- 사용방법은 LocalDateTime과 유사
```java
public static void main(String[] args) {
    ZonedDateTime now = ZonedDateTime.now();
    System.out.println("now = " + now);

    LocalDateTime ofLocalDt = LocalDateTime.of(2024,12,25,12,01,11,100);
    ZonedDateTime ofZonedDt = ZonedDateTime.of(ofLocalDt, ZoneId.systemDefault());
    System.out.println("ofLocalDt = " + ofLocalDt);
    System.out.println("ofZonedDt = " + ofZonedDt);

}
```
```
now = 2024-04-26T16:30:31.719120200+09:00[Asia/Seoul]
ofLocalDt = 2024-12-25T12:01:11.000000100
ofZonedDt = 2024-12-25T12:01:11.000000100+09:00[Asia/Seoul]
```
- 시간 변환
```java
public static void main(String[] args) {
    ZonedDateTime minus365d = ofZonedDt.plusDays(365);
    System.out.println("- 365d = " + minus365d);
    ZonedDateTime transUTC = ofZonedDt.withZoneSameInstant(ZoneId.of("UTC"));
    System.out.println("transUTC = " + transUTC);
    ZonedDateTime transParis = ofZonedDt.withZoneSameInstant(ZoneId.of("America/Chicago"));
    System.out.println("transParis = " + transParis);
}
```
```
- 365d = 2025-12-25T12:01:11.000000100+09:00[Asia/Seoul]
transUTC = 2024-12-25T03:01:11.000000100Z[UTC]
transParis = 2024-12-24T21:01:11.000000100-06:00[America/Chicago]
```
### 3. OffsetDateTime: LocalDateTime과 UTC의 관계
- 시간 차이를 직접 입력
```java
public static void main(String[] args) {
    OffsetDateTime nowOdt = OffsetDateTime.now();
    System.out.println("nowOdt = " + nowOdt);
    LocalDateTime ofLocalDt = LocalDateTime.of(2024,12,25,12,1,11,100);
    OffsetDateTime ofOffsetDt = OffsetDateTime.of(ofLocalDt, ZoneOffset.of("+01:00"));
    System.out.println("ofOffsetDt = " + ofOffsetDt);
}
```
### 4. ZonedDateTime vs OffsetDateTime
- ZonedDateTime: 구체적인 지역시간대를 다룰때 사용, 일광 절약 시간을 자동으로 처리. 
  - 사용자 지정 시간에 대한 시간 계산이 필요할때 사용
- OffsetDateTime: 세계협정시와의 시간 차이만을 나타냃때 사용. 지역 시간대의 복잡성(TimeZone, DST)을 고려하지 않음
  - 사용자에게 보이지 않고 관리적 입장에서 처리(로그 기록)할때 사용
## C. 기계 중심의 시간(Instant)
- 협정시를 기준으로 전산 기록 시점(1970.01.01T00:00:00.000)에서 얼마나 지났는지를 표현
- UTC로만 계산
- nano second(나노초) 정밀도로 표현
- EPOCH: 에포크 시간. Unix timestamp - 기록 시점부터 현재까지의 시간을 초단위로 표현. Timezone에 영향을 받지 않는 절대적 시간표현 방식
```java
public final class Instant
        implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    /**
     * Constant for the 1970-01-01T00:00:00Z epoch instant.
     */
    public static final Instant EPOCH = new Instant(0, 0);

    //...

    /**
     * The number of seconds from the epoch of 1970-01-01T00:00:00Z.
     */
    private final long seconds;
    /**
     * The number of nanoseconds, later along the time-line, from the seconds field.
     * This is always positive, and never exceeds 999,999,999.
     */
    private final int nanos;

```
- Instance의 장단점
  - 장점
    - 시간대 독립성
    - 고정된 기준점
  - 단점
    - 사용자 친화적이지 않음(직관적이지 않음)
    - 시간대 정보가 없음
- 사용 예시
  - 세계 여러 시점에서의 같은 시간이 필요할때
  - 시간 변환 없이 고정 데이터가 필요할때 
  - 데이터 저장 및 교환에서 로그 기록을 사용할때(데이터 일관성)
  - 필요할때만 ZonedDateTime을 변환해서 사용
    - LocalDateTime은 TimeZone 정보가 없어 사용할 수 없음
```java
public static void main(String[] args) {
    Instant now = Instant.now();
    System.out.println("now = " + now);
    
    ZonedDateTime znow = ZonedDateTime.now();
    System.out.println("znow = " + znow);
    Instant fromZoned = Instant.from(znow);
    System.out.println("fromZoned = " + fromZoned);

    Instant epochStart = Instant.ofEpochSecond(0);
    System.out.println("epochStart = " + epochStart);
    Instant epochPlus3600 = epochStart.plusSeconds(3600);
    System.out.println("epochPlus3600 = " + epochPlus3600);
    long epochSeconds = epochPlus3600.getEpochSecond();
    System.out.println("epoch 기준 경과시간 = " + epochSeconds);

}
```
```
now = 2024-04-26T08:08:02.833399700Z
znow = 2024-04-26T17:08:02.845401500+09:00[Asia/Seoul]
fromZoned = 2024-04-26T08:08:02.845401500Z
epochStart = 1970-01-01T00:00:00Z
epochPlus3600 = 1970-01-01T01:00:00Z
epoch 기준 경과시간 = 3600
```
## D. 기간, 시간의 간격(Duration, Period)
[실습코드](../../src/step03_middleClass/chapter06_DateTime/periodDuration)
### 1. Period: 년, 월, 일
```java
public final class Period
        implements ChronoPeriod, Serializable {
    /**
     * The number of years.
     */
    private final int years;
    /**
     * The number of months.
     */
    private final int months;
    /**
     * The number of days.
     */
    private final int days;
```
- 내부에 각 데이터를 멤버로 갖고 그것을 꺼내는 메서드
- `getYears()`, `getMonths()`, `getDays()`
```java
    public static void main(String[] args) {
    //기간
    Period period = Period.ofDays(10);//ofMonths, ofYears
    System.out.println("period = " + period);
    // 기준 시간에 추가
    LocalDate nowDate = LocalDate.now();
    System.out.println("nowDate = " + nowDate);
    LocalDate plusPeriod = nowDate.plus(period);
    System.out.println("+Period = " + plusPeriod);
    //기간 차이
    LocalDate birthday = LocalDate.of(1990, 1, 1);
    Period between = Period.between(birthday, plusPeriod);
    System.out.println("between = " + between);
    System.out.println(between.getYears()+"년 "+between.getMonths()+"월 "+between.getDays()+"일");
}
```
```
period = P10D
nowDate = 2024-04-26
+Period = 2024-05-06
between = P34Y4M5D
34년 4월 5일
```
### 2. Duration: 시, 분, 초(나노초)
```java
public final class Duration
        implements TemporalAmount, Comparable<Duration>, Serializable {
    /**
     * The number of seconds in the duration.
     */
    private final long seconds;
    /**
     * The number of nanoseconds in the duration, expressed as a fraction of the
     * number of seconds. This is always positive, and never exceeds 999,999,999.
     */
    private final int nanos;
```
- 내부 멤버로 seconds와 nanos만 있음. 
  - to로 시작하는 메서드는 seconds를 변환하는 메서드
  - get은 멤버인 데이터를 꺼내는 메서드
- `toHours()`, `toMinutes()`, `getSeconds()`, `getNano()`
```java
public static void main(String[] args) {
    Duration duration = Duration.ofMinutes(30);
    System.out.println("duration = " + duration);

    LocalTime time = LocalTime.of(1, 0, 0, 0);
    System.out.println("time = " + time);
    LocalTime plus30min = time.plus(duration);
    System.out.println("plus30min = " + plus30min);

    LocalTime now = LocalTime.now();
    Duration between = Duration.between(now, plus30min);
    System.out.println("between = " + between);
    System.out.println("분 = "+between.toMinutes());
    System.out.println("초 = " + between.getSeconds());
    System.out.println("시, 분, 초 = "+between.toHours()+"시 "+between.toMinutesPart()+"분 "+between.toSecondsPart()+"초");
}
```
```
duration = PT30M
time = 01:00
plus30min = 01:30
between = PT16H16M52.8770813S
분 = 976
초 = 58612
시, 분, 초 = 16시 16분 52초
```
# III. 날짜와 시간의 핵심 인터페이스 

# IV. 날짜와 시간 데이터 사용하기

# V. 실습문제 