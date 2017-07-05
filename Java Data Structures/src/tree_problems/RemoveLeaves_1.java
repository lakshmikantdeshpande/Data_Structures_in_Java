// 83. Remove all half nodes (which has only one child). Note that you should not touch leaves.
// n time logn space recursion

package tree_problems;

import tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveLeaves_1 {

    public static void main(String[] args) {
        BST root = insert(null, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        // root = insert(root, 60);
        // root = insert(root, 80);

        printLevelOrder(removeHalfNodes(root));

    }

    public static BST removeHalfNodes(BST root) {
        if (root == null)
            return null;

        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);

        if (root.left == null && root.right == null)
            return root;

        if (root.left == null)
            return root.right;

        if (root.right == null)
            return root.left;

        return root;
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

    // helper function for printing tree in level order
    private static void printLevelOrder(BST root) {
        if (root == null)
            return;
        Queue<BST> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            BST temp = queue.poll();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            } else {
                System.out.println();
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
    }

}