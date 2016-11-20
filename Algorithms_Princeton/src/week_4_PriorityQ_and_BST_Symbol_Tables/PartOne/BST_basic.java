package week_4_PriorityQ_and_BST_Symbol_Tables.PartOne;

public class BST_basic {
	private static Node root;

	private static class Node {
		int key;
		int value;
		Node left, right;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static void put(int key, int value) {
		root = put(root, key, value);
	}

	private static Node put(Node root, int key, int value) {
		if (root == null)
			return new Node(key, value);

		if (key < root.key)
			root.left = put(root.left, key, value);
		else if (key > root.key)
			root.right = put(root.right, key, value);
		else if (key == root.key)
			root.value = value;
		return root;
	}

	public static int get(int key) {
		Node temp = root;
		while (temp != null) {
			if (key == temp.key)
				return temp.value;
			else if (key > temp.key)
				temp = temp.right;
			else if (key < temp.key)
				temp = temp.left;
		}
		return -1;
	}

	public static int minKey() {
		if (root == null)
			return -1;

		Node temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp.key;
	}

	public static int maxKey() {
		if (root == null)
			return -1;
		Node temp = root;
		while (temp.right != null)
			temp = temp.right;
		return temp.key;
	}

	public static int floor(int key) {

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(get(5));
		put(1, 4);
		put(1, 6);
		put(2, 5);
		put(4, 7);
		put(9, 4);
		System.out.println(get(9));
		System.out.println(minKey());
		System.out.println(maxKey());

	}

}
