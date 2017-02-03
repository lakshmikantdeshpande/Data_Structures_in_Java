// 20. Find diameter/width of a tree. (No. of nodes on longest path between 2 leaves of a tree)

package tree_problems;

import tree.TreeNode;

public class Diameter_Width_1 {

	public static void main(String[] args) {
		TreeNode root;
		// root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		System.out.println(diameterOfTree(root));
		System.out.println(diameter(root));
	}

	static int diameter = 0;

	public static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int left = diameterOfTree(root.left);
		int right = diameterOfTree(root.right);
		if (left + right > diameter)
			diameter = left + right;
		return Math.max(left, right) + 1;
	}

	// alternative method
	public static int diameter(TreeNode root) {
		if (root == null)
			return 0;

		// int len1 = height(root.left) + height(root.right) + 3;
		int len1 = height(root.left) + height(root.right);
		int len2 = Math.max(diameter(root.left), diameter(root.right));

		return Math.max(len1, len2);
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);

		return (left > right) ? left + 1 : right + 1;
	}

}
