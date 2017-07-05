// 25. Find sum of all the elements in the tree.
// n time n space

package tree_problems;

import tree.TreeNode;

public class TreeSum_1 {

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sum(root));
    }

    private static int sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

}
