// 8. Can we use hashing technique for solving Problem-8?
// n time, n space
package linked_list.Problems;

import java.util.ArrayList;
import java.util.List;

public class Cyclic_Linked_List_1 {
	private static Node head;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Cyclic_Linked_List_1() {
		this.head = new Node(0);
	}

	public void display(Node head) {
		Node temp = head;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Cyclic_Linked_List_1 cll = new Cyclic_Linked_List_1();
		Node temp1 = cll.new Node(1);
		Node temp2 = cll.new Node(2);
		Node temp3 = cll.new Node(3);
		Node temp4 = cll.new Node(4);
		Node temp5 = cll.new Node(5);
		Node temp6 = cll.new Node(6);
		Node temp7 = cll.new Node(7);
		Node temp8 = cll.new Node(8);
		Node temp9 = cll.new Node(9);
		Node temp10 = cll.new Node(10);

		head.next = temp1;
		temp1.next = temp2;
		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;
		temp5.next = temp6;
		temp6.next = temp7;
		temp7.next = temp8;
		temp8.next = temp9;
		temp9.next = temp10;
		temp10.next = temp5; // here it becomes cyclic

		// cll.display(head);
		cll.solveUsingHashTable(head);
	}

	// Use ArrayList instead of HashMap
	// n time complexity, n space complexity
	public void solveUsingHashTable(Node head) {
		if (head == null) {
			System.out.println("Linked list is empty !");
			return;
		}

		List<Node> list = new ArrayList<Node>();
		Node temp = head;
		while (temp.next != null && !list.contains(temp.next)) {
			temp = temp.next;
			list.add(temp);
		}
		if ((temp.next != null) && list.contains(temp.next))
			System.out.println("Linked list is cyclic at position "
					+ (list.indexOf(temp.next) + 1));
		else
			System.out.println("Linked list is not cyclic");
	}

}
