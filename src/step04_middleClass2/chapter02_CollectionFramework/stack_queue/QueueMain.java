package step04_middleClass2.chapter02_CollectionFramework.stack_queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(); //LinkedList<Integer>();도 가능
        //입력
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        //출력
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println(queue);
        // 다음 꺼낼 요소 조회: 제거되지는 않음
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println(queue);
    }
}
