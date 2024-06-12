package step05_designPatterns.builder.after;

import step05_designPatterns.builder.before.TourPlan;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;;
    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }
    //미리 세팅 후 처리
    public TourPlan okinawaTrip(){
        return tourPlanBuilder
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
    }
    public TourPlan shortTrip(){
        return tourPlanBuilder
                .newInstance()
                .title("짧은 여행")
                .startDate(LocalDate.of(2022,7,20))
                .addPlan(1,"점심 식당")
                .addPlan(1,"리조트 수영장")
                .addPlan(1,"저녁 BBQ 식당")
                .getPlan();
    }
}