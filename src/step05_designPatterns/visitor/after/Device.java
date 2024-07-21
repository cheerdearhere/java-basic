package step05_designPatterns.visitor.after;

public interface Device {
    void printTo(Circle circle);
    void printTo(Rectangle rectangle);
    void printTo(Triangle triangle);
}
