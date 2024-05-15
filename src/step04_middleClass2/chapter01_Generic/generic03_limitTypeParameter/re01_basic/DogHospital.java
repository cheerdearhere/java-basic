package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re01_basic;

import step04_middleClass2.chapter01_Generic.animal.Dog;

public class DogHospital {
    private Dog animal;
    public void set(Dog animal){
        this.animal = animal;
    }
    public void checkup(){
        System.out.println("동물 이름: "+animal.getName());
        System.out.println("크기: "+animal.getSize());
        animal.sound();
    }
    public Dog bigger(Dog targetAnimal){
        return animal.getSize() > targetAnimal.getSize() ? animal : targetAnimal;
    }
}
