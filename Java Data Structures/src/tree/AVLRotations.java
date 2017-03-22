package tree;

public class AVLRotations {

	public static void main(String[] args) {
		// left left
		AVL root = new AVL(6);
		root.height = 2;
		root.left = new AVL(6);
		root.left.height = 1;
		root.left.left = new AVL(3);
		root.left.height = 0;

		root.right = new AVL(1);
		root.right.height = 1;
		root.right.left = new AVL(9);
		root.right.left.height = 1;
		root.right.right = new AVL(1);
		root.right.right.height = 1;

	}

}
