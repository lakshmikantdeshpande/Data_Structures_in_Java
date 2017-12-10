// N + N time 1n space

package linked_list.problems;

public class FindMiddle_2 {
    private static class Node {
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
            throw new RuntimeException("Linked list is empty");
        }
        Node temp = head;
        int len = findLength();
        int i = 0;
        while (i != len / 2) {
            temp = temp.next;
            ++i;
        }
        return temp.data;
    }

    private int findLength() {
        if (head == null) {
            return 0;
        }
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        FindMiddle_2 fm = new FindMiddle_2();

        fm.insertBeginning(5);
        fm.insertBeginning(4);
        fm.insertBeginning(3);
        fm.insertBeginning(2);
        fm.insertBeginning(1);

        System.out.println(fm.middle());
    }
}
