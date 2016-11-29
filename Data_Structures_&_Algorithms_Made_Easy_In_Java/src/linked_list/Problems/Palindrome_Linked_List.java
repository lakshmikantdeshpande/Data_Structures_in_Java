// 39. Palindrome Check in a linked list?
// n+n time, 1 space

package linked_list.Problems;

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
		findMiddle(head);
	}

	private static void findMiddle(Node head) {
		if (head == null) {
			return;
		}
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node p = slow, q = null, r = null;
		while (p != null) {
			r = p.next;
			p.next = q;
			q = p;
			p = r;
		}

		p = head;
		while (q != null) {
			if (p.data != q.data) {
				System.out.println("Not a palindrome");
				return;
			}
			p = p.next;
			q = q.next;
		}
		System.out.println("It is a palindrome");
	}
}
