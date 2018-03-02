package stack;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(10 - i);
        }
        System.out.println(stack);
        System.out.println(sortStack(stack));
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            throw new RuntimeException("Stack is null / empty");
        }

        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            while (!temp.isEmpty() && temp.peek() > popped) {
                stack.push(temp.pop());
            }
            temp.push(popped);
        }
        return temp;
    }

}