// 21. Can we use stacks for solving the problem-18?
// O(m+n) time (m, n = length of the linked lists)
// O(m+n) space
package linked_list_Problems;

public class Intersection_Of_Linked_Lists_2 {
	private static Node head1;
	private static Node head2;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Intersection_Of_Linked_Lists_2() {
		head1 = new Node(0);
		head2 = new Node(-1);
	}

	private synchronized void display(Node head) {
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
		Intersection_Of_Linked_Lists_2 ill = new Intersection_Of_Linked_Lists_2();
		Node temp1 = ill.new Node(1);
		Node temp2 = ill.new Node(2);
		Node temp3 = ill.new Node(3);
		Node temp4 = ill.new Node(4);
		Node temp5 = ill.new Node(5);
		Node temp6 = ill.new Node(7);
		Node temp7 = ill.new Node(8);
		Node temp8 = ill.new Node(9);
		Node temp9 = ill.new Node(10);
		Node temp10 = ill.new Node(11);

		Node tempx = ill.new Node(54);
		Node tempy = ill.new Node(55);

		head1.next = temp1;
		temp1.next = temp2;
		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;
		temp5.next = temp6;

		head2.next = tempx;
		tempx.next = tempy;
		tempy.next = temp6;
		// tempy.next = null;

		temp6.next = temp7;
		temp7.next = temp8;
		temp8.next = temp9;
		temp9.next = temp10;
		temp10.next = null;

		ill.display(head1);
		try {
			ill.findIntersection(head1, head2);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		ill.display(head2);
	}

	// return last common element while popping the stacks
	private void findIntersection(Node head1, Node head2) throws Exception {
		if (head1 == null || head2 == null)
			return;

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Node t1 = head1, t2 = head2;
		while (t1 != null) {
			stack1.push(t1.data);
			t1 = t1.next;
		}
		while (t2 != null) {
			stack2.push(t2.data);
			t2 = t2.next;
		}

		int x = 0, y = 0, z = 0;
		while (x == y) {
			z = x;
			try {
				x = stack1.pop();
			} catch (Exception e) {
				break;
			}
			try {
				y = stack2.pop();
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(z);
	}
}

class Stack<Integer> {
	private Node head = null;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		Node temp = new Node(data);
		Node oldHead = head;
		temp.next = oldHead;
		head = temp;
	}

	public int pop() throws Exception {
		if (head == null)
			throw new Exception("Underflow");
		int temp = head.data;
		head = head.next;
		return temp;
	}
}