package Week_2_Stacks_and_Queues.PartOne;

public class ResizingArrays {
    public int top = 0;
    private String[] stack = new String[1];

    public static void main(String args[]) throws Exception {
        ResizingArrays sos = new ResizingArrays();
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
        if (stack.length == top)
            resize(stack.length * 2);
        stack[top++] = item;
    }

    public String pop() {
        if (top > 0 && top == stack.length / 4)
            resize(stack.length / 2);
        String item = stack[top];
        stack[top--] = null;
        return item;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void resize(int capacity) {
        String copy[] = new String[capacity];
        for (int i = 0; i < capacity; i++)
            copy[i] = stack[i];
        stack = copy;
    }

}
