package step06_advanced1_multiThread_and_concurrency.chapter01_processAndThread.util;

public class MyLoggerMain {
    public static void main(String[] args) {
        MyLogger.log("hello MyLogger");
        MyLogger.log(123);
        MyLogger.log(1.23f);
        MyLogger.log(null);
    }
}
