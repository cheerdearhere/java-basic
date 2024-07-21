package step05_designPatterns.visitor.before;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        rectangle.printTo(new Phone());
        triangle.printTo(new Watch());
    }
}
