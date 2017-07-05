package tree_problems;

import tree.TreeNode;

public class TopView {

    void top_view(TreeNode root) {
        if (root == null)
            return;
        topview(root.left, true);
        if (root.left != null || root.right != null)
            System.out.print(root.data + " ");
        topview(root.right, false);
    }

    // if (left) then go left else right
    void topview(TreeNode root, boolean left) {
        if (root == null)
            return;
        if (left) {
            topview(root.left, true);
            System.out.print(root.data + " ");
        } else {
            System.out.print(root.data + " ");
            topview(root.right, false);
        }
    }

}
