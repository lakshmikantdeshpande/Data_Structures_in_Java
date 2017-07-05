// AVL tree is a kind of tree, in which difference between heights of left and right subtree is 1

package tree;

public class AVL {
    // not an ideal structure
    // we should make these private and use setters, getters
    public int data;
    public int height;

    public AVL left;
    public AVL right;

    public AVL(int data) {
        this.data = data;
        this.height = 1;
    }
}
