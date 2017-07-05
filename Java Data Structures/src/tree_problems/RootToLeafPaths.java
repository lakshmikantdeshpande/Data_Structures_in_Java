// 23. Print all paths from root to leaf in a binary tree.
// n time n space

package tree_problems;

import tree.TreeNode;

public class RootToLeafPaths {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printPaths(root);
    }

    public static void printPaths(TreeNode root) {
        int[] paths = new int[256];
        printPaths(root, paths, 0); // root, paths array, length of path
    }

    private static void printPaths(TreeNode root, int[] paths, int len) {
        if (root == null)
            return;

        // append this node to the paths array
        paths[len++] = root.data;

        // Following code eases visualization
        //
        // System.out.print("{");
        // for (int i = 0; i < len; i++) {
        // System.out.print(paths[i] + " ");
        // }
        // System.out.println("}");

        // if its a leaf, print the path
        if (root.left == null && root.right == null)
            print(paths, len);
        else {
            printPaths(root.left, paths, len);
            printPaths(root.right, paths, len);
        }
    }

    private static void print(int[] paths, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(paths[i] + " ");
        System.out.println();
    }
}
