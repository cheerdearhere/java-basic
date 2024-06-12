package step05_designPatterns.abstractFactory.after;

import step05_designPatterns.abstractFactory.after.newParts.WhiteshipPartProFactory;

public class ShipInventory {
    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteshipFactory(new WhiteshipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());

        shipFactory = new WhiteshipFactory(new WhiteshipPartProFactory());
        ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
