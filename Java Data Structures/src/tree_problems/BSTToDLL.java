// 59. Convert a BST to circular DLL with space complexity 1.
// n time 1 space

package tree_problems;

import tree.BST;

import java.io.PrintStream;

public class BSTToDLL {

    public static BST prev = null;
    public static BST head = null;

    public static void main(String[] args) {

		/*-
         *
		 *       50
		 *     /     \
		 *    30      70
		 *   /  \    /  \
		 * 20   40  60   80
		 */

        BST root = insert(null, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        bstToDll(root);
        printDLL(head);
    }

    public static void bstToDll(BST root) {
        if (root == null)
            return;

        bstToDll(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bstToDll(root.right);
    }

    // print linked list
    private static void printDLL(BST head) {
        if (head == null)
            return;
        PrintStream ps = new PrintStream(System.out);

        while (head != null) {
            ps.print(head.data + " ");
            head = head.right;
        }

        ps.println();
        ps.flush();
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

}
