import java.util.ArrayList;

public class RootToLeafPaths {

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

        printRootToLeafPaths(root, new ArrayList<>());
    }

    private static void printRootToLeafPaths(TreeNode root, ArrayList<Integer> list) {
        if (root == null || list == null) {
            return;
        }

        list.add(root.data);
        if (root.left == null && root.right == null) {
            printPaths(list);
            list.remove(list.size() - 1);
            return;
        }
        printRootToLeafPaths(root.left, list);
        printRootToLeafPaths(root.right, list);
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }

    private static void printPaths(ArrayList<Integer> list) {
        System.out.println(list.toString());
    }

}
