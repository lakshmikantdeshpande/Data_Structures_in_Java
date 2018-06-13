import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {

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
        root.right.right.right = new TreeNode(546);
        root.right.right.right.right = new TreeNode(5646);

        System.out.printf("The deepest node is %d\n", findDeepestNode(null));
        System.out.printf("The deepest node is %d\n", findDeepestNode(root));
    }

    private static int findDeepestNode(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return temp.data;
    }

}
