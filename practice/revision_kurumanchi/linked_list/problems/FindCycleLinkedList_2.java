// N time 1 space

package linked_list.problems;

public class FindCycleLinkedList_2 {

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

    private boolean isCyclePresent() {
        if (head == null) {
            return false;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindCycleLinkedList_2 linkedList = new FindCycleLinkedList_2();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(2);
        linkedList.insertBeginning(3);
        linkedList.insertBeginning(4);
        linkedList.insertBeginning(5);
        linkedList.insertBeginning(6);
        linkedList.insertBeginning(7);
        linkedList.insertBeginning(8);

        linkedList.head.next.next.next.next.next.next.next = linkedList.head.next.next;
        System.out.println(linkedList.isCyclePresent());
    }

}
