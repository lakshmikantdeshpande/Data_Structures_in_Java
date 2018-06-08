// 7. Reduce problem 6's space complexity
// n time 2n space complexity (practically lower than 2n)
// 1 time for getMinimum()

package stack_problems;

import java.util.Stack;

public class MinimumElementStack_2 {
    private static Stack<Integer> stack;
    private static Stack<Integer> minStack;

    public MinimumElementStack_2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static int getMinimum() throws Exception {
        if (minStack.isEmpty())
            throw new Exception("Stack is empty!");
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinimumElementStack_2 mes = new MinimumElementStack_2();
        mes.push(2);
        mes.push(6);
        mes.push(4);
        mes.push(1);
        mes.push(5);

        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
    }

    public void push(int data) {
        stack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek())
            minStack.push(data);
    }

    public int pop() throws Exception {
        if (stack.isEmpty())
            throw new Exception("Underflow");

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

}
