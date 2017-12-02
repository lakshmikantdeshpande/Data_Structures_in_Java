package linked_list;

public class CircularLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node tail;
    private int length = 0;

    private int count(Node head) {
        if (tail == null) {
            return 0;
        }

        int counter = 0;
        Node temp = tail.next;

        while (temp != tail) {
            temp = temp.next;
            counter++;
        }
        System.out.println("Length of this linked list is: " + counter);
        return counter;
    }

    private void insertBeginning(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            tail = temp;
            tail.next = tail;
        } else {
            temp.next = tail.next;
            tail.next = temp;
        }
        ++length;
    }

    public void insertAtEnd(int data) {
        insertBeginning(data);
        tail = tail.next;
    }

    public void deleteFromBeginning() {
        if (tail == null) {
            return;
        } else if (tail.next == tail) {
            tail = null;
            length--;
            return;
        }

        Node temp = tail.next;
        tail.next = temp.next;
        temp = null;
        length--;
    }

    public void deleteFromTheEnd() {
        if (tail == null) {
            return;
        } else if (tail.next == tail) {
            tail = null;
            length--;
            return;
        }

        Node temp = tail.next;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = tail.next;
        tail = tail.next;
        length--;
    }

    public void display() {
        if (tail == null)
            return;

        Node temp = tail.next;
        while (temp != tail) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertBeginning(1);
        cll.insertBeginning(0);
        cll.insertBeginning(2);
        cll.insertBeginning(3);
        cll.insertBeginning(4);
        cll.deleteFromTheEnd();
        cll.deleteFromTheEnd();
        cll.deleteFromTheEnd();
        cll.display();
    }

}
