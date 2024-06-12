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


    }
}
