package linked_list;

public class Linked_List {
    public static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node head;

    public static Node insertBeginning(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node oldHead = head;
            head = new Node(data);
            head.next = oldHead;
        }
        return head;
    }

    public static Node insertEnd(Node head, int data) {
        if (head == null) {
            return insertBeginning(head, data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
            return head;
        }
    }

    public static Node insertInMiddle(Node head, int data, int position) {
        if (head == null) {
            throw new IllegalArgumentException("ERROR: Head is null");
        } else if (position < 0) {
            throw new IllegalArgumentException("ERROR: Invalid position specified");
        } else if (position == 0) {
            return insertBeginning(head, data);
        }

        int current = 1;
        Node temp = head;
        while (current < position && temp.next != null) {
            ++current;
            temp = temp.next;
        }

        if (current < position) {
            System.out.println("WARNING: Sounds like the position is bigger than the linked list.. Appending at the end");
            temp.next = new Node(data);
        } else {
            Node node = new Node(data);
            node.next = temp.next;
            temp.next = node;
        }
        return head;
    }

    public static void display(Node head) {
        if (head == null) {
            System.out.println("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (head != null) {
                stringBuilder.append(head.data + " -> ");
                head = head.next;
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public synchronized void deleteFromTheBeginning() {
        Node temp = head;
        if (head != null) {
            head = temp.next;
            temp = null;
        }
    }

    public synchronized void deleteFromTheEnd() {
        if (head == null)
            return;
        if (head.next == null) {
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

    public synchronized void deleteFromThePosition(int position) {
        if (position < 0)
            position = 0;
        if (head == null)
            return;
        if (position == 0) {
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

    public static void main(String[] args) {
        head = insertBeginning(head, 1);
        head = insertBeginning(head, 0);
        head = insertBeginning(head, -1);
        display(head);
        head = insertEnd(head, 5);
        display(head);
        head = insertInMiddle(head, 2, 99);
        display(head);
    }

}
