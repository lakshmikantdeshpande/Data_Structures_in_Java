// 61. Convert a sorted array to BST
// n time n space for recursion

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.BST;

public class ArrayToBST {

	public static void main(String[] args) {

		int[] array = new int[] { 20, 30, 40, 50, 60, 70, 80 };

		/*-
		 *It should be converted to this BST      
		 *       50                                   
		 *     /     \                                 
		 *    30      70                               
		 *   /  \    /  \                              
		 * 20   40  60   80 
		 */

		printLevelOrder(arrayToBST(array, 0, array.length - 1));

	}

	private static BST arrayToBST(int[] array, int left, int right) {
		if (array == null || left > right)
			return null;
		BST node;

		if (left == right)
			node = new BST(array[left]);
		else {
			int mid = left + (right - left) / 2;
			node = new BST(array[mid]);
			node.left = arrayToBST(array, left, mid - 1);
			node.right = arrayToBST(array, mid + 1, right);
		}
		return node;
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
