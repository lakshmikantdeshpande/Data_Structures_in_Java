package stack;

import java.util.Stack;

public class LargestHistogram {

    public static void main(String[] args) {
        int[] array = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestAreaUnderHistogram(array));
    }

    private static int largestAreaUnderHistogram(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = 0; i < array.length;) {
            if (stack.isEmpty() || array[stack.peek()] <= array[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, array[top] * i);
                } else {
                    maxArea = Math.max(maxArea, array[top] * (i - stack.peek() - 1));
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, array[top] * i);
            } else {
                maxArea = Math.max(maxArea, array[top] * (i - stack.peek() - 1));
            }
        }

        return maxArea;
    }

}
