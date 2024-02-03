package step02_basic.chapter07_virtalMachine.ex.javaMemory1Question;

public class Car {
    private String carName;
    private static int carsNum;

    public Car(String carName){
        this.carName=carName;
        carsNum++;
        System.out.println("차량 구입, 이름: "+carName);
    }
    public static void showTotalCars(){
        System.out.println("구매한 차량 수: "+carsNum);
    }
}
