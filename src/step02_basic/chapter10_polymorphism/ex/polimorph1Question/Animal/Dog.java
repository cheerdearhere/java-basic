package step02_basic.chapter10_polymorphism.ex.polimorph1Question.Animal;

import step02_basic.chapter10_polymorphism.ex.polimorph1Question.Animal.Animal;

public class Dog extends Animal {
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}
