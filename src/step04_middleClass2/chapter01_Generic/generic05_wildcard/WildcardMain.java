package step04_middleClass2.chapter01_Generic.generic05_wildcard;

import step04_middleClass2.chapter01_Generic.animal.Animal;
import step04_middleClass2.chapter01_Generic.animal.Cat;
import step04_middleClass2.chapter01_Generic.animal.Dog;

public class WildcardMain {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이",100));
        catBox.set(new Cat("냥",50));
        Wildcard.<Dog>printGeneric(dogBox);
        Wildcard.printGeneric(catBox);
//        Wildcard.<Dog>printGeneric(catBox);
//        Wildcard.printAnimal(objBox);

        Wildcard.printUptoAnimal(dogBox);
        Wildcard.<Cat>printUptoAnimal(catBox);
//        Wildcard.printUptoAnimal(objBox);

        Dog returnDog = Wildcard.<Dog>printAndReturnGeneric(dogBox);
        Cat returnCat = Wildcard.printAndReturnGeneric(catBox);

        //와일드카드 사용
        Wildcard.<Object>printWildcard(objBox);
        Wildcard.printWildcard(dogBox);
        Wildcard.<Cat>printWildcard(catBox);

        Dog wildcardDog = (Dog) Wildcard.<Dog>printAndReturnWildcard(dogBox);
//        Dog wildcardDog2 = (Dog) Wildcard.<Dog>printAndReturnWildcard(catBox);
        Cat wildcardCat = (Cat) Wildcard.printAndReturnWildcard(catBox);
        
        //하한 와일드카드
        //<? super Animal>
        Wildcard.writeBox(objBox);
        Wildcard.writeBox(animalBox);
//        Wildcard.writeBox(dogBox);
//        Wildcard.writeBox(catBox);
    }
}
