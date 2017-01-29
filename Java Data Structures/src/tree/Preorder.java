// Preorder Traversal
// N time N space

package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder {

	// Recursive
	public void doPreorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data +" - ");
		doPreorder(root.left);
		doPreorder(root.right);
	}

	// Non recursive
	public ArrayList<Integer> doPreorderInterative(TreeNode root) {
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
}
