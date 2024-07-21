package step05_designPatterns.visitor.after;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        rectangle.accept(new Phone());
        triangle.accept(new Watch());
        //기기가 추가되도 변경 없음
        Shape circle = new Circle();
        circle.accept(new Ipad());
    }
}
