// 25. How will you find the middle of the linked list?
// O(n*n) time, O(1) space
// Check from each element, if middle is achieved

package linked_list_Problems;

public class Middle_of_the_linked_list_1 {
    private static Node head;

    private static synchronized void display(Node head) {
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
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = temp9;
        temp9.next = temp10;
        temp10.next = null;

        display(head);
        findMiddle(head);
    }

    private static void findMiddle(Node head) {
        if (head == null) {
            System.out.println("Linked list seems empty !");
            return;
        }
        int counter = 0;
        for (Node temp1 = head; temp1 != null; temp1 = temp1.next) {
            counter++;
            int c = counter;
            Node nodec = temp1;
            for (Node temp2 = temp1; temp2 != null; temp2 = temp2.next) {
                counter++;
            }
            if (c == counter / 2) {
                System.out.println("Middle is " + nodec.data);
                return;
            }
            counter = c;
        }
    }

    // 25. How will you find the middle of the linked list?
    // O(n*n) time, O(1) space
    // Check from each element, if middle is achieved

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
