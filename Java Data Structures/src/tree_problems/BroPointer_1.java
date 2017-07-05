// 39. Fill next bro pointers if a tree is given with left, right, and nextBro pointer.
// n time n space

package tree_problems;

import java.util.LinkedList;
import java.util.Queue;

public class BroPointer_1 {

    public static void main(String[] args) {
        BroPointer_1 bp = new BroPointer_1();
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

        Queue<BroNode> queue = new LinkedList<BroNode>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            BroNode temp = queue.poll();
            if (temp != null) {
                temp.nextBro = queue.peek();

                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);

            } else {
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
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
