package step04_middleClass2.chapter02_CollectionFramework.test.stack_queue;

public class BackupTask implements Task {
    @Override
    public void execute() {
        System.out.println("자료 백업...");
    }
}
