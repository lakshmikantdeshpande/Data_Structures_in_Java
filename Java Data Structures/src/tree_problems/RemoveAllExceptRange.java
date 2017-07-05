// 85. Remove all the elements except the ones in the given range a, b. (inclusive).
// N time N space for recursion (avg case would be logn for both time and space)
// if it is an AVL tree, avg case time complexity is O(N)

package tree_problems;

import tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveAllExceptRange {

    public static void main(String[] args) {
        BST root = insert(null, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        printLevelOrder(root);
        System.out.println("********");
        printLevelOrder(prune(root, 40, 70));

    }

    public static BST prune(BST root, int left, int right) {
        if (root == null)
            return null;

        root.left = prune(root.left, left, right);
        root.right = prune(root.right, left, right);

        if (root.data >= left && root.data <= right)
            return root;

        if (root.data < left)
            return root.right;

        if (root.data > right)
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