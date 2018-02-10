public class FindMinMaxTree {

    private static class TreeNode {
        int data;
        TreeNode left, right;

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

        System.out.println(findMin(root));
        System.out.println(findMax(root));
    }

    private static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int center = root.data;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        if (leftMax > center) {
            center = leftMax;
        }
        if (rightMax > center) {
            center = rightMax;
        }

        return center;
    }

    private static int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int center = root.data;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        if (leftMin < center) {
            center = leftMin;
        }
        if (rightMin < center) {
            center = rightMin;
        }

        return center;
    }

}
