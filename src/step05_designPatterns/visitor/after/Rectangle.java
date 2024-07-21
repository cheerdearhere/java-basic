package step05_designPatterns.visitor.after;

public class Rectangle  implements Shape {
    @Override
    public void accept(Device device) {
        device.printTo(this);
    }
}
