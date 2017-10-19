public class Tree_Traversals {
	private Node root;
	
	private static class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
		}
	}

	private void inorder(Node curr_root) {
		if (curr_root != null) {
			inorder(curr_root.left);
			System.out.println(curr_root.data);
			inorder(curr_root.right);
		}
	}

	
	private void preorder(Node curr_root) {
		if (curr_root != null) {
			System.out.println(curr_root.data);
			preorder(curr_root.left);
			preorder(curr_root.right);
		}
	}

	private void postorder(Node curr_root) {
		if (curr_root != null) {
			postorder(curr_root.left);
			postorder(curr_root.right);
			System.out.println(curr_root.data);
		}
	}


	public static void main(String[] args) {
		Tree_Traversals tt = new Tree_Traversals();

		tt.root = new Tree_Traversals.Node(2);	
		tt.root.left = new Tree_Traversals.Node(1);
		tt.root.right = new Tree_Traversals.Node(3);
		
		tt.preorder(tt.root);
		System.out.println("*****");
		tt.inorder(tt.root);	
		System.out.println("*****");
		tt.postorder(tt.root);	
		System.out.println("*****");
	}
}
