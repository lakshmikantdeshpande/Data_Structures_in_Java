// 23. Improve time complexity of problem 22
// n time n space

package stack_problems;

import java.util.Stack;

public class SpanProblem_2 {

    public static void main(String[] args) {
        int spans[] = findSpans(new int[]{6, 3, 4, 5, 2});
        for (int x : spans) {
            System.out.println(x);
        }
    }

    private static int[] findSpans(int[] array) {
        int[] spans = new int[array.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        spans[0] = 1; // span of the first element will always be 1

        for (int i = 1; i < array.length; i++) {
            // keep popping the stack, while stack is not empty and top of
            // the stack is smaller than spans[i]
            while (!stack.empty() && array[stack.peek()] < array[i])
                stack.pop();

            // all the elements to the left are smaller than array[i]
            if (stack.empty())
                spans[i] = i + 1;
            else
                // if stack top is greater than array[i], span is current index
                // - stack index
                spans[i] = i - stack.peek();

            stack.push(i);
        }
        return spans;
    }
}
