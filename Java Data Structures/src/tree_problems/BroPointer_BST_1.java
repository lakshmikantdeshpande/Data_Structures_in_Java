// Connect same level bro pointers.
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

public class BroPointer_BST_1 {

	static class BroBST {
		int data;
		BroBST left, right;
		BroBST next;

		public BroBST(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		BroBST root = insert(null, 50);
		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 80);

		printLevelOrder(linkBroz(root));
		printBro(root.left);
		printBro(root.left.left);

	}

	public static BroBST linkBroz(BroBST root) {
		if (root == null)
			return null;

		Queue<BroBST> queue = new LinkedList<BroBST>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			BroBST temp = queue.poll();

			if (temp != null) {
				temp.next = queue.peek();

				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			} else {
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}

		return root;
	}

	private static void printBro(BroBST root) {
		if (root == null)
			return;

		while (root != null) {
			System.out.print(root.data + " -> ");
			root = root.next;
		}
		System.out.println();
	}

	// normal BroBST insertion
	public static BroBST insert(BroBST root, int data) {
		if (root == null)
			return new BroBST(data);
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		return root;
	}

	// helper function for printing tree in level order
	private static void printLevelOrder(BroBST root) {
		if (root == null)
			return;
		Queue<BroBST> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			BroBST temp = queue.poll();
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