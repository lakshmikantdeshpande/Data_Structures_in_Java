// 27. Can we use hash table for solving problem-25?
// O(n) time, O(n) space
// used hashtable

package linked_list_Problems;

public class Middle_of_the_linked_list_4 {
    private static Node head;

    private static void display(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        head = new Node(0);
        Node temp1 = new Node(1);
        Node temp2 = new Node(2);
        Node temp3 = new Node(3);
        Node temp4 = new Node(4);
        Node temp5 = new Node(5);
        Node temp6 = new Node(7);
        Node temp7 = new Node(8);
        Node temp8 = new Node(9);
        Node temp9 = new Node(10);
        Node temp10 = new Node(11);

        head.next = temp1;
        temp1.next = temp2;
        // temp2.next = temp3;
        // temp3.next = temp4;
        // temp4.next = temp5;
        // temp5.next = temp6;
        // temp6.next = temp7;
        // temp7.next = temp8;
        // temp8.next = temp9;
        // temp9.next = temp10;
        // temp10.next = null;

        display(head);
        findMiddle(head);
    }

    private static void findMiddle(Node head) {
        if (head == null) {
            System.out.println("Linked list seems empty !");
            return;
        }
        Node temp1 = head, temp2 = head;

        while (temp2 != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        System.out.println("The middle of the linked list is " + temp1.data);
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
