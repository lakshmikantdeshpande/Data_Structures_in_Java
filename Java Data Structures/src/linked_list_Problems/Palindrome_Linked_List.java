// 39. Palindrome Check in a linked list?
// n+n time, 1 space

package linked_list_Problems;

import java.util.Stack;

public class Palindrome_Linked_List {

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
		Node temp6 = new Node(4);
		Node temp7 = new Node(3);
		Node temp8 = new Node(2);
		Node temp9 = new Node(1);
		Node temp10 = new Node(0);

		head.next = temp1;
		// temp1.next = temp2;
		// temp2.next = temp3;
		// temp3.next = temp4;
		// temp4.next = temp5;
		// temp5.next = temp6;
		// temp6.next = temp7;
		// temp7.next = temp8;
		// temp8.next = temp9;
		// temp9.next = temp10;
		temp10.next = null;

		display(head);
		findMiddle(head);
		display(head);
	}

	private static void findMiddle(Node head) {
		if (head == null) {
			return;
		}
		Node fast = head, slow = head;
		boolean flag = true;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while (slow != null) {
			stack.push(slow.data);
			slow = slow.next;
		}

		slow = head;
		try {
			while (slow != null && !stack.empty()) {     // && i-- > 0
				if (slow.data != stack.pop()) {
					System.out.println("Not a palindrome");
					return;
				}
				slow = slow.next;
			}
			System.out.println("Is a palindrome");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
