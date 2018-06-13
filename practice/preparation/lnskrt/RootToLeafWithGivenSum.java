public class RootToLeafWithGivenSum {

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

        System.out.println(doesSumPathExist(root, 6, 0));
    }

    private static boolean doesSumPathExist(TreeNode root, int sum, int current) {
        if (root == null) {
            return false;
        }

        current += root.data;

        if (current == sum && root.left == null && root.right == null) {
            return true;
        }

        return doesSumPathExist(root.left, sum, current) ||
                doesSumPathExist(root.right, sum, current);
    }

}
