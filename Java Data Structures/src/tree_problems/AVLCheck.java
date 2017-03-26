// 79. Check if the given BST is an AVL tree or not
// n time n space for stack

package tree_problems;

import tree.BST;

public class AVLCheck {

	public static void main(String[] args) {
		BST root = new BST(8);
		root.left = new BST(6);
		root.left.left = new BST(3);

		root.right = new BST(10);
		root.right.left = new BST(9);
		root.right.right = new BST(11);

		// root.right.left.right = new BST(SOMETHING);
		// root.right.left.right.left = new BST(SOMETHING);

		System.out.println(isAVL(root));

	}

	public static boolean isAVL(BST root) {
		if (root == null)
			return true;
		return (isAVL(root.left) && isAVL(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);
	}

	private static int getHeight(BST root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return left >= right ? left + 1 : right + 1;
	}

}
