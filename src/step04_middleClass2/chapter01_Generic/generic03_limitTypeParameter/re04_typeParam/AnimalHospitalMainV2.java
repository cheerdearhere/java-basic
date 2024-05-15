package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re04_typeParam;

import step04_middleClass2.chapter01_Generic.animal.Animal;
import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;
import step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re02_polymorphism.AnimalHospitalV0;

public class AnimalHospitalMainV2 {
    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냥냥이1", 300);
        
        // 강아지 병원
        dogHospital.set(dog);
        dogHospital.checkup();
        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();
        
        //다른 타입 불가
//        catHospital.set(dog);
//        dogHospital.set(cat);

        //타입 반환 - 형변환 불필요
        Dog biggerDog = dogHospital.bigger(new Dog("비교개",50));
        System.out.println(biggerDog);
    }
}
