package step04_middleClass2.chapter02_CollectionFramework.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeMain {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
//        Deque<Integer> deque = new LinkedList<>();

        //데이터 추가
        deque.addFirst(1);
        System.out.println(deque);
        deque.addFirst(2);
        System.out.println(deque);
        deque.addLast(3);
        System.out.println(deque);
        deque.addLast(4);
        System.out.println(deque);

        //데이터 확인
        System.out.println("deque.peek() = " + deque.peek());
        System.out.println(deque);
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        System.out.println("deque.peekLast() = " + deque.peekLast());

        //데이터 출력
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println(deque);
        System.out.println("deque.pollLast() = " + deque.pollLast());
        System.out.println(deque);
        deque.clear();
        System.out.println(deque);
    }
}
