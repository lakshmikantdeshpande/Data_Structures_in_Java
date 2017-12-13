// N / 2 time 1 space

package linked_list.problems;

public class EvenOrOdd {
    static class Node {
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

    private int evenOrOdd(Node head) {
        while (head != null && head.next != null) {
            head = head.next.next;
        }

        if (head == null) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        EvenOrOdd linkedList = new EvenOrOdd();
        linkedList.insertBeginning(1);
        linkedList.insertBeginning(0);
        linkedList.insertBeginning(-1);
        linkedList.insertBeginning(-2);
        linkedList.insertBeginning(-3);

        System.out.println(linkedList.evenOrOdd(linkedList.head));
    }
}
