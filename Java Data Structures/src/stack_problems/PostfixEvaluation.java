// 4. Postfix evaluation
// n time n space

package stack_problems;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) throws Exception {
		System.out.println(EvaluatePostfix("123*+5-"));
		System.out.println(EvaluatePostfix("231*+9-"));
		// System.out.println(EvaluatePostfix(""));
	}

	private static double EvaluatePostfix(String string) throws Exception {
		if (string == null || string == "" || string.equals(""))
			throw new Exception("Invalid Expression!");
		final int length = string.length();
		final Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < length; i++) {
			String str = string.substring(i, i + 1);
			if (str.equals(" "))
				continue;
			if (isNumeric(str))
				stack.push(Double.parseDouble(str));
			else {
				stack.push(eval(stack.pop(), stack.pop(), str));
			}
		}
		return stack.pop();
	}

	private static double eval(double pop, double pop2, String str)
			throws Exception {
		if (str.equals("+"))
			return pop2 + pop;
		else if (str.equals("-"))
			return pop2 - pop;
		else if (str.equals("*"))
			return pop2 * pop;
		else if (str.equals("/")) {
			if (pop == 0)
				throw new Exception("Cannot divide by zero.");
			return pop2 / pop;
		} else
			throw new Exception("Unsupported Operation");
	}

	private static boolean isNumeric(String string) {
		String match = "^[0-9]$";
		if (string.matches(match))
			return true;
		return false;
	}
}
