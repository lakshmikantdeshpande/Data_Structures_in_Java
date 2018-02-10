public class StructurallyIdenticalTrees {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(98);
        root1.left.left = new TreeNode(8456);
        root1.right.right = new TreeNode(455);
        root1.right.right.right = new TreeNode(455);
        root1.right.right.right.right = new TreeNode(455);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(98);
        root2.left.left = new TreeNode(8456);
        root2.right.right = new TreeNode(455);
        root2.right.right.right = new TreeNode(455);
        root2.right.right.right.right = new TreeNode(455);

        System.out.printf("The given two trees are %s", areTreesStructurallyIdentical(root1, root2) ? "identical" : "not identical");
    }

    private static boolean areTreesStructurallyIdentical(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }

        if (rootA == null || rootB == null) {
            return false;
        }

        return areTreesStructurallyIdentical(rootA.left, rootB.left) && areTreesStructurallyIdentical(rootA.right, rootB.right);
    }

}
