package linkedlist;

public class CLL {

    static Node tail;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void insertBeginning(int data) {
        if (tail == null) {
            tail = new Node(data);
            tail.next = tail;
            return;
        }

        Node node = new Node(data);
        node.next = tail.next;
        tail.next = node;
    }

    static void insertEnd(int data) {
        insertBeginning(data);
        tail = tail.next;
    }

    static void insertMiddle(int data, int position) {
        if (tail == null) {
            System.out.println("Head is null, inserting at the beginning");
            tail = new Node(data);
            return;
        } else if (position < 0) {
            System.out.println("Invalid position, inserting at the beginning");
            insertBeginning(data);
            return;
        }

        if (position == 0) {
            insertBeginning(data);
        } else {
            int counter = 1;
            Node temp = tail.next;
            while (temp != tail && counter < position) {
                temp = temp.next;
                counter++;
            }

            if (counter < position) {
                System.out.println("Linked list is shorter than expected, inserting at the end of the linked list");
                insertEnd(data);
            } else {
                Node t = new Node(data);
                t.next = temp.next;
                temp.next = t;
            }
        }
    }

    static void deleteFromTheEnd() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
            return;
        }

        Node temp = tail.next;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = tail.next;
        tail = temp;
    }

    static void deleteFromTheFront() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
            return;
        }
        Node temp = tail.next;
        tail.next = temp.next;
        temp = null;
    }

    static void display() {
        StringBuilder builder = new StringBuilder();
        Node temp = tail.next;
        while (temp != tail) {
            builder.append(temp.data).append("~");
            temp = temp.next;
        }
        builder.append(temp.data);
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                insertEnd(i);
            } else {
                insertBeginning(i);
            }
        }
        display();

        insertMiddle(11, -1);
        display();
        insertMiddle(111, 0);
        display();
        insertMiddle(1111, 5);
        display();
        insertMiddle(11111, 99);
        display();

        deleteFromTheFront();
        display();
        deleteFromTheEnd();
        display();
    }

}
