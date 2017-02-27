// basic structure of a generic tree (not restricted to 2 children)

package tree;

public class GenericTreeNode {
	public int data;
	public GenericTreeNode firstChild;
	public GenericTreeNode nextSibling;

	public GenericTreeNode(int data) {
		this.data = data;
	}
}
