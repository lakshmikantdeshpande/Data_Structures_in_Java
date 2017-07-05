package stack;

public class DynamicSize_Array_Stack {
    private static int CAPACITY = 10;
    private int capacity;
    private int top;
    private int stack[];

    public DynamicSize_Array_Stack(int capacity) {
        top = -1;
        this.capacity = capacity;
        stack = new int[this.capacity];
    }

    public DynamicSize_Array_Stack() {
        this(CAPACITY);
    }

    public static void main(String[] args) throws Exception {
        DynamicSize_Array_Stack dsas = new DynamicSize_Array_Stack(1);
        dsas.push(1);
        dsas.push(2);
        dsas.push(3);
        dsas.push(1);
        dsas.push(1);
        dsas.push(1);
        dsas.push(1);
        dsas.push(1);
        dsas.pop();
        dsas.pop();
        dsas.pop();
        dsas.pop();
        dsas.pop();
        dsas.pop();
        dsas.pop();
        dsas.pop();
        // dsas.pop(); // Undeflow, as expected
    }

    public int size() {
        return top + 1;
    }

    public int pop() throws Exception {
        if (size() == 0)
            throw new Exception("Underflow");
        if (size() == capacity / 4)
            resize(capacity / 2);
        int data = stack[top];
        stack[top--] = Integer.MIN_VALUE; // avoid loitering
        return data;
    }

    public void push(int data) throws Exception {
        if (size() == capacity)
            resize(capacity * 2);
        stack[++top] = data;
    }

    private void resize(int newCapacity) {
        if (newCapacity == 0)
            newCapacity = 1;
        System.out.println("Resized to new size: " + newCapacity);
        capacity = newCapacity;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
    }

}
