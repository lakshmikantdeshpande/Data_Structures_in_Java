package linked_list.problems;

public class FindCycleMergePointLinkedList {

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

    private Node findMergePoint() throws Exception {
        if (head == null) {
            return null;
        }

        Node fast = head, slow = head;
        boolean cyclePresent = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cyclePresent = true;
                break;
            }
        }

        if (cyclePresent) {
            slow = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            throw new Exception("No cycle found in the linked list");
        }

    }

    public static void main(String[] args) throws Exception {
        FindCycleMergePointLinkedList linkedList = new FindCycleMergePointLinkedList();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(8);

        linkedList.head.next.next.next.next.next.next.next = linkedList.head.next.next;
        System.out.println(linkedList.findMergePoint().data);
    }
}
