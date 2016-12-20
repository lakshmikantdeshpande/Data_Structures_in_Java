// 23. Can we still think of an alternative solution for the problem 18?
//	O(max(mlogm,nlogn)) time, O(max(m, n)) space
//	Sorted first array, binary searched every element from the second array through first

package linked_list.Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Intersection_Of_Linked_Lists_4 {
	private static Node head1;
	private static Node head2;

	private class Node implements Comparable<Node> {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public int compareTo(Node o) {
			if (o == null)
				return -1;
			return this.data - o.data;
		}
	}

	public Intersection_Of_Linked_Lists_4() {
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
		Intersection_Of_Linked_Lists_4 ill = new Intersection_Of_Linked_Lists_4();
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
		ill.findIntersection(head1, head2);
		ill.display(head2);
	}

	// O(max(mlogm,nlogn)) time, O(max(m, n)) space
	// Sorted first array, binary searched every element from the second array
	// through first
	private void findIntersection(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			System.out.println("No intersection found");
			return;
		}
		boolean flag = false;
		List<Node> list = new ArrayList<Node>();
		for (Node temp = head1; temp != null; temp = temp.next)
			list.add(temp);

		Collections.sort(list);

		for (Node temp = head2; temp != null; temp = temp.next) {
			int x = Collections.binarySearch(list, temp, new comparator());
			if (x >= 0) {
				System.out.println("Intersection found at " + (list.get(x).data));
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("No intersection found");
		}
	}

	private class comparator implements Comparator<Node> {
		@Override
		public int compare(Node arg0, Node arg1) {
			return (arg0.data - arg1.data);
		}
	}
}
