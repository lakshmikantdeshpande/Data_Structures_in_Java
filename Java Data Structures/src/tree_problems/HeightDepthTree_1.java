// 10. Find height or depth of a binary tree
// n time n space

package tree_problems;

import tree.TreeNode;

public class HeightDepthTree_1 {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(findDepth(root) - 1);
	}

	// recursive
	private static int findDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = findDepth(root.left);
		int right = findDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}

}
