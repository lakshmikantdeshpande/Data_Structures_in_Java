package stack;

public class FixedSize_Array_Stack {

    public static final int CAPACITY = 10;
    private int capacity;
    private int[] stack;
    private int top = -1;

    public FixedSize_Array_Stack() {
        this(CAPACITY);
    }

    public FixedSize_Array_Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        FixedSize_Array_Stack fsas = new FixedSize_Array_Stack(3);
        fsas.push(5);
        fsas.push(2);
        fsas.push(3);
        System.out.println(fsas.toString());
    }

    public int size() {
        return top + 1;
    }

    public void push(int data) throws Exception {
        if (size() == capacity)
            throw new Exception("Overflow");
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (size() == 0)
            throw new Exception("Underflow");
        int data = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        return data;
    }

    @Override
    public String toString() {
        int data = size();
        if (data == 0)
            return "[ ]";
        StringBuilder strb = new StringBuilder("[ ");
        for (int i = 0; i <= top; i++) {
            strb.append(stack[i] + " ");
        }
        return strb.append("]").toString();
    }

}
