// Queue using linked list
// n space
// 1 time for enqueue, dequeue, size, isEmpty, peek

package queue;

public class LinkedListQueue {

	private int length;
	private Node front, rear;

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public LinkedListQueue() {
		length = 0;
		front = rear = null;
	}

	public synchronized void enQueue(int data) throws Exception {
		Node node = new Node(data);
		if (isEmpty())
			front = node;
		else
			rear.next = node;
		rear = node;
		length++;
	}

	public synchronized int deQueue() throws Exception {
		if (isEmpty())
			throw new Exception("Underflow");

		int data = front.data;
		front = front.next;
		System.gc();
		length--;

		if (isEmpty())
			rear = null;
		return data;
	}

	public int peek() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty!");
		return front.data;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[ ]";
		StringBuilder strb = new StringBuilder("[ ");
		for (Node temp = front; temp != null; temp = temp.next)
			strb.append(temp.data + " ");
		return strb.append("]").toString();
	}

	public static void main(String[] args) throws Exception {
		LinkedListQueue llq = new LinkedListQueue();
		llq.enQueue(5);
		llq.enQueue(8);
		System.out.println(llq.peek());
		llq.enQueue(89);
		System.out.println(llq.toString());
		llq.deQueue();
		llq.deQueue();
		llq.deQueue();
		System.out.println(llq.toString());
	}

}
