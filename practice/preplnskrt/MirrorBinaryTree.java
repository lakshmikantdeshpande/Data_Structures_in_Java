public class MirrorBinaryTree {

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
        StringBuilder stringBuilder = new StringBuilder();
        preorder(root, stringBuilder);
        String temp = stringBuilder.toString();
        stringBuilder.setLength(0);

        TreeNode root1 = convertToMirror(root);
        root1 = convertToMirror(root1);
        preorder(root, stringBuilder);
        System.out.println(temp.equals(stringBuilder.toString()));
    }

    private static void preorder(TreeNode root, StringBuilder stringBuilder) {
        if (root != null) {
            stringBuilder.append(root.data);
            preorder(root.left, stringBuilder);
            preorder(root.right, stringBuilder);
        }
    }

    private static TreeNode convertToMirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = convertToMirror(root.left);
        TreeNode right = convertToMirror(root.right);


        root.left = right;
        root.right = left;
        return root;
    }

}
