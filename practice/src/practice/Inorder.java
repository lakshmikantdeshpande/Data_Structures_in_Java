package practice;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {

    public void doInorder(TreeNode root) {
        if (root == null)
            return;
        doInorder(root.left);
        System.out.print(root.data + " - ");
        doInorder(root.right);
    }

    public ArrayList<Integer> doInorderIterative(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current  = root;
        boolean done = false;

        while (!done) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty())
                    done = true;
                else {
                    current = stack.pop();
                    list.add(current.data);
                    current = current.right;
                }
            }
        }
        return list;
    }
}
