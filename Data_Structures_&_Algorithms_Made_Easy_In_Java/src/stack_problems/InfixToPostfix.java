// 2. Infix to postfix using stack
// n time n space

package stack_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(InfixtoPostFix("A*B-(C+D)+E"));
		System.out.println(InfixtoPostFix("(A + B) * (C + D)"));
		System.out.println(InfixtoPostFix("A * B + C * D"));
		System.out.println(InfixtoPostFix("A + B + C + D"));
		System.out.println(InfixtoPostFix("A + B * C + D"));

	}

	private static String InfixtoPostFix(String string) {
		if (string == null || string.equals("") || string.equals(" "))
			return "";

		final StringBuilder output = new StringBuilder();
		final Stack<Character> stack = new Stack<Character>();
		final Map<Character, Integer> precedenceTable = new HashMap<Character, Integer>();
		precedenceTable.put('+', 1);
		precedenceTable.put('-', 1);
		precedenceTable.put('*', 2);
		precedenceTable.put('/', 2);
		precedenceTable.put('^', 3);

		final int length = string.length();
		char c;

		for (int i = 0; i < length; i++) {
			c = string.charAt(i);
			if (c == ' ')
				continue;

			if (isAlphaNumeric(c))
				output.append(c);
			else if (c == '(')
				stack.push(c);
			else if (c == ')')
				while (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
						break;
					} else {
						output.append(stack.pop());
					}
				}
			else {
				while (!stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
						break;
					} else if (lowPrecedence(precedenceTable, stack, c))
						output.append(stack.pop());
					else
						// higher precedence character
						break;
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty())
			output.append(stack.pop());

		return output.toString();
	}

	// returns true if upcoming character has same or lower precedence than
	// stack
	// character
	private static boolean lowPrecedence(Map<Character, Integer> map,
			Stack<Character> stack, char c) {
		return map.get(c) <= map.get(stack.peek());
		/*
		 * FOR DEBUGGING if (map.get(c) == null || map.get(stack.peek()) ==
		 * null) { System.out.println(c + " -> " + map.get(c));
		 * System.out.println(stack.peek() + " -> " + map.get(stack.peek()));
		 * return false; }
		 */
	}

	private static boolean isAlphaNumeric(char c) {
		String match = "^[a-zA-Z0-9]*$";
		if ((c + "").matches(match))
			return true;
		return false;
	}

}
