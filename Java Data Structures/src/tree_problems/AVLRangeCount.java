// 81. Find number of nodes within the given range in an AVL.
// log n time n space recursion

package tree_problems;

import tree.AVL;

public class AVLRangeCount {

    public static void main(String[] args) {
        AVL root = new AVL(8);
        root.left = new AVL(6);
        root.left.left = new AVL(3);

        root.right = new AVL(10);
        root.right.left = new AVL(9);
        root.right.right = new AVL(11);

        System.out.println(rangeCount(root, 6, 10));
    }

    public static int rangeCount(AVL root, int low, int high) {
        if (root == null)
            return 0;

        if (root.data > high)
            return rangeCount(root.left, low, high);
        else if (root.data < low)
            return rangeCount(root.right, low, high);
        else if (root.data >= low && root.data <= high)
            return rangeCount(root.left, low, high) + rangeCount(root.right, low, high) + 1;
        else
            return 0; // eclipse yells without this statement
    }

}