// 1. Find the max element in a binary tree (recursion)
// Solution buk n time n space
// my solution n+n time n space
// my solution  n time n space (elegant ;))

package tree_problems;

import tree.TreeNode;

import java.util.StringTokenizer;

public class MaxElement_1 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(findMax(root));
        System.out.println(findMaxMyVersion(root));
        maxInorder(root);
        System.out.println(max);
    }

    // book function
    private static int findMax(TreeNode root) {
        if (root == null)
            return 0;

        int maxvalue = Integer.MIN_VALUE;

        int leftmax = findMax(root.left);
        int rightmax = findMax(root.right);

        if (leftmax > rightmax)
            maxvalue = leftmax;
        else
            maxvalue = rightmax;

        if (root.data > maxvalue)
            maxvalue = root.data;

        return maxvalue;
    }

    // n+n time n space
    private static int findMaxMyVersion(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        inorder(root, strb);
        int max = Integer.MIN_VALUE;
        StringTokenizer str = new StringTokenizer(strb.toString());
        while (str.hasMoreTokens()) {
            int temp = Integer.parseInt(str.nextToken());
            if (max < temp)
                max = temp;
        }
        return max;
    }

    public static void inorder(TreeNode root, StringBuilder strb) {
        if (root == null)
            return;
        inorder(root.left, strb);
        strb.append(root.data + " ");
        inorder(root.right, strb);
    }

    public static void maxInorder(TreeNode root) {
        if (root == null)
            return;
        maxInorder(root.left);
        if (root.data > max)
            max = root.data;
        maxInorder(root.right);
    }
}