public class BuildBinaryTreeFromPreOrderInOrder {

    private static class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        TreeNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        char[] preorder = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] inorder = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        TreeNode root = buildTreeFromPreorderInorder(preorder, inorder);
        inorder(root);
    }

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private static TreeNode buildTreeFromPreorderInorder(char[] preorder, char[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(char[] preorder, int preStart, int preEnd, char[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        char data = preorder[preStart];
        TreeNode node = new TreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (inorder[offset] == data) {
                break;
            }
        }
        node.left = buildTree(preorder, preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1);
        node.right = buildTree(preorder, preStart + offset - inStart + 1, preEnd, inorder, offset + 1, inEnd);
        return node;
    }

}
