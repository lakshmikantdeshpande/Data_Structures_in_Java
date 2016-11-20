// 6. Can we solve Problem-5 with recursion?
// we can use global variable / static var to track post recursive call
// recursive method n(prerecursive calls) + n(post recursive calls) time, n(stack) space
package linked_list.Problems;

public class Nth_Node_From_The_End_5 {
	private Node head;
	int size;
	int counter;
	
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
		
	}
	
	public Nth_Node_From_The_End_5() {
		head = null;
		size = 0;
		counter = 0;
	}

	public synchronized void addFromTheBeginning(int data)
	{
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	
	public synchronized void display(Node thead)
	{
		while (thead != null)
		{
			System.out.print(thead.data + " -> ");
			thead = thead.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		Nth_Node_From_The_End_5 nne = new Nth_Node_From_The_End_5();
		nne.addFromTheBeginning(1);
		nne.addFromTheBeginning(2);
		nne.addFromTheBeginning(3);
		nne.addFromTheBeginning(4);
		nne.addFromTheBeginning(5);
		
		nne.display(nne.head);
		nne.nthFromTheEnd(nne.head, 0);
	}

//	recursive method n(prerecursive calls) + n(post recursive calls) time, n(stack) space	
	public void nthFromTheEnd(Node node, int Nth) {
//		static int counter = 0;  // instead of global, static can be used
		if (node == null)
			return;
		nthFromTheEnd(node.next, Nth);
		counter++;
		if (Nth == counter)
			System.out.println(node.data);
	}
}
