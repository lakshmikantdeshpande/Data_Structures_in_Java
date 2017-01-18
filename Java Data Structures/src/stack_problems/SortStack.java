// 25. Sort a stack in ascending order
// n*n time n space

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        stack = sortStack(stack);
        System.out.println(stack);    
    }
       
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack == null)
            return null;
        Stack<Integer> auxStack = new Stack<Integer>();
        
        while (!stack.empty()) {
            int temp = stack.pop();
            while (!auxStack.empty() && auxStack.peek() > temp)
                stack.push(auxStack.pop());
            auxStack.push(temp); 
        }
         
        return auxStack;
    }
}
