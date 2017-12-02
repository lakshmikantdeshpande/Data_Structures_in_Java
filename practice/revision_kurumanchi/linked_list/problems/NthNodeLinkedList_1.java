// n * n time 1 space

package linked_list.problems;

public class NthNodeLinkedList_1 {

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

    private int nthFromTheEnd(int position) {
        if (head == null || position < 0)
            return Integer.MIN_VALUE;

        Node outer = head;
        while (outer != null) {
            Node inner = outer;
            int counter = 0;
            while (inner.next != null) {
                counter++;
                inner = inner.next;
            }
            if (counter == position) {
                return outer.data;
            } else
                outer = outer.next;
        }
        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        NthNodeLinkedList_1 linkedList = new NthNodeLinkedList_1();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);

        System.out.println(linkedList.nthFromTheEnd(2));
    }

}
