package step05_designPatterns.factoryMethod.ex01_usePattern;

public class BlackshipFactory extends DefaultShipFactory{

    @Override
    public Ship createShip() {
        return new BlackShip();
    }

}
