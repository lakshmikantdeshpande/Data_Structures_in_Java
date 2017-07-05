// 3. Implement a stack using 2 queues
// 1 time push
// n time pop worse
// 1 time pop best
// n space

package queue_problems;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
    private Queue<Integer> queue1, queue2;

    public StackUsing2Queues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public static void main(String[] args) throws Exception {
        StackUsing2Queues su = new StackUsing2Queues();
        su.push(1);
        su.push(2);
        su.push(3);
        System.out.println(su.pop());
        System.out.println(su.pop());
        System.out.println(su.pop());
    }

    public synchronized void push(int data) {
        if (queue1.isEmpty())
            queue2.offer(data);
        else
            queue1.offer(data);
    }

    public synchronized int pop() throws Exception {
        int i = 0, size;
        if (queue2.isEmpty() && queue1.isEmpty())
            throw new Exception("Stack is empty");
        else if (queue2.isEmpty()) {
            size = queue1.size();
            while (i < size - 1) {
                queue2.offer(queue1.poll());
                i++;
            }
            return queue1.poll();
        } else {
            size = queue2.size();
            while (i < size - 1) {
                queue1.offer(queue2.poll());
                i++;
            }
            return queue2.poll();
        }
    }

}
