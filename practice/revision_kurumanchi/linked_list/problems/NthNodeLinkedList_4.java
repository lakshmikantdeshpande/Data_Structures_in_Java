// N time 1 space

package linked_list.problems;

public class NthNodeLinkedList_4 {

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

    private int findNthElement(int position) throws Exception {
        if (head == null) {
            throw new Exception("Invalid position");
        }

        int current = 0;
        Node fast = head;
        while (current < position && fast.next != null) {
            fast = fast.next;
            ++current;
        }

        if (current == position) {
            Node slow = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.data;
        } else {
            throw new Exception("Invalid position");
        }
    }

    public static void main(String[] args) throws Exception {
        NthNodeLinkedList_4 linkedList = new NthNodeLinkedList_4();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);

        System.out.println(linkedList.findNthElement(2));
    }

}
