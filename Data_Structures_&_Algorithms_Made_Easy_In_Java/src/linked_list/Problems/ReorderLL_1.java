// 54. Given a singly linked list L: L1-L2-L3...Ln-1-Ln, reorder the linked list to
//     L1,Ln,L2,Ln-1
// n time n/2 space
// found out the middle of the linked list using fast and slow pointer
// reversed the second half by putting into the stack
// popped out of stack while traversing with first half of original LL & attached to LL
package linked_list.Problems;

import java.util.LinkedList;

public class ReorderLL_1 {
	private static Node head;

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static synchronized void display(Node head) {
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
		head = new Node(0);
		Node temp1 = new Node(1);
		Node temp2 = new Node(2);
		Node temp3 = new Node(3);
		Node temp4 = new Node(4);
		Node temp5 = new Node(5);
		Node temp6 = new Node(7);
		Node temp7 = new Node(8);
		Node temp8 = new Node(9);
		Node temp9 = new Node(10);
		Node temp10 = new Node(11);

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
		temp10.next = null;

		display(head);
		reOrder(head);
		display(head);
	}

	private static void reOrder(Node head) {
		if (head == null) {
			System.out.println("Linked list seems empty !");
			return;
		}
		Node slow = head, fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// temp1 is the center of the linked list
		Node head2 = slow.next;
		slow.next = null;
		LinkedList<Node> queue = new LinkedList<Node>();
		while (head2 != null) {
			Node temp = head2;
			head2 = head2.next;
			temp.next = null;
			queue.push(temp);
		}

		while (!queue.isEmpty()) {
			Node temp = queue.pop();
			temp.next = head.next;
			head.next = temp;
			head = temp.next;
		}
	}
}
