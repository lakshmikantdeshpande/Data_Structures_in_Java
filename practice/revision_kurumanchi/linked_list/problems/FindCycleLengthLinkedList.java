package linked_list.problems;

public class FindCycleLengthLinkedList {

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

    private int findLength() {
        if (head == null) {
            return 0;
        }

        boolean cycleFound = false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                cycleFound = true;
                break;
            }
        }

        if (cycleFound) {
            int len = 0;
            do {
                fast = fast.next;
                len++;
            } while (fast != slow);

            return len;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        FindCycleLengthLinkedList linkedList = new FindCycleLengthLinkedList();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(8);

        linkedList.head.next.next.next.next.next.next.next = linkedList.head.next.next;
        System.out.println(linkedList.findLength());
    }
}
