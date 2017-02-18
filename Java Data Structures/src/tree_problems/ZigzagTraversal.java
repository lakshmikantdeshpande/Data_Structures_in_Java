// 34. Traverse a binary tree in zigzag order
// n + n time n space

package tree_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class ZigzagTraversal {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(zigzag(root));
	}

	private static ArrayList<ArrayList<Integer>> zigzag(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		boolean reverse = true;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		ArrayList<Integer> current = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp != null) {
				current.add(temp.data);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				if (reverse) {
					ArrayList<Integer> array = new ArrayList<Integer>(current);
					result.add(array);
					current.clear();
				} else {
					Stack<Integer> stack = new Stack<Integer>();
					stack.addAll(current);
					ArrayList<Integer> array = new ArrayList<Integer>();
					while (!stack.isEmpty())
						array.add(stack.pop());
					result.add(array);
					current.clear();
				}

				if (!queue.isEmpty()) {
					queue.offer(null);
					reverse = !reverse;
				}
			}
		}
		return result;
	}
}
