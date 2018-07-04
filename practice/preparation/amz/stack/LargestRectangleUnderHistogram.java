package amz.stack;

import java.util.Stack;

public class LargestRectangleUnderHistogram {

    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        System.out.println(getMaxArea(new int[]{3, 2, 5, 6, 1, 4, 4}));
    }

    private static int getMaxArea(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < array.length) {
            if (stack.isEmpty() || array[stack.peek()] <= array[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            maxArea = Math.max(maxArea, array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return maxArea;
    }

}
