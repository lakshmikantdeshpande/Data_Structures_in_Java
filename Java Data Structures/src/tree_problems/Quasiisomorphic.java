// 47. Check if given 2 trees are quasi-isomorphic. 
// (Structure can be made isomorphic by swapping sibling nodes, shape is important)
// n time n space

package tree_problems;

import tree.TreeNode;

public class Quasiisomorphic {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.right.left = new TreeNode(7);
		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(6);
		root1.right.left.left = new TreeNode(8);

		TreeNode root2;
		root2 = new TreeNode(1);
		root2.left = new TreeNode(5);
		root2.left.left = new TreeNode(3);
		root2.left.left.right = new TreeNode(7);
		root2.right = new TreeNode(6);
		root2.right.left = new TreeNode(8);
		root2.right.left.left = new TreeNode(4);
		root2.right.right = new TreeNode(2);
		root2.right.right.left = new TreeNode(546); // to test
		// values can be different but the structure must be same

		System.out.println(isQuasiisomorphic(root1, root2));
	}

	public static boolean isQuasiisomorphic(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		return ((isQuasiisomorphic(root1.left, root2.left) && isQuasiisomorphic(root1.right, root2.right))
				|| (isQuasiisomorphic(root1.left, root2.right) && isQuasiisomorphic(root1.right, root2.left)));
	}
}
