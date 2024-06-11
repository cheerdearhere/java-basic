package step05_designPatterns.factoryMethod.ex01_usePattern;

public class WhiteShip extends Ship {

    public WhiteShip() {
        //if문으로 처리하던 것들을 구현체 내부로
        setName("White Ship");
        setLogo("\uD83D\uDEE5");
        setColor("white");

    }
}
