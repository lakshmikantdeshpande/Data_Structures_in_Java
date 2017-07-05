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

        for (int key : map.keySet())
            System.out.println("Position: " + key + " Sum: " + map.get(key));
    }

    private static void sum(Map<Integer, Integer> map, TreeNode root, int key) {
        if (root.left != null)
            sum(map, root.left, key - 1);
        if (root.right != null)
            sum(map, root.right, key + 1);
        int data = 0;

        if (map.containsKey(key))
            data = map.get(key);
        map.put(key, root.data + data);
    }

}
