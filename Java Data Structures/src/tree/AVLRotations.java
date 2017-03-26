// INCOMPLETE PROGRAM
// AVL Rotations
// To be reviewed again

package tree;

public class AVLRotations {

	public static void main(String[] args) {
		// left left
		AVL root1 = new AVL(6);
		root1.data = 3;
		root1.left = new AVL(5);
		root1.left.left = new AVL(3);

		root1.right = new AVL(1);
		root1.right.left = new AVL(9);
		root1.right.right = new AVL(1);

	}

	public static AVL leftLeftRotation(AVL x) {
		AVL w = x.left;
		x.left = w.right;
		w.right = x;
		x.height = Math.max(x.left.height, x.right.height) + 1;
		w.height = Math.max(w.left.height, x.height) + 1;
		return w;
	}

	public static AVL rightRightRotation(AVL w) {
		AVL x = w.right;
		w.right = x.left;
		x.left = w;

		w.height = Math.max(w.right.height, w.left.height) + 1;
		x.height = Math.max(x.right.height, w.height) + 1;
		return x;
	}

	public static AVL leftRightRotation(AVL z) {
		z.left = rightRightRotation(z.left);
		return leftLeftRotation(z);
	}

}
