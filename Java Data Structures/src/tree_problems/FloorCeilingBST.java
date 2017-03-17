// 65. Find floor and ceiling in BST.
// n time n space recursion

package tree_problems;

import tree.BST;

public class FloorCeilingBST {

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

		System.out.println(floor(root, 69).data);
		System.out.println(ceil(root, 71).data);

	}

	// find floor of given number
	private static BST floor(BST root, int key) {
		if (root == null)
			return null;

		if (root.data == key)
			return root;
		else if (root.data < key) {
			BST temp = floor(root.right, key);
			if (temp != null)
				return temp;
			else
				return root;
		} else
			return floor(root.left, key);
	}

	// find ceil of given number
	private static BST ceil(BST root, int key) {
		if (root == null)
			return null;

		if (root.data == key)
			return root;
		else if (root.data > key) {
			BST temp = ceil(root.left, key);
			if (temp != null)
				return temp;
			else
				return root;
		} else
			return ceil(root.right, key);
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
