package step03_middleClass.chapter07_InnerClass.innerClass.ex_after_refactoring;

public class Car {
    private int chargeLevel;
    private String model;
    private Engine engine;

    public Car(String model, int chargeLevel){
        this.chargeLevel = chargeLevel;
        this.model = model;
        this.engine = new Engine();
    }
    public void start(){
        engine.start();
        System.out.println(model+" 시작 완료");
    }

    private class Engine{
        public void start(){
            System.out.println("충전 레벨 확인: "+chargeLevel);
            System.out.println(model+" - 엔진을 구동합니다.");
        }
    }
}
