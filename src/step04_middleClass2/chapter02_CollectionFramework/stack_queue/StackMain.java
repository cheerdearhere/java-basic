package step04_middleClass2.chapter02_CollectionFramework.stack_queue;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args){
        //생성
        Stack<Integer> stack = new Stack<>();
        //입력
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        //출력
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);
        // 다음 꺼낼 요소 조회: 제거되지는 않음
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println(stack);
    }
}
