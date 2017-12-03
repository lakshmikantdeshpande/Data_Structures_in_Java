// N + N time 1 space

package linked_list.problems;

public class NthNodeLinkedList_3 {

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
        } else {
            Node oldHead = head;
            head = new Node(data);
            head.next = oldHead;
        }
    }

    private int nthFromTheEnd(int position) throws Exception {
        if (head == null || position < 0) {
            throw new Exception("Invalid position provided");
        }

        // find the length of the linked list
        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            ++len;
        }

        if (len - position - 1 < 0) {
            throw new Exception("Invalid position provided");
        }

        temp = head;
        for (int i = 0; i < len - position - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args) throws Exception {
        NthNodeLinkedList_3 linkedList = new NthNodeLinkedList_3();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);

        System.out.println(linkedList.nthFromTheEnd(2));
    }

}

