package step03_middleClass.chapter07_InnerClass.innerClass.ex_before_refactoring;

public class Car {
    private int chargeLevel;
    private String model;
    private Engine engine;

    public Car(String model,int chargeLevel){
        this.chargeLevel = chargeLevel;
        this.model = model;
        this.engine = new Engine(this);
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public String getModel() {
        return model;
    }
    public void start(){
        engine.start();
        System.out.println(model+" 시작 완료");
    }
}
