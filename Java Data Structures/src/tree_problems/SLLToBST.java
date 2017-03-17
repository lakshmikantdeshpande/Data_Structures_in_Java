// 62.  How will you convert sorted singly linked list to a balanced BST.
// 63. Can we improve complexity in problem 62?
// n time n space for recursion

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.BST;

public class SLLToBST {

	static class SLL {
		int data;
		SLL next;

		public SLL(int data) {
			this.data = data;
			next = null;
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

		head = new SLL(20);
		SLL two = new SLL(30);
		SLL three = new SLL(40);
		SLL four = new SLL(50);
		SLL five = new SLL(60);
		SLL six = new SLL(70);
		SLL seven = new SLL(80);

		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;

		BST root = convert(head, count(head));
		printLevelOrder(root);
	}

	public static SLL head = null;

	private static BST convert(SLL head, int n) {
		return dllToBST(head, 0, n - 1);
	}

	// recursive function to convert
	private static BST dllToBST(SLL head, int start, int end) {
		if (start > end)
			return null;

		int mid = start + (end - start) / 2;
		BST left = dllToBST(head, start, mid - 1);
		BST right = dllToBST(head, mid + 1, end);

		BST parent = new BST(head.data);
		parent.left = left;
		parent.right = right;

		if (head.next != null) {
			head.data = head.next.data;
			head.next = head.next.next;
		}
		return parent;
	}

	// helper function to count the nodes in the linked list
	private static int count(SLL head) {
		if (head == null)
			return 0;
		int i = 0;
		SLL temp = head;
		for (; temp != null; i++, temp = temp.next)
			;
		return i;
	}

	// helper function for printing tree in level order
	private static void printLevelOrder(BST root) {
		if (root == null)
			return;
		Queue<BST> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			BST temp = queue.poll();
			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.left != null)
					queue.offer(temp.right);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
	}

}