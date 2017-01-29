// 5. Insert an element in a binary tree (Recursive and non recursive)
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.Inorder;
import tree.TreeNode;

public class InsertElement {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		new Inorder().doInorder(root);
		System.out.println();
		new Inorder().doInorder(insertElement(root, 9));
		System.out.println();
		insertElementRecursive(root, 11);
		new Inorder().doInorder(root);

	}

	// non recursive
	// classic non recursive method, used for search, insert, find max etc
	private static TreeNode insertElement(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null)
				queue.offer(temp.left);
			else {
				temp.left = new TreeNode(data);
				return root;
			}
			if (temp.right != null)
				queue.offer(temp.right);
			else {
				temp.right = new TreeNode(data);
				return root;
			}
		}
		return root;
	}

	// recursive approach
	private static void insertElementRecursive(TreeNode root, int data) {
		if (root == null)
			root = new TreeNode(data);
		else
			insert(root, data);
	}

	private static void insert(TreeNode root, int data) {
		if (root.left == null)
			root.left = new TreeNode(data);
		else if (root.right == null)
			root.left = new TreeNode(data);
		else
			insert(root.right, data);
	}
}
