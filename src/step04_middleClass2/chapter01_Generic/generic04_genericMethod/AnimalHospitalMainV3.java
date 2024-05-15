package step04_middleClass2.chapter01_Generic.generic04_genericMethod;

import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;
import step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re04_typeParam.AnimalHospitalV2;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냥냥이1", 300);
        
        // 강아지 병원
        AnimalMethod.checkup(dog);
        // 고양이 병원
        AnimalMethod.checkup(cat);
        //타입 반환
        Dog biggerDog = AnimalMethod.bigger(dog, new Dog("비교개",50));
        System.out.println("bigger dog: "+biggerDog);
        Cat biggerCat = AnimalMethod.bigger(cat, new Cat("비교양이",50));
        System.out.println("bigger cat = " + biggerCat);
    }
}
