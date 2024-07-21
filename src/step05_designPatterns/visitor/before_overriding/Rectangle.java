package step05_designPatterns.visitor.before_overriding;

public class Rectangle  implements Shape {
    @Override
    public void printTo(Phone phone){
        System.out.println("print Rectangle to phone");
    }
    @Override
    public void printTo(Watch watch){
        System.out.println("print Rectangle to watch");
    }
}
