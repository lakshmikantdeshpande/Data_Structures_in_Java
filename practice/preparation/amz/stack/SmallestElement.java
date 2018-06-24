package amz.stack;

import java.util.Stack;

public class SmallestElement {

    private static class AuxNSpaceStack {
        private static Stack<Integer> stack = new Stack<>();
        private static Stack<Integer> auxStack = new Stack<>();

        private static void push(int data) {
            stack.push(data);

            if (auxStack.isEmpty()) {
                auxStack.push(data);
            } else {
                auxStack.push(Math.min(data, auxStack.peek()));
            }
        }

        private static int pop() {
            auxStack.pop();
            return stack.pop();
        }

        private static int min() {
            return auxStack.peek();
        }
    }

    private static class AuxLessSpaceStack {
        private static Stack<Integer> stack = new Stack<>();
        private static Stack<Integer> auxStack = new Stack<>();

        private static void push(int data) {
            stack.push(data);

            if (auxStack.isEmpty()) {
                auxStack.push(data);
            } else {
                if (data <= min()) {
                    auxStack.push(data);
                }
            }
        }

        private static int pop() {
            int temp = stack.pop();
            if (min() == temp) {
                auxStack.pop();
            }
            return temp;
        }

        private static int min() {
            return auxStack.peek();
        }
    }

    public static void main(String[] args) {
        AuxNSpaceStack.push(1);
        AuxNSpaceStack.push(2);
        AuxNSpaceStack.push(3);
        AuxNSpaceStack.push(-1);
        System.out.println(AuxNSpaceStack.min());
        AuxNSpaceStack.pop();
        System.out.println(AuxNSpaceStack.min());

        AuxLessSpaceStack.push(1);
        AuxLessSpaceStack.push(2);
        AuxLessSpaceStack.push(3);
        AuxLessSpaceStack.push(-1);
        System.out.println(AuxLessSpaceStack.min());
        AuxLessSpaceStack.pop();
        System.out.println(AuxLessSpaceStack.min());
    }

}
