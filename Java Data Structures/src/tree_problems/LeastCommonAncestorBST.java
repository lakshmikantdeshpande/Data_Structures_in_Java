// 52. Find shortest path between 2 nodes in a BST.
// n time 1 space (n space for recursion stack)

package tree_problems;

import tree.BST;

public class LeastCommonAncestorBST {

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

	private static BST LCA(BST root, BST a, BST b) {
		if (root == null)
			return null;
		if (root == a || root == b)
			return root;

		BST left = LCA(root.left, a, b);
		BST right = LCA(root.right, a, b);

		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
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
