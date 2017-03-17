// 54. Find LCA of 2 given BST nodes.
// n time n space recursion stack (skewed trees)

package tree_problems;

import tree.BST;

public class LCAOfTwoNodesBST {

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

		System.out.println(LCA(root, root.left.left, root.left.right).data);
	}

	public static BST LCA(BST root, BST a, BST b) {
		if (root == null)
			return null;
		if (root == a || root == b)
			return root;

		// LCA should exist between 2 nodes
		// i.e. a root.data b OR b root.data a

		if (Math.max(a.data, b.data) < root.data) // a b root.data
			return LCA(root.left, a, b);
		else if (Math.min(a.data, b.data) > root.data) // root.data a b
			return LCA(root.right, a, b);
		else
			return root;
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
