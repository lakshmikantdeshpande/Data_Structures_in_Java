// Inorder Traversal
// N time N space

package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {

	// Recursive
	public void doInorder(TreeNode root) {
		if (root == null)
			return;
		doInorder(root.left);
		System.out.print(root.data +" - ");
		doInorder(root.right);
	}

	// Non Recursive
	public ArrayList<Integer> doInorderIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		boolean done = false;

		while (!done) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					done = true;
				else {
					curr = stack.pop();
					result.add(curr.data);
					curr = curr.right;
				}
			}
		}
		return result;
	}
}
