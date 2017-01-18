// 26. Recursively remove adjacent duplicates
// n time n+n space

import java.util.Stack;

public class RemoveAdjacentDuplicates_1 {

    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9, 9, 9, 0, 0, 9 }; 
        
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        removeDuplicates(array);    
    }
       
    public static void removeDuplicates(int[] array) {
        if (array == null || array.length == 0)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        int[] newarray = new int[array.length];
        
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            if (!stack.empty() && stack.peek() == array[i])
                continue;
            stack.push(array[i]);
            newarray[t++] = array[i];
        }
        
        for (int i = 0; i < t; i++)
            System.out.print(array[i] + " ");
        System.out.println(stack.toString());
    }
}
