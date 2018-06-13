public class LCA {

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

        System.out.println(lca(root, 7, 8));
    }

    private static TreeNode lca(TreeNode root, int one, int two) {
        if (root == null) {
            return null;
        }

        if (root.data == one || root.data == two) {
            return root;
        }

        TreeNode left = lca(root.left, one, two);
        TreeNode right = lca(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

}
