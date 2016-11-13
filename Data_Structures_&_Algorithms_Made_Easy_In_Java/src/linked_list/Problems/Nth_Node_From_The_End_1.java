// 2. Find nth node from the end of a linked list
// Brute force solution

package linked_list.Problems;

public class Nth_Node_From_The_End_1 {
	private Node head;
	private int size;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Nth_Node_From_The_End_1() {
		this.head = null;
		this.size = 0;
	}

	public synchronized void insertFromTheBeginning(int data) {
		Node oldhead = head;
		head = new Node(data);
		head.next = oldhead;
		size++;
	}

	private synchronized void display() {
		if (head == null)
			return;
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("null\n");
	}

	public static void main(String[] args) {
		Nth_Node_From_The_End_1 nnd = new Nth_Node_From_The_End_1();
		nnd.insertFromTheBeginning(5);
		nnd.insertFromTheBeginning(4);
		nnd.insertFromTheBeginning(3);
		nnd.insertFromTheBeginning(2);
		nnd.insertFromTheBeginning(1);

		nnd.display();
		nnd.nthFromTheEnd(4);
	}

	// brute force solution gives n*n time complexity & 1 space complexity
	private void nthFromTheEnd(int n) {
		if (head == null || n < 0)
			return;
		int counter = 0;
		Node x = head, y = null;

		while (x != null) // n
		{
			y = x;
			counter = 0;
			while (y.next != null) // n
			{
				counter++;
				y = y.next;
			}
			if (counter == n) {
				System.out.println(n + "th element from the end is: " + x.data);
				return;
			} else
				x = x.next;
		}
	}

}
