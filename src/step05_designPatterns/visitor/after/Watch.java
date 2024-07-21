package step05_designPatterns.visitor.after;

public class Watch implements Device {
    @Override
    public void printTo(Circle circle) {
        System.out.println("print Circle to Watch");
    }

    @Override
    public void printTo(Rectangle rectangle) {
        System.out.println("print Rectangle to Watch");
    }

    @Override
    public void printTo(Triangle triangle) {
        System.out.println("print Triangle to Watch...");
    }
}
