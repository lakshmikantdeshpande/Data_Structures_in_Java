// 16. Insert a node in a sorted linked list
// Easy Peasy
// n time 1 space

package linked_list_Problems;

public class Insert_In_A_Sorted_Linked_List {
	private static Node head;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Insert_In_A_Sorted_Linked_List() {
		head = new Node(0);
		System.out.println(head);
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

	private synchronized void InsertInTheMiddle(int data) {
		if (head == null) {
			System.out.println("The linked list appears empty!");
			return;
		}
		Node node = new Node(data);
		Node p = head, q = null;
		if (data < p.data) {
			node.next = head;
			head = node;
			return;
		}
		while (p != null && data > p.data) {
			q = p;
			p = p.next;
		}

		node.next = p;
		q.next = node;
	}

	public static void main(String[] args) {
		Insert_In_A_Sorted_Linked_List ill = new Insert_In_A_Sorted_Linked_List();
		Node temp1 = ill.new Node(1);
		Node temp2 = ill.new Node(2);
		Node temp3 = ill.new Node(3);
		Node temp4 = ill.new Node(4);
		Node temp5 = ill.new Node(6);
		Node temp6 = ill.new Node(7);
		Node temp7 = ill.new Node(8);
		Node temp8 = ill.new Node(9);
		Node temp9 = ill.new Node(10);
		Node temp10 = ill.new Node(11);

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

		ill.display();
		ill.InsertInTheMiddle(5);
		ill.display();
	}

}
