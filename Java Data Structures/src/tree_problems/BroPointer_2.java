// 40. Can you solve Q.39 with some other way ?
// n time n space recursion
// assumes that all levels are fully filled

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

public class BroPointer_2 {

    public static void main(String[] args) {
        BroPointer_2 bp = new BroPointer_2();

        BroNode root = bp.new BroNode(1);
        root.left = bp.new BroNode(2);
        root.right = bp.new BroNode(3);
        root.left.left = bp.new BroNode(4);
        root.left.right = bp.new BroNode(5);

        fillBroPointers(root);
        printTree(root.left);
    }

    public static void fillBroPointers(BroNode root) {
        if (root == null)
            return;
        if (root.left != null)
            root.left.nextBro = root.right;
        if (root.right != null)
            if (root.nextBro != null)
                root.right.nextBro = root.nextBro.left;
            else
                root.right.nextBro = null;

        fillBroPointers(root.left);
        fillBroPointers(root.right);
    }

    public static void printTree(BroNode root) {
        if (root == null)
            return;

        Queue<BroNode> queue = new LinkedList<BroNode>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            BroNode temp = queue.poll();

            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.nextBro != null)
                    queue.offer(temp.nextBro);
            } else {
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        System.out.println("************************");
    }

    class BroNode {
        int data;
        BroNode left;
        BroNode right;
        BroNode nextBro;

        public BroNode(int data) {
            this.data = data;
            left = right = nextBro = null;
        }

        public BroNode(int data, BroNode left, BroNode right, BroNode nextBro) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.nextBro = nextBro;
        }

        public boolean isLeaf(BroNode broNode) {
            return (broNode.left == null && broNode.right == null);
        }
    }

}
