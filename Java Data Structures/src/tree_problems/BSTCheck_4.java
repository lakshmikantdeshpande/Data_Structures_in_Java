// 57. Improve complexity of problem 56.
// n time 1 space

package tree_problems;

import tree.BST;

public class BSTCheck_4 {

	public static void main(String[] args) {

		/*-
		 *Let us create following BST      
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
		root = insert(root, 600);
		root = insert(root, 80);

		System.out.println(checkBST(root));
	}

	private static int last = Integer.MIN_VALUE;

	private static boolean checkBST(BST root) {
		if (root == null)
			return true;

		if (!checkBST(root.left))
			return false;

		if (root.data < last)
			return false;
		last = root.data;

		return checkBST(root.right);
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