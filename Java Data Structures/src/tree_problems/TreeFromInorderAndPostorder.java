// 30. Build tree from given inorder and postorder string.
// n time 1 space

package tree_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class TreeFromInorderAndPostorder {

	public static void main(String[] args) {
		// DBEAFC // inorder 425163
		// ABDECF // postorder 452631

		List<Integer> inorder = new ArrayList<Integer>();
		inorder.add(4);
		inorder.add(2);
		inorder.add(5);
		inorder.add(1);
		inorder.add(6);
		inorder.add(3);

		List<Integer> postorder = new ArrayList<Integer>();
		postorder.add(4);
		postorder.add(5);
		postorder.add(2);
		postorder.add(6);
		postorder.add(3);
		postorder.add(1);

		levelOrder(buildTree(postorder, inorder));
	}

	private static TreeNode buildTree(List<Integer> postorder, List<Integer> inorder) {
		if (postorder.size() == 0 || inorder.size() != postorder.size())
			return null;
		return build(postorder, 0, postorder.size() - 1, inorder, 0, inorder.size() - 1);
	}

	private static TreeNode build(List<Integer> postorder, int postStart, int postEnd, List<Integer> inorder,
			int inStart, int inEnd) {
		if (postStart > postEnd || inStart > inEnd)
			return null;

		int val = postorder.get(postEnd);
		int offset = inStart;
		TreeNode curr = new TreeNode(val);

		for (; offset < inEnd; offset++)
			if (inorder.get(offset) == val)
				break;

		curr.left = build(postorder, postStart, postStart + offset - inStart - 1, inorder, inStart, offset - 1);
		curr.right = build(postorder, postStart + offset - inStart, postEnd - 1, inorder, offset + 1, inEnd);
		return curr;
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
	}

}
