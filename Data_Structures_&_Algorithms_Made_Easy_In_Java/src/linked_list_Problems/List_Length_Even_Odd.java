// 30. Check whether the given linked list length is even or odd?
// Use a fast pointer (x2)
// O(n/2) time, O(1) space

package linked_list_Problems;

public class List_Length_Even_Odd {
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
		Node temp6 = new Node(6);
		Node temp7 = new Node(7);
		Node temp8 = new Node(8);
		Node temp9 = new Node(9);
		Node temp10 = new Node(10);

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
		lengthEvenOrOdd(head);
		System.out.println();
	}

	private static void lengthEvenOrOdd(Node head) {
		if (head == null) {
			System.out.println("Sounds like the linked list is empty");
			return;
		}
		Node temp = head;
		int counter = 0;
		while (temp != null && temp.next != null) {
			temp = temp.next.next;
			counter++;
		}
		if (temp == null)
			System.out.println("List's length is even: " + (counter * 2));
		else
			System.out.println("List's length is odd: " + ((counter * 2) + 1));
	}
}
