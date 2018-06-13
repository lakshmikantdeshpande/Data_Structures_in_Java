public class FindElementInTree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(98);
        root.left.left = new TreeNode(8456);
        root.left.right = new TreeNode(45);
        root.right.left = new TreeNode(54564);
        root.right.right = new TreeNode(455);

        System.out.println(findElementInTree(root, 98));
    }

    private static boolean findElementInTree(TreeNode root, int data) {
        return root != null && (root.data == data || findElementInTree(root.left, data) || findElementInTree(root.right, data));
    }

}
