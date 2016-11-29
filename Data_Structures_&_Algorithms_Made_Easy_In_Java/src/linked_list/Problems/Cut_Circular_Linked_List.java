// 38. Cut a circular linked list into 2 equal parts. If the number of nodes in the list are odd, then make first list longer.
// O(n) time, O(1) space

package linked_list.Problems;

public class Cut_Circular_Linked_List {
	private int length;
	private Node tail;

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Cut_Circular_Linked_List() {
		this.tail = null;
		this.length = 0;
	}

	public synchronized void display() {
		if (tail == null)
			return;

		Node temp = tail.next;
		while (temp != tail) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	public synchronized void insertAtTheBeginning(int data) {
		Node temp = new Node(data);
		if (tail == null) {
			tail = temp;
			tail.next = tail;
		} else {
			temp.next = tail.next;
			tail.next = temp;
		}
		length++;
	}

	public synchronized void insertAtTheEnd(int data) {
		insertAtTheBeginning(data);
		tail = tail.next; // length added in the insertAtTheBeginning function
	}

	public static void main(String[] args) {
		Cut_Circular_Linked_List cll = new Cut_Circular_Linked_List();
		cll.insertAtTheBeginning(1);
		cll.insertAtTheBeginning(0);
		cll.insertAtTheEnd(2);
		cll.insertAtTheEnd(3);
		cll.insertAtTheEnd(4);

		cll.display();
		Node temp1 = null, temp2 = null;
		cll.splitList(cll.tail, temp1, temp2);
	}

	private void splitList(Node tail, Node temp1, Node temp2) {
		Node slow = tail, fast = tail;
		if (tail == null)
			return;
		// If there are odd nodes in circular linked list, fast.next will be
		// tail, for even nodes fast.next.next will be
		// the tail

		while (fast.next != null && fast.next.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// if there are even elements in the list, move fast
		if (fast.next.next == tail)
			fast = fast.next;

		// Set tail pointer to first half
		temp1 = tail;

		// Set tail pointer to second half
		if (tail.next != tail)
			temp2 = slow.next;

		// Make the second half circular
		fast.next = slow.next;
		// Make the first half circular
		slow.next = tail;
	}

}
