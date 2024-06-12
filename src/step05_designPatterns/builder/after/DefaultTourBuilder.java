package step05_designPatterns.builder.after;

import step05_designPatterns.builder.DetailPlan;
import step05_designPatterns.builder.before.TourPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourBuilder implements TourPlanBuilder{

    //this로 접근하는 경우
//    private String title;
//    private int nights;
//    private int days;
//    private LocalDate startDate;
//    private String whereToStay;
//    private List<DetailPlan> plans;

    //좀더 편하게
    private TourPlan plan;
    @Override
    public TourPlanBuilder newInstance(){
        plan = new TourPlan();
        return this;
    }

    @Override
    public TourPlanBuilder title(String title) {
//        this.title = title;
        this.plan.setTitle(title);
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
//        this.nights = nights;
//        this.days = days;
        this.plan.setNights(nights);
        this.plan.setDays(days);
        return this;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate startDate) {
//        this.startDate = startDate;
        this.plan.setStartDate(startDate);
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
//        this.whereToStay = whereToStay;
        this.plan.setWhereToStay(whereToStay);
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
//        if(this.plans == null)
//            this.plans = new ArrayList<>();
//        this.plans.add(new DetailPlan(day, plan));
        this.plan.addPlan(day, plan);
        return this;
    }

    @Override
    public TourPlan getPlan() {
//        return new TourPlan(title, nights, days, startDate, whereToStay, plans);
        return plan;
    }
}
