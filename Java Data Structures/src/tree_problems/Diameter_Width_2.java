// 21. Find width of a binary tree (diameter). 
// The diameter of a tree is maximum number of nodes at any level (depth) in the tree.

package tree_problems;

import tree.TreeNode;

public class Diameter_Width_2 {

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

		System.out.println(width(root));
	}

	public static int width(TreeNode root) {
		int max = 0;
		int height = HeightDepthTree_3.findDepth(root);

		for (int i = 0; i <= height; i++) {
			int temp = width(root, i);
			if (temp > max)
				max = temp;
		}
		return max;
	}

	private static int width(TreeNode root, int depth) {
		if (root == null)
			return 0;
		else {
			if (depth == 0)
				return 1;
			else
				return width(root.left, depth - 1) + width(root.right, depth - 1);
		}
	}
}
