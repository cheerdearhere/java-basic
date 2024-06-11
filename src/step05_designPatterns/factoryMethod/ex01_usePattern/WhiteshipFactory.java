package step05_designPatterns.factoryMethod.ex01_usePattern;

public class WhiteshipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }

}
