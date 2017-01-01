package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Two_Stacks_Problem {

	public static void main(String[] args) throws Exception {
		Stack<Integer> parantheses = new Stack<Integer>(), numbers = new Stack<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if (input == null)
			return;
		int i = 0, len = input.length();
		if (len == 0)
			return;
		while (i != len && parantheses.size() > 0 && numbers.size() > 0) {
				
		}
	}

}
