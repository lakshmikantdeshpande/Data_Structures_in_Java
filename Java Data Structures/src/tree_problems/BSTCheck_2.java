// 56. Is there a better and correct approach for problem 55 ?
// n*n time n space (recursion stack) 
// WRONG RESULTS SOMETIME

package tree_problems;

import tree.BST;

public class BSTCheck_2 {

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

        System.out.println(checkBST(root) ? "It is a BST" : "It is not a BST");
    }

    private static boolean checkBST(BST root) {
        if (root == null)
            return true;

        // if left > root
        if (root.left != null && max(root.left) > root.data)
            return false;

        // if right < root
        if (root.right != null && min(root.right) < root.data)
            return false;

        if (!checkBST(root.left) || !checkBST(root.right))
            return false;

        return true;
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

    // n time 1 space
    public static int max(BST root) {
        if (root == null)
            return -1;

        while (root.right != null)
            root = root.right;
        return root.data;
    }

    // n time 1 space
    public static int min(BST root) {
        if (root == null)
            return -1;

        while (root.left != null)
            root = root.left;
        return root.data;
    }

}
