package tree_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class PossibleBSTs {

	public static void main(String[] args) {
		for (TreeNode node : generateTrees(3))
			levelOrder(node);
	}

	public static ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0)
			return generateTrees(1, 0);
		return generateTrees(1, n);
	}

	public static ArrayList<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> trees = new ArrayList<>();

		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++) {
			for (TreeNode left : generateTrees(start, i - 1)) {
				for (TreeNode right : generateTrees(i + 1, end)) {
					TreeNode Tree = new TreeNode(i);
					Tree.left = left;
					Tree.right = right;
					trees.add(Tree);
				}
			}
		}
		return trees;
	}

	public static void levelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();

			if (temp != null) {
				System.out.print(temp.data + " ");
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
		System.out.println("********");
	}
}
