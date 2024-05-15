package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re01_basic;

import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

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

        //타입 반환
        Dog biggerDog = dogHospital.bigger(new Dog("비교개",50));
        System.out.println(biggerDog);
    }
}
