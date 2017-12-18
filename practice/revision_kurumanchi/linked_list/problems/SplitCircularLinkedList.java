package linked_list.problems;

public class SplitCircularLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node tail;

    private void insertBeginning(int data) {
        if (tail == null) {
            tail = new Node(data);
            tail.next = tail;
            return;
        }

        Node temp = new Node(data);
        temp.next = tail.next;
        tail.next = temp;
        tail = tail.next;
    }

    private void display(Node tail) {
        if (tail == null) {
            return;
        } else if (tail.next == tail) {
            System.out.println(tail.data);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tail.data).append("->");
        Node temp = tail.next;
        while (temp != tail) {
            stringBuilder.append(temp.data).append("->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    private void split(Node first, Node second) throws Exception {
        if (tail == null) {
            throw new Exception("Linked list is empty");
        } else if (tail.next == tail) {
            throw new Exception("Invalid linked list");
        }

        first = null;
        second = null;

        Node slow = tail, fast = tail;

        // find center of the linked list first... N / 2 time
        while (fast.next != tail && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next.next == tail) {
            fast = fast.next;
        }
        first = tail;

        if (tail.next != tail) {
            second = slow.next;
        }

        fast.next = slow.next;
        slow.next = tail;
    }

    public static void main(String[] args) throws Exception {
        SplitCircularLinkedList cll = new SplitCircularLinkedList();
        cll.insertBeginning(1);
        cll.insertBeginning(0);
        cll.insertBeginning(2);
        cll.insertBeginning(3);
        cll.insertBeginning(4);

        cll.display(cll.tail);
        Node a = new Node(0);
        Node b = new Node(0);

        cll.split(a, b);
        cll.display(a);
        cll.display(b);

    }
}
