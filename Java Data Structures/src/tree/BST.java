package tree;

public class BST {
	// not an ideal structure
	// we can make these private and use setters, getters
	public int data;
	public BST left;
	public BST right;

	public BST(int data) {
		this.data = data;
	}
}
