// 18. Create an empty stack of integers.
// 'S' should indicate push and 'X' should indicate a pop. 
// Is it possible to create 325641 & 154623 by just pushing and popping 1, 2, 3, 4, 5, 6 in this order only?
// n*n time (better than n*n that though)  n space 

package stack_problems;

import java.util.Stack;

public class StackString {
    public static final int MAX = 6;

    public static String StringFromStacks(String num) {
        if (num == null || num.equals("") || num.equals(" "))
            return "NOT POSSIBLE";

        final StringBuilder sb = new StringBuilder();

        final Stack<Integer> s1 = new Stack<Integer>();
        final Stack<Integer> s2 = new Stack<Integer>();

        initialize(s2);

        int i = 0, x = 0, currchar = 0;
        int number = Integer.parseInt(num);

        while (x != number) {
            currchar = Character.getNumericValue(num.charAt(i++));
            x = x * 10 + currchar;

            if (!s1.empty() && s1.peek() == currchar) {
                s1.pop();
                sb.append("X");
            } else if (!s2.empty() && s2.peek() <= currchar) {
                // keep popping until desired number is not found
                while (!s2.empty() && s2.peek() <= currchar) {
                    s1.push(s2.pop());
                    sb.append("S");
                }

                s1.pop();
                sb.append("X");
            } else
                return "NOT POSSIBLE";
        }
        return sb.toString();
    }

    // assumes that numbers to be used are sorted
    // i.e. here 1, 2, 3, 4, 5, 6
    public static void initialize(Stack<Integer> stack) {
        for (int i = MAX; i > 0; i--)
            stack.push(i);
    }

    public static void main(String args[]) {
        System.out.println(StringFromStacks("325641"));
        System.out.println(StringFromStacks("154623"));
        System.out.println(StringFromStacks("654321"));
    }

}
