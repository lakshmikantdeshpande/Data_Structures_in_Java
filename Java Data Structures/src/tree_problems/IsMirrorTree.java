// 28. Check if 2 trees are mirror trees of each other.
// n time n space

package tree_problems;

import tree.TreeNode;

public class IsMirrorTree {

	public static void main(String[] args) {
		TreeNode root1;
		root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);

		TreeNode root2;
		root2 = new TreeNode(1);
		root2.right = new TreeNode(2);
		root2.left = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		root2.right.left = new TreeNode(5);

		System.out.println(isMirror(root1, root2));
	}

	public static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		else
			return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
	}

}
