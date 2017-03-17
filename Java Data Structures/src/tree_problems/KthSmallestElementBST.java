// 64. Find kth smallest element in a BST.
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.BST;

public class KthSmallestElementBST {

	public static void main(String[] args) {

		/*-
		 *       50                                   
		 *     /     \                                 
		 *    30      70                               
		 *   /  \    /  \                              
		 * 20   40  60   80 
		 */

		BST root = insert(null, 50);
		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 80);

		System.out.println(findKthSmallest(root, 5).data);
		// printLevelOrder(root);
	}

	private static BST findKthSmallest(BST root, int k) {
		if (root == null)
			return null;
		Stack<BST> stack = new Stack<>();
		BST temp = root;
		int count = 0;
		BST result = null;

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				count++;
				if (count == k) {
					result = temp;
					break;
				}
				temp = temp.right;
			}
		}
		return result;
	}

	// normal BST insertion
	public static BST insert(BST root, int data) {
		if (root == null)
			return new BST(data);
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		return root;
	}

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
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
	}
}
