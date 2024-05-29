package step04_middleClass2.chapter02_CollectionFramework.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStackMain {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        //stack처럼
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);

        System.out.println("deque.peek() = " + deque.peek());
        System.out.println(deque);
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println(deque);
    }
}
