// 35. Find vertical sum of a binary tree.
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class VerticalSum {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        verticalSum(root);
    }

    private static void verticalSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sum(map, root, 0);
        System.out.println();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Position: " + entry.getKey() + " Sum: " + entry.getValue());
        }
    }

    private static void sum(Map<Integer, Integer> map, TreeNode root, int key) {
        if (root == null || map == null) {
            return;
        }
        int sum = map.getOrDefault(key, 0);
        map.put(key, sum + root.data);
        sum(map, root.left, key - 1);
        sum(map, root.right, key + 1);
    }

}
