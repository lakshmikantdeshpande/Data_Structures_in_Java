package amz.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    private void push(int data) {
        queue1.offer(data);
    }

    private Integer pop() {
        if (queue2.isEmpty() && queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        if (queue1.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
