package step03_middleClass.chapter07_InnerClass;

public class NestedOuterMain {
    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("Nested Class: "+nested.getClass());
    }
}
