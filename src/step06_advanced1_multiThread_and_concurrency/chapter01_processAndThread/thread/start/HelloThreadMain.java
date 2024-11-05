package step06_advanced1_multiThread_and_concurrency.chapter01_processAndThread.thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName()+": start() 호출 전");
        helloThread.start();
//        helloThread.run(); run을 직접 호출하는 것은 보안상 취약점
        System.out.println(Thread.currentThread().getName()+": start() 호출 후");

        System.out.println(Thread.currentThread().getName()+": main() end");
    }
}
