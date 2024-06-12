package step05_designPatterns.abstractFactory.after.newParts;

import step05_designPatterns.abstractFactory.after.Anchor;
import step05_designPatterns.abstractFactory.after.ShipPartsFactory;
import step05_designPatterns.abstractFactory.after.Wheel;

public class WhiteshipPartProFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchorPro();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheelPro();
    }
}
