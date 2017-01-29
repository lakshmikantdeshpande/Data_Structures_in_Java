// 3. Write code to find an element in a binary tree (recursion)
// n time n space

package tree_problems;

import tree.TreeNode;

public class SearchElement_1 {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(findElement(root, 5));
	}

	private static boolean findElement(TreeNode root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;
		return findElement(root.left, data) || findElement(root.right, data);
	}

}
