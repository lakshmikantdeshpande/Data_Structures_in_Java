// 2. Implement a queue using 2 stacks
// dequeue n time worse 1 best
// enqueue 1 time
// n space

package queue_problems;

import java.util.Stack;

public class QueueUsing2Stacks {
    private Stack<Integer> stack1, stack2;

    public QueueUsing2Stacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public static void main(String[] args) throws Exception {
        QueueUsing2Stacks quts = new QueueUsing2Stacks();
        quts.enQueue(1);
        quts.enQueue(2);
        System.out.println(quts.deQueue());
        quts.enQueue(6);
        System.out.println(quts.deQueue());
        System.out.println(quts.deQueue());
    }

    public synchronized void enQueue(int data) {
        stack1.push(data);
    }

    // Micro Optimization
    public synchronized int deQueue() throws Exception {
        if (stack2.empty()) {
            if (stack1.empty())
                throw new Exception("Empty Queue");
            // while (!S1.empty())
            while (stack1.size() > 1)
                stack2.push(stack1.pop());
        }
        // return S2.pop();
        return stack1.pop();
    }

}
