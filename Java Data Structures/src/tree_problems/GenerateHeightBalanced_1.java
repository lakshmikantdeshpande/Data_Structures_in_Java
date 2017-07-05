// 75. Generate a height balanced tree of height h (i.e. HB(0))
// n time log n space (because stack can be at max log n i.e. height of tree)

package tree_problems;

import tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateHeightBalanced_1 {

    public static int count = 0;

    public static void main(String[] args) {
        printLevelOrder(buildHeightBalanced(5));
    }

    public static BST buildHeightBalanced(int height) {
        BST temp;
        if (height <= 0)
            return null;

        temp = new BST(0);
        temp.left = buildHeightBalanced(height - 1);
        temp.data = count++;
        temp.right = buildHeightBalanced(height - 1);
        return temp;
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
