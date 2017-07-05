// 29. Build tree from given inorder and preorder string.
// n time 1 space

package tree_problems;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeFromInorderAndPreorder {

    public static void main(String[] args) {
        // DBEAFC // inorder 425163
        // ABDECF // preorder 124536

        List<Integer> inorder = new ArrayList<Integer>();
        inorder.add(4);
        inorder.add(2);
        inorder.add(5);
        inorder.add(1);
        inorder.add(6);
        inorder.add(3);

        List<Integer> preorder = new ArrayList<Integer>();
        preorder.add(1);
        preorder.add(2);
        preorder.add(4);
        preorder.add(5);
        preorder.add(3);
        preorder.add(6);

        levelOrder(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || preorder.size() != inorder.size())
            return null;
        return build(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }

    private static TreeNode build(List<Integer> preorder, int preStart, int preEnd, List<Integer> inorder, int inStart,
                                  int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int data = preorder.get(preStart);
        TreeNode curr = new TreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++)
            if (inorder.get(offset) == data)
                break;
        curr.left = build(preorder, preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1);
        curr.right = build(preorder, preStart + offset - inStart + 1, preEnd, inorder, offset + 1, inEnd);
        return curr;
    }

    public static void levelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            } else {
                System.out.println();
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
    }

}
