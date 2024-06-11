package step05_designPatterns.singleton.ex;

public class RuntimeExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.printf(String.valueOf(runtime.freeMemory()));
    }
}
