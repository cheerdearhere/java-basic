package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re02_polymorphism;

import step04_middleClass2.chapter01_Generic.animal.Animal;

public class AnimalHospitalV0 {
    private Animal animal;
    public void set(Animal animal){
        this.animal = animal;
    }
    public void checkup(){
        System.out.println("동물 이름: "+animal.getName());
        System.out.println("크기: "+animal.getSize());
        animal.sound();
    }
    public Animal bigger(Animal targetAnimal){
        return animal.getSize() > targetAnimal.getSize() ? animal : targetAnimal;
    }
}
