// 84. Remove leaves of a BST.
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.BST;

public class RemoveLeaves_2 {

	public static void main(String[] args) {
		BST root = insert(null, 50);
		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 80);
		printLevelOrder(root);
		System.out.println("************");
		printLevelOrder(removeLeaves(root));

	}

	public static BST removeLeaves(BST root) {
		if (root != null) {
			if (root.left == null && root.right == null)
				root = null;
			else {
				root.left = removeLeaves(root.left);
				root.right = removeLeaves(root.right);
			}
		}

		return root;
	}

	// normal BST insertion
	public static BST insert(BST root, int data) {
		if (root == null)
			return new BST(data);
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		return root;
	}

	// helper function for printing tree in level order
	private static void printLevelOrder(BST root) {
		if (root == null)
			return;
		Queue<BST> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			BST temp = queue.poll();
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
