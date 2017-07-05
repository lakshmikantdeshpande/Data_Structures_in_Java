// 33. Find least common ancestors of two nodes of a binary tree
// n time n space

package tree_problems;

import tree.TreeNode;

public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(LCA(root, root.left.left, root.left.right).data);
    }

    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return null;
        if (root == a || root == b)
            return root;

        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);

        if (left != null && right != null)
            return root;
        else
            return left != null ? left : right;
    }

}
