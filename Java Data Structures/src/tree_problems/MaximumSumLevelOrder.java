// 22. Find the level in the tree which has the maximum sum in the binary tree.
// n time n space
// (Found out maximum sum in a level)

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class MaximumSumLevelOrder {

	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(maxSumInLevelOrder(root));
	}

	public static int maxSumInLevelOrder(TreeNode root) {
		if (root == null)
			return 0;

		int max = 0, current = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp != null) {
				current += temp.data;
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				if (current > max)
					max = current;
				current = 0;
				if (!queue.isEmpty())
					queue.offer(null);

			}
		}
		return max;
	}
}
