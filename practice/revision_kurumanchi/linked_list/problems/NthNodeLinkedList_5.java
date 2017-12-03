package linked_list.problems;

public class NthNodeLinkedList_5 {

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

    static int counter = 0;

    private int findNthElement(Node head, int position) {
        if (head != null) {
            findNthElement(head.next, position);
            ++counter;
            if (position == counter) {
                return head.data;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        NthNodeLinkedList_5 linkedList = new NthNodeLinkedList_5();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);

        System.out.println(linkedList.findNthElement(linkedList.head, 0));
    }


}
