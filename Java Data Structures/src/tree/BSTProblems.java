package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTProblems {

	public static void main(String[] args) {
		BST root = insert(null, 2);
		root = insert(root, 1);
		root = insert(root, 3);

		System.out.println(find(root, 2));
		System.out.println(findNode(root, 3).data);
		display(root);
	}

	public static BST insert(BST root, int data) {
		if (root == null)
			root = new BST(data);
		else {
			if (data < root.data)
				root.left = insert(root.left, data);
			else
				root.right = insert(root.right, data);
		}
		return root;
	}

	public static boolean find(BST root, int data) {
		if (root == null)
			return false;
		if (data > root.data)
			return find(root.right, data);
		else if (data < root.data)
			return find(root.left, data);
		return true;
	}

	public static BST findNode(BST root, int data) {
		if (root == null)
			return null;
		if (root.data == data)
			return root;
		else if (data < root.data)
			return findNode(root.left, data);
		else
			return findNode(root.right, data);
	}

	// TODO:
	// BST minimum
	public static BST min(BST root) {
		if (root == null)
			return null;
		while (root.left != null)
			root = root.left;
		return root;
	}

	private static void display(BST root) {
		if (root == null)
			return;
		Queue<BST> queue = new LinkedList<BST>();
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
				if (!queue.isEmpty())
					queue.offer(null);
				System.out.println();
			}
		}
	}

}
