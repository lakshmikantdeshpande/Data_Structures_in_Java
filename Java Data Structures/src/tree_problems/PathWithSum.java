// 24. Check path in binary tree with given sum.
// n time n space

package tree_problems;

import tree.TreeNode;

public class PathWithSum {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(pathWithSum(root, 7));
	}

	public static boolean pathWithSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data == sum)
			return true;
		else
			return pathWithSum(root.left, sum - root.data) || pathWithSum(root.right, sum - root.data);
	}

}
