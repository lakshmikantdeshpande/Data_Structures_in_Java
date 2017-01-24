package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder {

	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}

	// Recursive
	public void Preorder(TreeNode root) {
		if (root != null) {
			Preorder(root.left);
			System.out.println(root.data);
			Preorder(root.right);
		}
	}

	// Non recursive
	public ArrayList<Integer> PreorderInterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.add(temp.data);

			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
