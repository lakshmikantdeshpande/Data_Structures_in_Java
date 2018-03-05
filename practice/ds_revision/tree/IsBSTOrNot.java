package tree;

public class IsBSTOrNot {
    private static class BST {
        BST left, right;
        int data;

        BST(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(0);
        bst.left = new BST(-1);
        bst.right = new BST(1);

        System.out.println(isBst(bst));
    }

    private static boolean isBst(BST root) {
        if (root == null)
            return true;

        // if left > root.data
        if (root.left != null && root.left.data > root.data)
            return false;

        // if right < root.data
        if (root.right != null && root.right.data < root.data)
            return false;

        return isBst(root.left) && isBst(root.right);
    }

}
