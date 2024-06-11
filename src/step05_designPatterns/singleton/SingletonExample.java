package step05_designPatterns.singleton;

public class SingletonExample {
    public static void main(String[] args) {
        //java
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.printf(String.valueOf(runtime.freeMemory()));
    }
}
