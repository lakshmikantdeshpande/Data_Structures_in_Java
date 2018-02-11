public class IsMirror {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.left = new TreeNode(8);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = getTree();
        TreeNode root2 = getTree();
        TreeNode temp = convertToMirror(root1);

        System.out.printf("Trees are %s", areMirrors(root2, temp) ? "identical" : "not identical");
    }

    private static boolean areMirrors(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        } else {
            return areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
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
