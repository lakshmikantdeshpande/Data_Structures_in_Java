// 18. Create an empty stack of integers.
// 'S' should indicate push and 'X' should indicate a pop. 
// Is it possible to create 325641 & 154623 by just pushing and popping 1, 2, 3, 4, 5, 6 in this order only?
// n*n time  n space

import java.util.Stack;

public class StackString {

public static String StringFromStacks(String num) {
    if (num == null || num.equals("") || num.equals(" "))
        return "NOT POSSIBLE";
        
    StringBuilder sb = new StringBuilder();
    int output = 0;
    
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    for (int i = 6; i > 0; i--)
        s2.push(i);
    
    int i = 0, x = 0, currchar = 0, t = 0;
    int number = Integer.parseInt(num);
    
    while (x != number) {
        currchar = Character.getNumericValue(num.charAt(i++));
        x = x * 10 + currchar;
        
        if (!s1.empty() && s1.peek() == currchar) {
            s1.pop();
            sb.append("X");
        } else if (!s2.empty() && s2.contains(currchar)) {
            while ((t = s2.pop()) != currchar) {
                s1.push(t);
                sb.append("S");
            }
            s1.push(t);
            sb.append("S");
            s1.pop();
            sb.append("X");                    
        } else return "NOT POSSIBLE";
   }
   return sb.toString();
}

public static void main(String args[]) {
    System.out.println(StringFromStacks("325641"));
    System.out.println(StringFromStacks("154623"));
    System.out.println(StringFromStacks("654321"));
}

}
