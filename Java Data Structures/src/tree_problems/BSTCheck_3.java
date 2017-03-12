// 57. Improve complexity of problem 56
// n time n space (recursion stack)
// WRONG RESULTS SOMETIME

package tree_problems;

import tree.BST;

public class BSTCheck_3 {

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
		root = insert(root, 60);
		root = insert(root, 80);

		System.out
				.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean checkBST(BST root, int min, int max) {
		if (root == null)
			return true;

		return (root.data > min && root.data < max
				&& checkBST(root.left, min, root.data) && checkBST(root.right,
					root.data, max));
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