package stack_problems;

import java.util.Stack;

public class SpanProblem_2 {

	public static void main(String[] args) {
		int spans[] = findSpans(new int[] { 6, 3, 4, 5, 2 });
		for (int x : spans) {
			System.out.println(x);
		}
	}

	private static int[] findSpans(int[] array) {
		int[] spans = new int[array.length];

		Stack<Integer> stack = new Stack<Integer>();
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			while (!stack.isEmpty() && array[i] > array[(Integer) stack.pop()])
				stack.pop();

			if (stack.isEmpty())
				k = -1;
			else
				k = (Integer) stack.pop();

			spans[i] = i - k;
			stack.push(i);
		}
		return spans;
	}
}
