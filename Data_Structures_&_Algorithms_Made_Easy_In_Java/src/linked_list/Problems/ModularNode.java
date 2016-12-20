// 47. Find modular node from a given linked list. (last modular node)
// for eg. if n = 19, k = 3, then last number where n%k == 0 i.e. 18th node should be returned
// n time 1 space

package linked_list.Problems;

public class ModularNode {
	private Node head;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public ModularNode() {
		head = new Node(0);
	}

	public static void main(String[] args) {
		ModularNode modn = new ModularNode();
		Node temp1 = modn.new Node(1);
		Node temp2 = modn.new Node(2);
		Node temp3 = modn.new Node(3);
		Node temp4 = modn.new Node(4);
		Node temp5 = modn.new Node(5);
		Node temp6 = modn.new Node(7);
		Node temp7 = modn.new Node(8);
		Node temp8 = modn.new Node(9);
		Node temp9 = modn.new Node(10);

		modn.head.next = temp1;
		temp1.next = temp2;
		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;
		temp5.next = temp6;
		temp6.next = temp7;
		temp7.next = temp8;
		temp8.next = temp9;
		temp9.next = null;

		System.out.println(modn.findlastmod(modn.head, 3).data);

	}

	Node findlastmod(Node head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		int i = 0;
		Node modularNode = head;
		Node temp = head;
		while (temp != null) {
			if (i % k == 0) {
				System.out.println(i + " " + k);
				modularNode = temp;
			}
			i++;
			temp = temp.next;
		}
		return modularNode;
	}

}
