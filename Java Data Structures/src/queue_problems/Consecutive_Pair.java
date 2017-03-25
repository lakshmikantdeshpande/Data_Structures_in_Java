// 8. Given a stack of integers, how�d u check if a pair of numbers is consecutive or not. 
// It can be in increasing or decreasing order. If stack has odd number of elements, 
// top will be left out of a pair. 
// n time (n+n+n+n)
// n space

package queue_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Consecutive_Pair {

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(5);
		stack.push(-2);
		stack.push(-3);
		stack.push(11);
		stack.push(10);
		stack.push(5);
		stack.push(6);
		stack.push(20);

		System.out.println(consecutiveCheck(stack));
	}

	private static boolean consecutiveCheck(Stack<Integer> stack) throws Exception {
		if (stack == null)
			throw new Exception("Stack is null");
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean ordered = true;

		while (!stack.empty())
			queue.add(stack.pop());

		while (!queue.isEmpty())
			stack.push(queue.remove());

		while (!stack.isEmpty()) {
			int n = stack.pop();
			queue.add(n);
			if (!stack.isEmpty()) {
				int m = stack.pop();
				queue.add(m);
				if (Math.abs(n - m) != 1)
					ordered = false;
			}
		}
		while (!queue.isEmpty())
			stack.push(queue.remove());
		return ordered;
	}

}
