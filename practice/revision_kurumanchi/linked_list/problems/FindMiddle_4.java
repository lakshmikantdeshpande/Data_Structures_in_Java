package linked_list.problems;

public class FindMiddle_4 {

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
            throw new RuntimeException("Linked list is empty");
        }

        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        FindMiddle_4 fm = new FindMiddle_4();

        fm.insertBeginning(5);
        fm.insertBeginning(4);
        fm.insertBeginning(3);
        fm.insertBeginning(2);
        fm.insertBeginning(1);

        System.out.println(fm.middle());
    }
}
