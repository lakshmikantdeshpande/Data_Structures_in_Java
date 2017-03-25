// 19. Check if two trees are structurally identical
// n time n space

package tree_problems;

import tree.TreeNode;

public class StructurallyIdentical {

	public static void main(String[] args) {
		TreeNode root1;
		root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);

		TreeNode root2;
		root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		// root2.left.right = new TreeNode(4);

		System.out.println(areSame(root1, root2));

	}

	private static boolean areSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		return areSame(root1.left, root2.left) && areSame(root1.right, root2.right);
	}

}
