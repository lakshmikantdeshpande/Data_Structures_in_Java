// 23. Print all paths from root to leaf in a binary tree.
// n time n space

package tree_problems;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printPaths(root);
        paths(root, new ArrayList<>());
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

    private static void paths(TreeNode root, List<Integer> paths) {
        if (root == null || paths == null) {
            return;
        }

        paths.add(root.data);
        if (root.left == null || root.right == null) {
            for (int i : paths) {
                System.out.print(i + " ");
            }
            paths.remove(paths.size() - 1);
            System.out.println();
            return;
        }
        paths(root.left, paths);
        paths(root.right, paths);

        if (!paths.isEmpty()) {
            paths.remove(paths.size() - 1);
        }
    }

    private static void print(int[] paths, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(paths[i] + " ");
        System.out.println();
    }
}
