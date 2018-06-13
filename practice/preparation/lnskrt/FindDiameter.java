public class FindDiameter {

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
        root.right.right = new TreeNode(455);
        root.right.right.right = new TreeNode(455);
        root.right.right.right.right = new TreeNode(455);

        System.out.println(findDiameterThroughRoot(root));
    }

    private static int findDiameterThroughRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findHeight(root.left) + findHeight(root.right);
    }

    private static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return 1 + Math.max(left, right);
    }

    private static int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);

        return Math.max(leftHeight + rightHeight + 1, leftDiameter + rightDiameter);
    }

}
