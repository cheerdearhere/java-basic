package step05_designPatterns.visitor.before_overriding;


public interface Shape {
    void printTo(Phone phone);
    void printTo(Watch watch);
}
