package hr_Solution;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			Stack<Character> stack = new Stack<Character>();
			String x = in.next();
			final int len = x.length();
			boolean flag = false;

			for (int i = 0; i < len; i++) {
				char c = x.charAt(i);
				if (c == '{' || c == '[' || c == '(')
					stack.push(c);
				else if (!stack.empty()) {
					if (doPopping(stack, c))
						continue;
					else {
						System.out.println("NO");
						flag = true;
						break;
					}
				} else {
					System.out.println("NO");
					flag = true;
					break;
				}
			}

			if (!flag) {
				if (!stack.empty())
					System.out.println("NO");
				else
					System.out.println("YES");
			}
		}
		in = null;
		System.gc();
	}

	public static boolean doPopping(Stack<Character> stack, char c) {
		if (stack.empty())
			return false;
		char p = stack.pop();

		switch (c) {
		case '}':
			if (p == '{')
				;
			else
				return false;
			break;
		case ')':
			if (p == '(')
				;
			else
				return false;
			break;
		case ']':
			if (p == '[')
				;
			else
				return false;
			break;
		default:
			return false;
		}
		return true;
	}
}
