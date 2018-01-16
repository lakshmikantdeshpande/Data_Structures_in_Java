package linkedlist;

public class DoublyLinkedList {

    private static Node head;

    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        head = new Node(data);
        head.next = temp;
        temp.prev = head;
    }

    public static void insertEnd(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        temp.next.prev = temp;
    }

    public static void insertMiddle(int data, int position) {
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
                temp.next.prev = temp;
            } else {
                Node t = new Node(data);
                t.next = temp.next;
                t.prev = temp;
                temp.next = t;
                if (t.next != null) {
                    t.next.prev = t;
                }
            }
        }
    }

    public static void display() {
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        builder.append(">>>   ");
        while (temp.next != null) {
            builder.append(temp.data).append('~');
            temp = temp.next;
        }
        builder.append(temp.data).append("\n<<<   ");
        while (temp != null) {
            builder.append(temp.data).append('~');
            temp = temp.prev;
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
    }

}
