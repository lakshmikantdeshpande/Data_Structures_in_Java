// 9. Given a  queue 1 2 3 4 5 6 7 8 9 10, 
// Output should be  1 6 2 7 3 8 4 9 5 10.
// n time (n+n+n+n+n)
// n space

package queue_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interleaved_Half_Queue {

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= 10; i++)
            queue.offer(i);
        System.out.println(queue.toString());

        interleaved(queue);
        System.out.println(queue.toString());
    }

    private static void interleaved(Queue<Integer> queue) throws Exception {
        if (queue == null)
            throw new Exception("Null queue");
        if (queue.size() % 2 != 0)
            throw new Exception("Odd sized queue");

        Stack<Integer> stack = new Stack<Integer>();
        int mid = queue.size() / 2;

        for (int i = 0; i < mid; i++)
            stack.push(queue.remove());
        for (int i = 0; i < mid; i++)
            queue.add(stack.pop());
        for (int i = 0; i < mid; i++)
            queue.add(queue.remove());
        for (int i = 0; i < mid; i++)
            stack.push(queue.remove());
        for (int i = 0; i < mid; i++) {
            queue.add(stack.pop());
            queue.add(queue.remove());
        }
    }

}
