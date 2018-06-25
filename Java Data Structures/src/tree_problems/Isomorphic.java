// 46. Check if given 2 trees are isomorphic. (Same structure, values may be different)
// n time n space

package tree_problems;

import tree.TreeNode;

public class Isomorphic {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2;
        root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(4); // to test
        // values can be different but the structure must be same

        System.out.println(isIsomorphic(root1, root2));
    }

    private static boolean isIsomorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right));
    }
}
