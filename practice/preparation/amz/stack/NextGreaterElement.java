package amz.stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] array = {11, 13, 21, 3, 8, 4, 3, 2, 9};
        nextGreaterElements(array);
    }

    private static void nextGreaterElements(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        final int n = array.length;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                System.out.printf("%ds next greater element is %d%n", stack.pop(), array[i]);
            }
            stack.push(array[i]);
        }

    }

}
