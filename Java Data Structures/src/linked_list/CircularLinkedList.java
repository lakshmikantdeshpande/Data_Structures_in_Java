package linked_list;

public class CircularLinkedList {
    private int length;
    private Node tail;

    public CircularLinkedList() {
        this.tail = null;
        this.length = 0;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtTheBeginning(1);
        cll.insertAtTheBeginning(0);
        cll.insertAtTheEnd(2);
        cll.insertAtTheEnd(3);
        cll.insertAtTheEnd(4);
        cll.deleteFromTheEnd();
        cll.deleteFromTheEnd();
        cll.deleteFromTheFront();
        cll.display();
    }

    public int ListLength() {
        if (tail == null)
            return 0;
        int count = 0;
        Node temp = tail.next;

        while (temp != tail) {
            temp = temp.next;
            count++;
        }
        System.out.println("Length of this linked list is: " + count);
        return count;
        // or just return this.length;
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

    public void insertAtTheBeginning(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            tail = temp;
            tail.next = tail;
        } else {
            temp.next = tail.next;
            tail.next = temp;
        }
        length++;
    }

    public void insertAtTheEnd(int data) {
        insertAtTheBeginning(data);
        tail = tail.next; // length added in the insertAtTheBeginning function
    }

    public void deleteFromTheEnd() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
            length--;
            return;
        }

        Node temp = tail.next;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = tail.next;
        tail = temp;
        length--;
    }

    public void deleteFromTheFront() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
            length--;
            return;
        }
        Node temp = tail.next;
        tail.next = temp.next;
        temp = null;
        length--;
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
