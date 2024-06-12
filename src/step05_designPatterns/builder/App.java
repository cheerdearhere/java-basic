package step05_designPatterns.builder;

import step05_designPatterns.builder.after.DefaultTourBuilder;
import step05_designPatterns.builder.after.TourDirector;
import step05_designPatterns.builder.after.TourPlanBuilder;
import step05_designPatterns.builder.before.TourPlan;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        TourPlan tourPlan = new TourPlan();
        tourPlan.setTitle("오키나와 여행");
        tourPlan.setNights(2);
        tourPlan.setDays(3);
        tourPlan.setStartDate(LocalDate.of(2022,12,31));
        tourPlan.setWhereToStay("sam 리조트");
        tourPlan.addPlan(0,"체크인");
        tourPlan.addPlan(0,"저녁식사");
        tourPlan.addPlan(0,"야시장");
        tourPlan.addPlan(1,"조식뷔페");
        tourPlan.addPlan(1,"해변가 산책");
        tourPlan.addPlan(1,"점심 식당");
        tourPlan.addPlan(1,"리조트 수영장");
        tourPlan.addPlan(1,"저녁 BBQ 식당");
        tourPlan.addPlan(2,"조식뷔페");
        tourPlan.addPlan(2,"체크아웃");
        tourPlan.addPlan(2,"공항");
        System.out.println(tourPlan);

        TourPlan shortTrip = new TourPlan();
        shortTrip.setTitle("당일치기");
        shortTrip.setStartDate(LocalDate.of(2022,7,20));
        shortTrip.addPlan(1,"점심 식당");
        shortTrip.addPlan(1,"리조트 수영장");
        shortTrip.addPlan(1,"저녁 BBQ 식당");
        System.out.println(shortTrip);


        TourPlanBuilder builder = new DefaultTourBuilder();
        TourPlan plan = builder
                .newInstance()
                .title("오키나와 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 7, 20))
                .whereToStay("s호텔")
                .addPlan(0, "저녁식사")
                .addPlan(0, "야시장")
                .addPlan(1, "조식뷔페")
                .addPlan(1, "해변가 산책")
                .addPlan(1, "점심 식당")
                .addPlan(1, "리조트 수영장")
                .addPlan(1, "저녁 BBQ 식당")
                .addPlan(2, "조식뷔페")
                .addPlan(2, "체크아웃")
                .addPlan(2, "공항")
                .getPlan();
        System.out.println(plan);
        builder = new DefaultTourBuilder();
        TourPlan plan2 = builder
                .newInstance()
                .title("짧은 여행")
                .startDate(LocalDate.of(2022,7,20))
                .addPlan(1,"점심 식당")
                .addPlan(1,"리조트 수영장")
                .addPlan(1,"저녁 BBQ 식당")
                .getPlan();
        System.out.println(plan2);

        TourDirector director = new TourDirector(new DefaultTourBuilder());
        System.out.println(director.okinawaTrip());
        director = new TourDirector(new DefaultTourBuilder());
        System.out.println(director.shortTrip());
    }
}
