package tree;

import tree.AVL;

public class AVLRotations {

	public static void main(String[] args) {
		// left left
		AVL root = new AVL(6);
		root.left = new AVL(5);
		root.left.left = new AVL(3);

		root.right = new AVL(1);
		root.right.left = new AVL(9);
		root.right.right = new AVL(1);

	}

	public AVL static void insert(AVL root, int data) {
		if (root == null)
			return new AVL(data);
	}

}
