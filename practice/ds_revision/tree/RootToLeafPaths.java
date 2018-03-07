package tree;

import java.util.ArrayList;

public class RootToLeafPaths {

    private static class TreeNode {
        TreeNode left, right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(-3);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);

        printRootToLeafPaths(root, new ArrayList<>());
    }

    private static void printRootToLeafPaths(TreeNode root, ArrayList<Integer> list) {
        if (root == null || list == null) {
            return;
        }

        list.add(root.data);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer aList : list) {
                stringBuilder.append(aList).append(",");
            }
            System.out.println(stringBuilder.toString());
            list.remove(list.size() - 1);
            return;
        }
        printRootToLeafPaths(root.left, list);
        printRootToLeafPaths(root.right, list);
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

}
