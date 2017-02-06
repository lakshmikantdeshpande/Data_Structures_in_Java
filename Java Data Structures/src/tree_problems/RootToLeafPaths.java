// 23. Print all paths from root to leaf in a binary tree.
// n time n space

package tree_problems;

import tree.TreeNode;

public class RootToLeafPaths {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

	}

	public static void printPaths(TreeNode root) {
		int[] paths = new int[256];
		printPaths(root, paths, 0); // root, paths array, length of path 
	}

	private static void printPaths(TreeNode root, int[] paths, int len) {
		if (root == null)
			return;
		
		// append this node to the paths array
		paths[len++] = root.data;
		
	}
}
