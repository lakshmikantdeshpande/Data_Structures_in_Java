package week_2_Stacks_and_Queues.PartOne;

/**
 * Implementation of stack using arrays
 * Reverse given string using stack
 */
public class StackOfStringsArrays {
    private int top = -1;
    private String stack[];

    public StackOfStringsArrays(int capacity) {
        stack = new String[capacity];
    }

    public static void main(String args[]) throws Exception {
        StackOfStringsArrays sos = new StackOfStringsArrays(4);
        sos.push("one");
        sos.push("two");
        sos.push("three");
        sos.push("four");
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }

    public void push(String item) {
        stack[++top] = item;
    }

    public String pop() {
        String item = stack[top];
        stack[top--] = null;
        return item;

    }

    public boolean isEmpty() {
        return top == -1;
    }
}
