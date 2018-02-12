public class LinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node head;
    private static int length;

    private static Node insertBeginning(int data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        ++length;
        return head;
    }

    private static Node insertEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        ++length;
        return head;
    }

    private static void display() {
        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp.data).append(" ---> ");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    private static void deleteEnd() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            --length;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        --length;
    }

    private static void deleteBeginning() {
        if (head == null) {
            return;
        }
        head = head.next;
        --length;
    }

    private static int getLength() {
        return length;
    }

    public static void main(String[] args) {
        insertBeginning(4);
        insertEnd(2);
        insertBeginning(1);
        display();
        deleteBeginning();
        display();
        System.out.printf("The length of the linked list is %d %n", getLength());
        deleteEnd();
        display();
        System.out.printf("The length of the linked list is %d %n", getLength());
        deleteEnd();
        display();
        System.out.printf("The length of the linked list is %d %n", getLength());
    }

}
