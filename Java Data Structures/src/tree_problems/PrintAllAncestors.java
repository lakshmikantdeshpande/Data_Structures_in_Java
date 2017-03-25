// 32. Print all the ancestors of a node in a binary tree.
// n time n space

package tree_problems;

import tree.TreeNode;

public class PrintAllAncestors {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// printAllAncestors(root, new TreeNode(5));
		printAllAncestors(root, root.left.right);
	}

	private static boolean printAllAncestors(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root.left == node || root.right == node || printAllAncestors(root.left, node)
				|| printAllAncestors(root.right, node)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}

}
