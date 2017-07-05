// Circular array queue
// o(n) space
// o(1) time for enqueue, dequeue, size, isEmpty, isFull

package queue;

public class CircularArrayQueue {
    private int size;
    private int capacity;
    private int front, rear;
    private int[] queue;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = 0;
        size = 0;
    }

    public CircularArrayQueue() {
        this(16);
    }

    public static void main(String[] args) throws Exception {
        CircularArrayQueue caq = new CircularArrayQueue();
        caq.enQueue(1);
        /*
		 * CRAZY TESTS DOWN HERE; for (int i = 0; i < caq.capacity; i++) {
		 * caq.enQueue(i); System.out.println("Front: " + caq.front);
		 * System.out.println("Rear: " + caq.rear); } for (int i = 5; i <
		 * caq.capacity; i++) { caq.deQueue(); System.out.println("Front: " +
		 * caq.front); System.out.println("Rear: " + caq.rear); }
		 * caq.enQueue(99); {
		 *
		 * System.out.println("Front: " + caq.front); System.out.println(
		 * "Rear: " + caq.rear); } caq.deQueue(); caq.deQueue(); caq.deQueue();
		 * caq.deQueue(); caq.deQueue(); { System.out.println("Front: " +
		 * caq.front); System.out.println("Rear: " + caq.rear); }
		 */
        System.out.println(caq.toString());
    }

    public synchronized void enQueue(int data) throws Exception {
        if (isFull())
            throw new Exception("Overflow");
        size++;
        queue[rear] = data; // push the next incoming element
        // at the available position
        rear = (rear + 1) % capacity;
    }

    public synchronized int deQueue() throws Exception {
        if (isEmpty())
            throw new Exception("Underflow");

        size--;
        int data = queue[front];
        queue[front] = Integer.MIN_VALUE;
        front = (front + 1) % capacity;
        return data;
    }

    public synchronized boolean isEmpty() {
        return size() == 0;
    }

    public synchronized int size() {
        return this.size;
    }

    public synchronized boolean isFull() {
        return size() == this.capacity;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder strb = new StringBuilder("[ ");
        int index = front;
        for (int i = 0; i < size; i++) {
            strb.append(queue[index] + " ");
            index = (index + 1) % capacity;
        }
        return strb.append("]").toString();
    }

}
