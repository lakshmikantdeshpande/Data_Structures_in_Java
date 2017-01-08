// 11. Reverse a stack using only push() & pop()?
// n*n time, n+n space for recursive stack

package stack_problems;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.toString());
		reverseStack(stack);
		System.out.println(stack.toString());
	}

	private static void reverseStack(Stack<Integer> stack) {
		if (stack.empty())
			return;
		int data = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, data);
	}

	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if (stack.empty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}

}
