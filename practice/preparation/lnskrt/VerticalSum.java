import java.util.HashMap;
import java.util.Map;

public class VerticalSum {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.left = new TreeNode(8);

        verticalSum(root);
    }

    private static void verticalSum(TreeNode root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        getVerticalSum(root, map, 0);

        for (int key : map.keySet()) System.out.println(map.get(key));
    }

    private static void getVerticalSum(TreeNode root, Map<Integer, Integer> map, int c) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            getVerticalSum(root.left, map, c - 1);
        }
        if (root.right != null) {
            getVerticalSum(root.right, map, c + 1);
        }

        map.put(c, root.data + (map.getOrDefault(c, 0)));
    }

}
