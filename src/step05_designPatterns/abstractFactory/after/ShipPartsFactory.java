package step05_designPatterns.abstractFactory.after;

public interface ShipPartsFactory {
    Anchor createAnchor();
    Wheel createWheel();
}
