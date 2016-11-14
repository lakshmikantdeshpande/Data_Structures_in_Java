// 5. Can we solve Problem-2 in one scan ?
// sliding window of 2 pointers(n time 1 space)
// possibly the best solution
package linked_list.Problems;

import java.util.HashMap;

public class Nth_Node_From_The_End_4 {
	private Node head;
	private int size;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Nth_Node_From_The_End_4() {
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
		Nth_Node_From_The_End_4 nnd = new Nth_Node_From_The_End_4();
		nnd.insertFromTheBeginning(5);
		nnd.insertFromTheBeginning(4);
		nnd.insertFromTheBeginning(3);
		nnd.insertFromTheBeginning(2);
		nnd.insertFromTheBeginning(1);

		nnd.display();
		nnd.nthFromTheEnd(0);
	}

	// sliding window of size n to find nth element from the end
	private void nthFromTheEnd(int n) {
		if (head == null || n < 0)
			return;

		Node p = head, q = head;

		int i = 0;
		for (i = 0; i < n; i++) {
			if (p == null)
				break;
			p = p.next;
		}
		if (i == n)
			if (p == null || p.next == null)
				System.out.println(q.data);
			else {
				while (p.next != null) {
					p = p.next;
					q = q.next;
				}
				System.out.println(q.data);
			}
		else
			System.out.println("Invalid n");
	}

}
