package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re03_genericFail;

import step04_middleClass2.chapter01_Generic.animal.Animal;

public class AnimalHospitalV1<T> {
    private T animal;
    public void set(T animal){
        this.animal = animal;
    }
    public void checkup(){
//        System.out.println("동물 이름: "+animal.getName());
//        System.out.println("크기: "+animal.getSize());
//        animal.sound();
    }
    public T bigger(T targetAnimal){
//        return animal.getSize() > targetAnimal.getSize() ? animal : targetAnimal;
        return null;
    }

    public static void main(String[] args) {
        // Animal 외 다른 타입도 타입 매개변수에 쓸 수 있음
        AnimalHospitalV1<Integer> integerAnimalHospitalV0 = new AnimalHospitalV1<>();
        AnimalHospitalV1<Double> doubleAnimalHospitalV0 = new AnimalHospitalV1<>();
    }
}
