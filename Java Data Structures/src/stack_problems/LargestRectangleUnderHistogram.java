// Find the largest rectangle under histogram.
// n time n space

import java.util.Stack;

public class LargestRectangleUnderHistogram {

public static void main(String[] args) {
	System.out.println(getMaxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
}

public static int getMaxArea(int array[]) {
	
	if (array == null || array.length == 0)
	    return 0;
    
    // Create an empty stack. The stack holds indexes of input array
    // The bars stored in stack are always in increasing order of their
    // heights.
	Stack<Integer> stack = new Stack<Integer>();
	
	// maximum area
	int maxarea = 0;
	int i = 0;
	
	while (i < array.length) {
	    // if current bar is higher than or equal to stack peek, push it to stack
	    if (stack.empty() || array[i] >= array[stack.peek()])
	        stack.push(i++);
	    else {
	        // if current bar is lower than stack top
	        // calculate area of rectangle with stack top as smallest bar
	        // i is right index for top and element before top in the stack is left index;
	        int top = stack.pop();
	        // calculate the area with array[top] stack as smallest bar and update maxarea
	        maxarea = Math.max(maxarea, array[top] * (stack.empty() ? i : i - stack.peek() - 1));
	    }
	}
            	
	// Now pop remaining bars from stack and calculate area with every popped bar as smallest bar
	while (!stack.empty()) {
	    int top = stack.pop();
	    maxarea = Math.max(maxarea, array[top] * (stack.empty() ? i : i - stack.peek() - 1));
	}
	return maxarea;
}

}
