// 80. Generate an AVL tree with minimum number of nodes for a given height
// for min. no. of nodes, we can fill 1 level with h-1 nodes & other with h-2
// n time logn space recursion

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.AVL;

public class GenerateAVL {

	public static void main(String[] args) {
		printLevelOrder(buildHeightBalanced(3));
	}

	public static int count = 0;

	public static AVL buildHeightBalanced(int height) {
		AVL temp;
		if (height <= 0)
			return null;

		temp = new AVL(0);
		temp.left = buildHeightBalanced(height - 1);
		temp.data = count++;
		temp.right = buildHeightBalanced(height - 2);
		temp.height = height;
		return temp;
	}

	// helper function for printing tree in level order
	private static void printLevelOrder(AVL root) {
		if (root == null)
			return;
		Queue<AVL> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			AVL temp = queue.poll();
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
