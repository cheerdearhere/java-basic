package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re01_basic;

import step04_middleClass2.chapter01_Generic.animal.Cat;

public class CatHospital {
    private Cat animal;
    public void set(Cat animal){
        this.animal = animal;
    }
    public void checkup(){
        System.out.println("동물 이름: "+animal.getName());
        System.out.println("크기: "+animal.getSize());
        animal.sound();
    }
    public Cat bigger(Cat targetAnimal){
        return animal.getSize() > targetAnimal.getSize() ? animal : targetAnimal;
    }
}
