package linkedlist;

public class SLL {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }

    static void deleteFromTheBeginning() {
        Node temp = head;
        if (head != null) {
            head = temp.next;
            temp = null;
        }
    }

    static void insertEnd(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    static void deleteFromTheEnd() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            return;
        }

        Node p = head, q = null;
        while (p.next != null) {
            q = p;
            p = p.next;
        }
        p = null;
        q.next = null; // to prevent loitering
    }

    static void insertMiddle(int data, int position) {
        if (head == null) {
            System.out.println("Head is null, inserting at the beginning");
            head = new Node(data);
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
            Node temp = head;
            while (temp.next != null && counter < position) {
                temp = temp.next;
                counter++;
            }

            if (counter < position) {
                System.out.println("Linked list is shorter than expected, inserting at the end of the linked list");
                temp.next = new Node(data);
            } else {
                Node t = new Node(data);
                t.next = temp.next;
                temp.next = t;
            }
        }
    }

    static void deleteFromThePosition(int position) {
        if (position < 0) {
            position = 0;
        } else if (head == null) {
            return;
        } else if (position == 0) {
            deleteFromTheBeginning();
            return;
        }

        Node p = head, q = null;
        int k = 0;
        while (p.next != null && k < position) {
            q = p;
            p = p.next;
            k++;
        }
        q.next = p.next;
        p = null;
    }

    static void display() {
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            builder.append(temp.data).append("~");
            temp = temp.next;
        }
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

        deleteFromTheBeginning();
        display();
        deleteFromTheEnd();
        display();
        deleteFromThePosition(2);
        display();
    }

}
