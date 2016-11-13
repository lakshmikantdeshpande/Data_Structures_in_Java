// 1. Implement Stack using Linked list
// n time n space

package linked_list.Problems;

public class Stack_Using_Linked_List {
	private int top;
	private int sizelimit;
	private Node head;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Stack_Using_Linked_List(int sizelimit) {
		this.top = 0;
		this.head = null;
		this.sizelimit = sizelimit;
	}

	public synchronized int pop() throws Exception {
		if (head == null)
			throw new Exception("Underflow");
		int value = head.data;
		head = head.next;
		top--;
		return value;
	}

	public synchronized void push(int data) throws Exception {
		if (top == sizelimit)
			throw new Exception("Overflow");
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		top++;
	}

	public synchronized int size() {
		return this.top;
	}

	public synchronized boolean isFull() {
		return this.top == this.sizelimit;
	}

	public synchronized boolean isEmpty() {
		return this.top == 0;
	}

	public static void main(String args[]) throws Exception {
		Stack_Using_Linked_List sull = new Stack_Using_Linked_List(2);

		sull.push(1);
		sull.push(2);
		// sull.push(3);

		System.out.println(sull.pop());
		System.out.println(sull.pop());
		// System.out.println(sull.pop());

		System.out.println(sull.size());
		System.out.println(sull.isFull());
		System.out.println(sull.isEmpty());
	}
}