// 57. Given a list, rotate the list to the right by k places,where k is non negative.
// For eg. given 1-2-3-4-5-NULL, return 4-5-1-2-3-NULL when n = 2.
// n time 1 space 
package linked_list.Problems;

public class Rotate_List {
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
		display(rotateRight(head, 3));
	}

	private static Node rotateRight(Node head, int n) {
		if (head == null || head.next == null)
			return head;
		Node rotateStart = head, rotateEnd = head;
		while (n-- > 0) {
			rotateEnd = rotateEnd.next;
			if (rotateEnd == null)
				rotateEnd = head;
		}
		if (rotateStart == rotateEnd)
			return head;
		while (rotateEnd.next != null) {
			rotateStart = rotateStart.next;
			rotateEnd = rotateEnd.next;
		}
		Node temp = rotateStart.next;
		rotateEnd.next = head;
		rotateStart.next = null;
		return temp;
	}
}
