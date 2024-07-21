package step05_designPatterns.visitor.before_overriding;

public class Triangle implements Shape {
    @Override
    public void printTo(Phone phone){
        System.out.println("print Triangle to phone");
    }
    @Override
    public void printTo(Watch watch){
        System.out.println("print Triangle to watch");
    }
}
