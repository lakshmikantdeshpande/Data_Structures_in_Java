package linked_list;

public class Doubly_Linked_List {
    private static class Node {
        int data;
        Node next, previous;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node head, tail;

    private void insertBeginning(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }

        // take backup of old head;
        Node oldHead = head;
        head = new Node(data);

        // set pointers
        head.next = oldHead;
        oldHead.previous = head;
        if (oldHead.next == null) {
            tail = oldHead;
        }
    }

    private void insertAtTheEnd(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.previous = temp;
        tail = newNode;
    }

    private void insertInTheMiddle(int position, int data) {
        if (head == null) {
            System.out.println("WARNING: head is null, inserting at 0th position");
            insertBeginning(data);
            return;
        } else if (position < 0) {
            System.out.println("WARNING: invalid position, inserting at 0th position");
            insertBeginning(data);
            return;
        } else if (position == 0) {
            insertBeginning(data);
            return;
        }

        Node p = head, q = null;
        int counter = 0;
        while (p.next != null && counter < position) {
            q = p;
            p = p.next;
            ++counter;
        }

        Node temp = new Node(data);

        if (counter < position) {
            System.out.println("WARNING: linked list is shorter than expected, inserting at the end");
            p.next = temp;
            temp.previous = p;
        } else {
            temp.next = q.next;
            temp.previous = q;

            q.next = temp;
            p.previous = temp;
        }

    }

    private void deleteBeginning() {
        if (head == null) {
            tail = null;
            return;
        } else if (head.next == null) {
            tail = null;
            head = null;
            return;
        }
        Node oldHead = head;
        head = head.next;
        head.previous = null;
        oldHead = null;
    }

    private void deleteEnd() {
        if (tail == null) {
            return;
        } else if (tail.previous == null) {
            tail = null;
            return;
        }

        Node oldTail = tail;
        tail = tail.previous;
        tail.next = null;
        oldTail = null;
    }

    public static void main(String[] args) {
        Doubly_Linked_List dll = new Doubly_Linked_List();

        dll.insertBeginning(1);
        dll.insertBeginning(2);
        dll.insertBeginning(3);
        display(head);

        dll.insertAtTheEnd(4);
        dll.insertAtTheEnd(5);
        display(head);

        dll.insertInTheMiddle(4, 99);
        display(head);

        dll.deleteBeginning();
        display(head);

        dll.deleteEnd();
        display(head);
    }

    private static void display(Node head) {
        System.out.println("Printing...");
        if (head == null) {
            System.out.println("");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println();

        temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }

        System.out.println();
    }

}
