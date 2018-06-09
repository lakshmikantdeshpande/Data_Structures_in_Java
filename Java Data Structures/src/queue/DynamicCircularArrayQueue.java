// Circular dynamic array queue
// o(n) space
// o(1) time for enqueue, dequeue, size, isEmpty, isFull

package queue;

public class DynamicCircularArrayQueue {

    private int size;
    private int capacity;
    private int mincapacity = 1 << 15;
    private int front, rear;
    private int[] queue;

    public DynamicCircularArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = 0;
        size = 0;
    }

    public DynamicCircularArrayQueue() {
        this(16);
    }

    public static void main(String[] args) throws Exception {
        DynamicCircularArrayQueue dacq = new DynamicCircularArrayQueue();
        dacq.enQueue(1);
        System.out.println(dacq.toString());
    }

    public void enQueue(int data) throws Exception {
        if (isFull())
            expand();
        size++;
        queue[rear] = data; // push the next incoming element
        // at the available position
        rear = (rear + 1) % capacity;
    }

    private void expand() {
        int length = size();
        int newQueue[] = new int[length << 1]; // twice the size

        for (int i = front; i <= rear; i++)
            newQueue[i - front] = queue[i % capacity];
        queue = newQueue;
        front = 0;
        rear = size - 1;
        capacity *= 2;
    }

    public int deQueue() throws Exception {
        if (isEmpty())
            throw new Exception("Underflow");

        size--;
        int data = queue[front];
        queue[front] = Integer.MIN_VALUE;
        front = (front + 1) % capacity;
        return data;
    }

    private void shrink() {
        int length = size;
        if (length <= mincapacity || length << 2 >= length)
            return;

        if (length < mincapacity)
            length = mincapacity;
        int newQueue[] = new int[length];
        System.arraycopy(queue, 0, newQueue, 0, length + 1);
        queue = newQueue;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isFull() {
        return size() == this.capacity;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder strb = new StringBuilder("[ ");
        int index = front;
        for (int i = 0; i < size; i++) {
            strb.append(queue[index]).append(" ");
            index = (index + 1) % capacity;
        }
        return strb.append("]").toString();
    }

}
