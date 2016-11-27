// 33. Can we solve Problem 32 without recursion?
// O(n) time, O(n) space

package linked_list.Problems;

public class Merge_Sorted_Linked_List_2 {
	private Node head1;
	private Node head2;

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static synchronized void display(Node head) {
		Node temp = head;
		if (temp == null)
			return;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Merge_Sorted_Linked_List_2 msll = new Merge_Sorted_Linked_List_2();
		msll.head1 = new Node(0);
		msll.head2 = new Node(1);

		Node one1 = new Node(2);
		Node one2 = new Node(4);
		Node one3 = new Node(5);
		Node one4 = new Node(7);
		Node one5 = new Node(9);
		msll.head1.next = one1;
		one1.next = one2;
		one2.next = one3;
		one3.next = one4;
		one4.next = one5;

		Node two1 = new Node(3);
		Node two2 = new Node(5);
		Node two3 = new Node(6);
		Node two4 = new Node(8);
		Node two5 = new Node(10);
		msll.head2.next = two1;
		two1.next = two2;
		two2.next = two3;
		two3.next = two4;
		two4.next = two5;

		display(msll.head1);
		display(msll.head2);
		display(merge(msll.head1, msll.head2));
	}

	private static Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node head = new Node(0);
		Node curr = head;

		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				curr.next = head1;
				head1 = head1.next;
			} else {
				curr.next = head2;
				head2 = head2.next;
			}
			curr = curr.next;
		}

		if (head1 != null)
			curr.next = head1;
		else if (head2 != null)
			curr.next = head2;
		return head.next;
	}
}
