package amz.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int[] stockPrices = new int[]{1, 2, 3, 3, 2, 1, 4};
        System.out.println(Arrays.toString(findStockSpanBruteForce(stockPrices)));
        System.out.println(Arrays.toString(findStockSpanOptimal(stockPrices)));
    }

    private static int[] findStockSpanBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        final int n = array.length;
        int[] spans = new int[n];
        spans[0] = 1;

        for (int i = 1; i < n; i++) {
            spans[i] = 1;

            for (int j = i - 1; j >= 0 && (array[i] >= array[j]); j--) {
                spans[i]++;
            }
        }
        return spans;
    }

    private static int[] findStockSpanOptimal(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] spans = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        spans[0] = 1;

        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] <= array[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return spans;
    }

}
