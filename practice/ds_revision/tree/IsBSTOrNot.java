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
        System.out.println(isBSTAlternative(bst));
        System.out.println(checkIfTreeIsBst(bst, Integer.MIN_VALUE, Integer.MAX_VALUE));
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

    private static int last = Integer.MIN_VALUE;

    private static boolean isBSTAlternative(BST root) {
        if (root == null)
            return true;

        if (!isBSTAlternative(root.left))
            return false;

        if (root.data < last)
            return false;
        last = root.data;

        return isBSTAlternative(root.right);
    }

    private static boolean checkIfTreeIsBst(BST root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return (checkIfTreeIsBst(root.left, min, root.data - 1) && checkIfTreeIsBst(root.right, root.data + 1, max));
    }

}
