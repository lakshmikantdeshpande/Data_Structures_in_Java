// 70. Is there any other way for solving problem 69?
// n time n space 

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.BST;

public class RangeBST_2 {

	public static void main(String[] args) {

		/*-
		 *      
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

		printRange(root, 30, 50);

	}

	private static void printRange(BST root, int low, int high) {
		if (root == null || low > high)
			return;

		Queue<BST> queue = new LinkedList<BST>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			BST temp = queue.poll();
			if (temp.data >= low && temp.data <= high)
				System.out.println(temp.data);

			if (temp.left != null && temp.data >= low)
				queue.offer(temp.left);
			if (temp.right != null && temp.data <= high)
				queue.offer(temp.right);
		}
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

}
