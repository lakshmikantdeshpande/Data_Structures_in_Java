// 55. Check if the given binary tree is a BST or not.
// n time n space
// WRONG RESULTS SOMETIME

package tree_problems;

import tree.BST;

public class BSTCheck_1 {

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
        if (root.left != null && root.left.data > root.data)
            return false;

        // if right < root
        if (root.right != null && root.right.data < root.data)
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

}
