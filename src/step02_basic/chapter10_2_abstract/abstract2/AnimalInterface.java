package step02_basic.chapter10_2_abstract.abstract2;

public interface AnimalInterface {
    void sound();
    void move();

    //예외적으로 default method 사용가능(java8)
    default void soundTest(){
        System.out.println("동물 소리 테스트 시작");
        sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
