// 60. Convert a sorted doubly linked list to balanced BST.
// nlogn time n space for recursion

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

public class DLLToBalancedBST {

	static class DLL {
		int data;
		DLL next;
		DLL prev;

		public DLL(int data) {
			this.data = data;
			next = prev = null;
		}

	}

	public static void main(String[] args) {
		/*-
		 * 20 <> 30 <> 40 <> 50 <> 60 <> 70 <> 80 
		 */

		/*-
		 *It should be converted to this BST      
		 *       50                                   
		 *     /     \                                 
		 *    30      70                               
		 *   /  \    /  \                              
		 * 20   40  60   80 
		 */

		head = new DLL(20);
		DLL two = new DLL(30);
		DLL three = new DLL(40);
		DLL four = new DLL(50);
		DLL five = new DLL(60);
		DLL six = new DLL(70);
		DLL seven = new DLL(80);

		head.next = two;
		two.prev = head;
		two.next = three;
		three.prev = two;
		three.next = four;
		four.prev = three;
		four.next = five;
		five.prev = four;
		five.next = six;
		six.prev = five;
		six.next = seven;
		seven.prev = six;

		DLL root = convertToBST(head);
		printLevelOrder(root);
	}

	public static DLL head = null;

	private static DLL convertToBST(DLL head) {
		int n = count(head);
		return dllToBST(n);
	}

	// recursive function to convert
	private static DLL dllToBST(int n) {
		if (n <= 0)
			return null;

		DLL left = dllToBST(n / 2);
		DLL root = head;
		root.prev = left;
		head = head.next;

		root.next = dllToBST(n - (n / 2) - 1);
		return root;
	}

	// helper function to count the nodes in the linked list
	private static int count(DLL head) {
		if (head == null)
			return 0;
		int i = 0;
		DLL temp = head;
		for (; temp != null; i++, temp = temp.next)
			;
		return i;
	}

	// helper function for printing tree in level order
	private static void printLevelOrder(DLL root) {
		if (root == null)
			return;
		Queue<DLL> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			DLL temp = queue.poll();
			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.prev != null)
					queue.offer(temp.prev);
				if (temp.next != null)
					queue.offer(temp.next);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
	}

}
