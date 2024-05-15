package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re04_typeParam;

import step04_middleClass2.chapter01_Generic.animal.Animal;

public class AnimalHospitalV2<T extends Animal> {
    private T animal;
    public void set(T animal){
        this.animal = animal;
    }
    public void checkup(){
        System.out.println("동물 이름: "+animal.getName());
        System.out.println("크기: "+animal.getSize());
        animal.sound();
    }
    public T bigger(T targetAnimal){
        return animal.getSize() > targetAnimal.getSize() ? animal : targetAnimal;
    }
}
