package step02_basic.chapter10_2_abstract.abstract1;

abstract class AnimalInterface {
    public abstract void sound();//추상 메서드
    public void move(){//추상클래스에도 일반 메서드를 선언할수 있다
        System.out.println("동물이 이동합니다.");
    }
}
