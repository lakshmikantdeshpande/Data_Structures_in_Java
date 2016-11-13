// 3. Can we improve the complexity of Problem 2?
// using hashtable(hashmap here) to improve speed
// n time n space

package linked_list.Problems;

import java.util.HashMap;
import java.util.Map;

public class Nth_Node_From_The_End_2 {
	private Node head;
	private int size;
	private Map<Integer, Integer> map;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Nth_Node_From_The_End_2() {
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
		Nth_Node_From_The_End_2 nnd = new Nth_Node_From_The_End_2();
		nnd.insertFromTheBeginning(5);
		nnd.insertFromTheBeginning(4);
		nnd.insertFromTheBeginning(3);
		nnd.insertFromTheBeginning(2);
		nnd.insertFromTheBeginning(1);

		nnd.display();
		nnd.nthFromTheEnd(2);
	}

	// hashtable(hashmap) solution gives n time complexity and n space complexity 
	private void nthFromTheEnd(int n) {
		if (head == null || n < 0)
			return;
		Node temp = head;
		map = new HashMap<Integer, Integer>();
		for (int i = size; i > 0; i--) {
			map.put(i, temp.data);
			temp = temp.next;
		}
		
		System.out.println(map.get(n));
	}

}
