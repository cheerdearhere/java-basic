package step06_advanced1_multiThread_and_concurrency.chapter01_processAndThread.thread.start;

public class HelloRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + ":run()");
    }
}