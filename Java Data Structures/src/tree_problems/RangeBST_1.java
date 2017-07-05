// 69. Print all the elements from a BST in the given range.
// n time n space for recursion

package tree_problems;

import tree.BST;

public class RangeBST_1 {

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

        printRange(root, 31, 50);

    }

    private static void printRange(BST root, int low, int high) {
        if (root == null || low > high)
            return;

        if (root.data >= low)
            printRange(root.left, low, high);
        if (root.data >= low && root.data <= high)
            System.out.println(root.data);
        if (root.data <= high)
            printRange(root.right, low, high);
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
