// 75. Generate a height balanced tree of height h (i.e. HB(0))
// n time log n space (because stack can be at max log n i.e. height of tree)
// INCORRECT / WRONG CODE, needs to be fixed

package tree_problems;

import tree.BST;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateHeightBalanced_2 {

    public static void main(String[] args) {
        printLevelOrder(buildHeightBalanced(1, 1 << 2));
    }

    public static BST buildHeightBalanced(int left, int right) {
        if (left > right)
            return null;

        int mid = left + ((right - 1) / 2);

        BST temp = new BST(mid);
        temp.left = buildHeightBalanced(left, mid - 1);
        temp.right = buildHeightBalanced(mid + 1, right);
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
