package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTDriver {

	public static void main(String[] args) {
		BST root = insert(null, 50);

		/*-
		 *Let us create following BST      
		 *       50                                   
		 *     /     \                                 
		 *    30      70                               
		 *   /  \    /  \                              
		 * 20   40  60   80 
		 */

		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 40);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 80);

		System.out.println("FIND");
		System.out.println(find(root, 20));
		System.out.println(findNode(root, 30).data);

		display(root);

		System.out.println("MIN");
		System.out.println(min(root).data);
		System.out.println(minRecursive(root).data);

		System.out.println("MAX");
		System.out.println(max(root).data);
		System.out.println(maxRecursive(root).data);

		System.out.println("BEFORE DELETING:");
		display(root);
		System.out.println("AFTER DELETING:");
		display(root = deleteNode(root, 50));

	}

	// n time 1 space
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

	// n time 1 space
	public static boolean find(BST root, int data) {
		if (root == null)
			return false;
		if (data > root.data)
			return find(root.right, data);
		else if (data < root.data)
			return find(root.left, data);
		return true;
	}

	// n time 1 space
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

	// n time 1 space
	public static BST min(BST root) {
		if (root == null)
			return null;
		while (root.left != null)
			root = root.left;
		return root;
	}

	// n time 1 space
	public static BST minRecursive(BST root) {
		if (root == null)
			return null;
		if (root.left == null)
			return root;
		else
			return minRecursive(root.left);
	}

	// n time 1 space
	public static BST max(BST root) {
		if (root == null)
			return null;

		while (root.right != null)
			root = root.right;
		return root;
	}

	// n time 1 space
	public static BST maxRecursive(BST root) {
		if (root == null)
			return null;

		if (root.right == null)
			return root;
		else
			return maxRecursive(root.right);
	}

	// n time 1 space
	public static BST deleteNode(BST root, int data) {
		if (root == null) {
			System.out.println("Required element does not exist in the tree");
			return null;
		}
		if (data < root.data)
			root.left = deleteNode(root.left, data);
		else if (data > root.data)
			root.right = deleteNode(root.right, data);
		else {
			// Node with only one child or no children
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data = min(root.right).data;
			root.right = deleteNode(root.right, root.data);
			// OR
			// root.data = max(root.left).data;
			// root.left = deleteNode(root.left, root.data);
		}

		return root;
	}

	// n time n space
	private static void display(BST root) {
		if (root == null)
			return;
		Queue<BST> queue = new LinkedList<BST>();
		queue.offer(root);
		queue.offer(null);
		System.out.println("***");

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
		System.out.println("***");
	}

}
