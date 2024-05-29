package step04_middleClass2.chapter02_CollectionFramework.test.stack_queue;

public class CleanTask implements Task {
    @Override
    public void execute() {
        System.out.println("사용하지 않는 자원 정리...");
    }
}
