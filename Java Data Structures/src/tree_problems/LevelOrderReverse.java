// 9. Print level order data in normal and reverse order ;)
// n+n time n+n+n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class LevelOrderReverse {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		reverseLevelOrder(root);
	}

	private static void reverseLevelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> levelorder = new LinkedList<>(); // for levelorder
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null)
				queue.offer(temp.left);
			if (temp.right != null)
				queue.offer(temp.right);
			stack.push(temp);
			levelorder.offer(temp);
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop().data + " ");
		System.out.println();

		while (!levelorder.isEmpty())
			System.out.print(levelorder.poll().data + " "); // for levelorder

	}

}
