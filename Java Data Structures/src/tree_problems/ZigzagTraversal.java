// 34. Traverse a binary tree in zigzag order
// n + n time n space

package tree_problems;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(zigzag(root));
    }

    private static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;

        while (!queue.isEmpty()) {
            final int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (left) {
                        list.add(node.data);
                    } else {
                        list.addFirst(node.data);
                    }

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            resultList.add(list);
            left = !left;
        }

        return resultList;
    }
}
