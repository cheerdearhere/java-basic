package step03_middleClass.chapter01_Object.objectClass02;

public class Car {
    private String carName;
    private int age;
    private String moving;
    public Car (String catName,int age){
        this.carName =catName;
        this.age=age;
        moving = "자동차 이동";
    }
    public void move(){
        System.out.println("자동차 이동");
    }
    //오버라이딩 안함
}
