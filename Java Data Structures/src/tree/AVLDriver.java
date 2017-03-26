package tree;

public class AVLDriver {

	public static void main(String[] args) {
		AVL root = new AVL(8);
		root.height = 2;
		root.left = new AVL(6);
		root.left.height = 1;
		root.left.left = new AVL(3);
		root.left.height = 0;

		root.right = new AVL(10);
		root.right.height = 1;
		root.right.left = new AVL(9);
		root.right.left.height = 0;
		root.right.right = new AVL(11);
		root.right.right.height = 0;

		System.out.println(height(root));
		System.out.println(getHeight(root)); // prints height + 1
	}

	// O(1) time
	public static int height(AVL root) {
		if (root == null)
			return -1;
		return root.height;
	}

	// n time
	private static int getHeight(AVL root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return left >= right ? left + 1 : right + 1;
	}

}
