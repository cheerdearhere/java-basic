package step03_middleClass.chapter01_Object.objectClass01;

public class Child extends Parents{
    public void childMethod(){
        System.out.println("Child.childMethod");
        parentMethod();
    }
}
