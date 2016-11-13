package linked_list.Problems;

import java.util.HashMap;

public class Nth_Node_From_The_End_3 {
	private Node head;
	private int size;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Nth_Node_From_The_End_3() {
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
		Nth_Node_From_The_End_3 nnd = new Nth_Node_From_The_End_3();
		nnd.insertFromTheBeginning(5);
		nnd.insertFromTheBeginning(4);
		nnd.insertFromTheBeginning(3);
		nnd.insertFromTheBeginning(2);
		nnd.insertFromTheBeginning(1);

		nnd.display();
		nnd.nthFromTheEnd(0);
	}

	// hashtable(hashmap) solution gives n time complexity and n space complexity 
	private void nthFromTheEnd(int n) {
		if (head == null || n < 0)
			return;
		
		Node temp = head;
		
		// find the size by iterating through the linked list
		int counter = 0;
		while (temp != null)
		{
			counter++;
			temp = temp.next;
		}
		n = counter - n - 1;
		temp = head;
		for (int i = 0; i < n; i++)
			temp = temp.next;
		System.out.println(temp.data);
	}

}
