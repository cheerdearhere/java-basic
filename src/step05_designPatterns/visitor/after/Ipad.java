package step05_designPatterns.visitor.after;

public class Ipad implements Device {
    @Override
    public void printTo(Circle circle) {
        System.out.println("print Circle to IPad...");
    }

    @Override
    public void printTo(Rectangle rectangle) {
        System.out.println("print Rectangle to IPad...");
    }

    @Override
    public void printTo(Triangle triangle) {
        System.out.println("print Triangle to IPad...");
    }
}
