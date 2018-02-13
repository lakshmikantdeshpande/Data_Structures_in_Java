import java.util.ArrayList;

public class FindAllPaths {

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

        printAllPaths(root);
    }

    private static void printAllPaths(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        printAllPaths(root, list);
    }

    private static boolean printAllPaths(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null || arrayList == null) {
            return false;
        }

        arrayList.add(root.data);
        if (root.left == null && root.right == null) {
            print(arrayList);
            arrayList.remove(arrayList.size() - 1);
            return true;
        }

        printAllPaths(root.left, arrayList);
        printAllPaths(root.right, arrayList);

        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return false;
    }

    private static void print(ArrayList<Integer> list) {
        System.out.println(list.toString());
    }

}
