package stack_problems;


public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(InfixtoPostFix("A*B-(C+D)+E"));		
	}

	private static String InfixtoPostFix(String string) {
		if (string == null || string.equals("") || string.equals(" ")) 
			return ""; 
		Stack<Character> stack = new Stack<Character>();
		
	}

}
