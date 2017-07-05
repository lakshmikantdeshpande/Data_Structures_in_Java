// 1. Can we use stacks for balancing symbols?
// n time n space

package stack_problems;

import stack.Linked_List_Stack;

public class Balance_Parentheses {

    public static boolean checkBalance(String string) throws Exception {
        if (string == null || string.equals(""))
            return false;
        Linked_List_Stack lss = new Linked_List_Stack();
        int i = 0;
        int len = string.length();
        while (i < len) {
            if (string.charAt(i) == '(' || string.charAt(i) == '{' || string.charAt(i) == '[') {
                lss.push(string.charAt(i));
                i++;
                continue;
            }
            if (string.charAt(i) == ')')
                if (!lss.isEmpty() && lss.peek() == '(')
                    lss.pop();
                else
                    return false;
            else if (string.charAt(i) == '}')
                if (!lss.isEmpty() && lss.peek() == '{')
                    lss.pop();
                else
                    return false;
            else if (string.charAt(i) == ']')
                if (!lss.isEmpty() && lss.peek() == '[')
                    lss.pop();
                else
                    return false;
            i++;
        }
        if (lss.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(checkBalance("((A+B)+(C-D])"));
    }

}
