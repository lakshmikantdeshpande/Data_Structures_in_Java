package tree_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class ExpressionTreeFromPostfix {

	public static void main(String[] args) {
		levelOrderPrint(buildTree(new char[] { 'A', 'B', 'C', '*', '+', 'D',
				'/' }, 7));
	}

	public static TreeNode buildTree(char[] postfix, int size) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		for (int i = 0; i < size; i++) {
			// if character is not an operator (i.e. is an operand)
			if (postfix[i] != '+' && postfix[i] != '-' && postfix[i] != '/'
					&& postfix[i] != '*') {
				TreeNode node = new TreeNode(postfix[i]);
				stack.push(node);
			} else {
				TreeNode right = stack.pop();
				TreeNode left = stack.pop();

				TreeNode node = new TreeNode(postfix[i]);
				node.left = left;
				node.right = right;
				stack.push(node);
			}
		}
		return stack.firstElement();
	}

	public static void levelOrderPrint(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp != null) {
				System.out.print((char) temp.data + " ");
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				System.out.println();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
		System.out.println("************************");
	}

}