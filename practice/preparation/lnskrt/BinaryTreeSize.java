import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSize {

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

        System.out.println(treeSize(root));
        System.out.println(treeSizeNonRecursive(root));
    }

    private static int treeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSize = root.left == null ? 0 : treeSize(root.left);
        int rightSize = root.right == null ? 0 : treeSize(root.right);
        return 1 + leftSize + rightSize;
    }

    private static int treeSizeNonRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ++i;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return i;
    }

}
