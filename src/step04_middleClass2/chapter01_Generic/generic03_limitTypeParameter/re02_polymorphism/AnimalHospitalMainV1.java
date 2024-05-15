package step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re02_polymorphism;

import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;
import step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re01_basic.CatHospital;
import step04_middleClass2.chapter01_Generic.generic03_limitTypeParameter.re01_basic.DogHospital;

public class AnimalHospitalMainV1 {
    public static void main(String[] args) {
        AnimalHospitalV0 dogHospital = new AnimalHospitalV0();
        AnimalHospitalV0 catHospital = new AnimalHospitalV0();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냥냥이1", 300);
        
        // 강아지 병원
        dogHospital.set(dog);
        dogHospital.checkup();
        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();
        
        //다른 타입 가능 => 타입안정성 위협
        catHospital.set(dog); //인자를 받은 매개변수에서 체크 실패 :
        dogHospital.set(cat);

        //타입 반환 - 형변환 필요
        dogHospital.set(dog);
        Dog biggerDog = (Dog)dogHospital.bigger(new Dog("비교개",50));
        System.out.println(biggerDog);
    }
}
