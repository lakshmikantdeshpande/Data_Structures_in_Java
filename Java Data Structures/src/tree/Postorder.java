// Preorder traversal
// N time N space

package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder {

	// Recursive
	public void doPostorder(TreeNode root) {
		if (root == null)
			return;
		doPostorder(root.left);
		doPostorder(root.right);
		System.out.print(root.data + " - ");
	}

	// Non recursive
	public ArrayList<Integer> doPostorderIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				// traverse from top to bottom
				// if curr has left or right child, push on stack, otherwise pop
				// out
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
			} else if (curr.left == prev) {
				if (curr.right != null)
					stack.push(curr.right);
			} else {
				result.add(curr.data);
				stack.pop();
			}
			prev = curr;
		}
		return result;
	}
}
