package step04_middleClass2.chapter02_CollectionFramework.test.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
문제2 - 작업 예약
서비스를 운영중인데, 낮 시간에는 사용자가 많아서 서버에서 무거운 작업을 하기 부담스럽다. 무거운 작업을 예
약해두고 사용자가 없는 새벽에 실행하도록 개발해보자.
다양한 무거운 작업을 새벽에 실행한다고 가정하자.
작업은 자유롭게 구현하고 자유롭게 예약할 수 있어야 한다.
다음 예제 코드와 실행 결과를 참고해서 TaskScheduler 클래스를 완성하자.
문제 설명
package collection.deque.test.queue;
public interface Task {
 void execute();
}

package collection.deque.test.queue;
public class CompressionTask implements Task {
 @Override
 public void execute() {
 System.out.println("데이터 압축...");
 }
}

package collection.deque.test.queue;
public class BackupTask implements Task {
 @Override
 public void execute() {
 System.out.println("자료 백업...");
 }
}

package collection.deque.test.queue;
public class CleanTask implements Task {
 @Override
 public void execute() {
 System.out.println("사용하지 않는 자원 정리...");
 }
}

package collection.deque.test.queue;
public class SchedulerTest {
 public static void main(String[] args) {
 //낮에 작업을 저장
 TaskScheduler scheduler = new TaskScheduler();
 scheduler.addTask(new CompressionTask());
 scheduler.addTask(new BackupTask());
 scheduler.addTask(new CleanTask());
 //새벽 시간에 실행
 System.out.println("작업 시작");
 run(scheduler);
 System.out.println("작업 완료");
 }
 private static void run(TaskScheduler scheduler) {
 while (scheduler.getRemainingTasks() > 0) {
 scheduler.processNextTask();
 }
 }
}

실행 결과
==작업 시작==
데이터 압축...
자료 백업...
사용하지 않는 자원 정리...
==작업 완료==

TaskScheduler - 코드 작성
package collection.deque.test.queue;
import java.util.ArrayDeque;
import java.util.Queue;
public class TaskScheduler {
 private Queue<Task> tasks = new ArrayDeque<>();
 // 코드 작성
}

 */
public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();
    public void addTask(Task task) {
        tasks.offer(task);
    }
    public int getRemainingTasks() {
        return tasks.size();
    }
    public void processNextTask(){
        Task task = tasks.poll();
        if(task != null){
            task.execute();
        }
    }
}
