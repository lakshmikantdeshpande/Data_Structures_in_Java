// 20. Can we solve Problem-18 using hash table ?
// hashtable
// n time n space

package linked_list.Problems;

import java.util.HashMap;
import java.util.Map;

public class Intersection_Of_Linked_Lists_1 {
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

	public Intersection_Of_Linked_Lists_1() {
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
		Intersection_Of_Linked_Lists_1 ill = new Intersection_Of_Linked_Lists_1();
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
//		tempy.next = null;		
		
		temp6.next = temp7;
		temp7.next = temp8;
		temp8.next = temp9;
		temp9.next = temp10;
		temp10.next = null;

		ill.display(head1);
		ill.findIntersection(head1, head2);
		ill.display(head2);
	}

	private void findIntersection(Node head1, Node head2) {
		int x = 0;
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		Node temp1 = head1, temp2 = head2;
		while (temp1 != null && temp2!= null)
		{
			if (map.containsKey(temp1))
			{
				System.out.println(temp1.data); return;
			}
			else if (map.containsKey(temp2))
			{
				System.out.println(temp2.data); return;
			}
			map.put(temp1, x++);
			map.put(temp2, x++);
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		System.out.println("These two linked lists don't seem to intersect.");
	}
	
}
