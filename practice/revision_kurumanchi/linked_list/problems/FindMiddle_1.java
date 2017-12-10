// N * N time 1 space

package linked_list.problems;

public class FindMiddle_1 {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
    }

    private int middle() {
        if (head == null) {
            throw new RuntimeException("Linked list seems empty");
        }

        // keep running in the forward direction
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next, ++i) {
            int j = 0;

            // keep running till the end, and find the center
            Node inner = temp;
            while (inner != null) {
                inner = inner.next;
                ++j;
            }

            // even case
            if ((i + j) % 2 == 0) {
                if (j == i) {
                    return temp.data;
                }
            } else if (i - j == -1) {
                // odd case
                return temp.data;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        FindMiddle_1 fm = new FindMiddle_1();

        fm.insertBeginning(5);
        fm.insertBeginning(4);
        fm.insertBeginning(3);
        fm.insertBeginning(2);
        fm.insertBeginning(1);

        System.out.println(fm.middle());
    }
}
