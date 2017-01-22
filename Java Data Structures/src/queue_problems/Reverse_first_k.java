package queue_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_first_k {

	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= 10; i++)
			queue.offer(i);
		System.out.println(queue.toString());

		reverseFirstK(queue, 5);
		System.out.println(queue.toString());
	}

	private static void reverseFirstK(Queue<Integer> queue, int k)
			throws Exception {
		if (queue == null)
			throw new Exception("The queue appears empty!");
		if (k > queue.size() || k <= 0)
			throw new Exception("No. of elements to be reversed is invalid");

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < k; i++)
			stack.push(queue.poll());
		while (!stack.isEmpty())
			queue.offer(stack.pop());
		// size of the elements which don't need to be reversed = queue.size() -
		// k
		for (int i = 0; i < queue.size() - k; i++)
			queue.offer(queue.poll());
	}
}
