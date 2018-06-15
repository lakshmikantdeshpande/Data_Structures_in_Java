import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeastCommonAncestor {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
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


        printLevelOrder(root);
        System.out.println(lowestCommonAncestor1(root, 8, 7));
        System.out.println(lowestCommonAncestor2(root, 8, 7));
    }

    private static boolean findPath(TreeNode root, int data, ArrayList<TreeNode> list) {
        if (root == null || list == null) {
            return false;
        }

        list.add(root);
        if (root.data == data) {
            return true;
        }

        if (findPath(root.left, data, list) || findPath(root.right, data, list)) {
            return true;
        } else {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
            return false;
        }
    }

    private static TreeNode lowestCommonAncestor1(TreeNode root, int one, int two) {
        if (root == null) {
            return null;
        }
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        findPath(root, one, list1);
        findPath(root, two, list2);

        int i = 0;
        for (; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).data != list2.get(i).data) {
                return list1.get(i - 1);
            }
        }
        return null;
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append('\n');
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                stringBuilder.append(node.data).append(' ');
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private static TreeNode lowestCommonAncestor2(TreeNode root, int one, int two) {
        if (root == null) {
            return null;
        }

        if (root.data == one || root.data == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, one, two);
        TreeNode right = lowestCommonAncestor1(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

}
