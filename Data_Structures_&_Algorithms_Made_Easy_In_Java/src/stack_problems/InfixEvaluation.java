// 5. Infix evaluation with 2 stacks (2 stacks algorithm by Dijkstra)
// n time n space
// We need to provide input in a way that only 2 operands are there in a pair of brackets
// Evaluates fully parenthesized expressions 

package stack_problems;

import java.util.Stack;

public class InfixEvaluation {

	public static void main(String[] args) throws Exception {
		System.out
				.println(InfixEvaluation("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
		System.out.println(InfixEvaluation("(1+((2*3)-7))"));
		System.out.println(InfixEvaluation("(1+(2+3))"));
	}

	private static double InfixEvaluation(String string) throws Exception {
		final char[] chars = string.toCharArray();
		final int length = chars.length;
		final Stack<Double> operands = new Stack<Double>();
		final Stack<Character> operators = new Stack<Character>();

		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ' || chars[i] == '(')
				continue;

			if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*'
					|| chars[i] == '/')
				operators.push(chars[i]);
			else if (chars[i] == ')') {
				double op2 = operands.pop();
				char sign = operators.pop();

				if (sign == '+')
					operands.push(operands.pop() + op2);
				else if (sign == '-')
					operands.push(operands.pop() - op2);
				else if (sign == '*')
					operands.push(operands.pop() * op2);
				else if (sign == '/')
					operands.push(operands.pop() / op2);
				else
					throw new Exception("Unsupported Operation");
			} else
				operands.push((double) Character.getNumericValue(chars[i]));
		}
		return operands.pop();
	}

}
