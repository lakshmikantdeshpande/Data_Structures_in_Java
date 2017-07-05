// 24. Can we improve the complexity for the problem-18?
// O((m+n)+ min(m,n)) time, O(1) space 
// find out lengths of the linked lists, find their difference
// make the longer linked list run till the difference point
// make both linked lists run till a common point is encountered

package linked_list_Problems;

public class Intersection_Of_Linked_Lists_5 {
    private static Node head1;
    private static Node head2;

    public Intersection_Of_Linked_Lists_5() {
        head1 = new Node(0);
        head2 = new Node(-1);
    }

    public static void main(String[] args) {
        Intersection_Of_Linked_Lists_5 ill = new Intersection_Of_Linked_Lists_5();
        Node temp1 = ill.new Node(1);
        Node temp2 = ill.new Node(2);
        Node temp3 = ill.new Node(3);
        Node temp4 = ill.new Node(4);
        Node temp5 = ill.new Node(5);
        Node temp6 = ill.new Node(7);
        Node temp7 = ill.new Node(8);
        Node temp8 = ill.new Node(9);
        Node temp9 = ill.new Node(10);
        Node temp10 = ill.new Node(11);

        Node tempx = ill.new Node(54);
        Node tempy = ill.new Node(55);

        head1.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;

        head2.next = tempx;
        tempx.next = tempy;
        tempy.next = temp6;
        // tempy.next = null;

        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = temp9;
        temp9.next = temp10;
        temp10.next = null;

        ill.display(head1);
        ill.findIntersection(head1, head2);
        ill.display(head2);
    }

    private synchronized void display(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // O((m+n)+ min(m,n)) time, O(1) space
    // find out lengths of the linked lists, find their difference
    // make the longer linked list run till the difference point
    // make both linked lists run till a common point is encountered
    private void findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            System.out.println("No intersection found");
            return;
        }
        int a = 0, b = 0, d = 0;
        for (Node temp = head1; temp != null; temp = temp.next)
            a++;
        for (Node temp = head2; temp != null; temp = temp.next)
            b++;
        d = Math.abs(a - b);
        int i = 0;

        Node temp1 = head1, temp2 = head2;
        if (a > b) {
            for (temp1 = head1; temp1 != null && i != d; temp1 = temp1.next, i++)
                ;
            while (temp1 != null && temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println("Intersection found at " + temp1.data);
                    return;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

        } else if (a < b) {
            for (temp2 = head2; temp2 != null && i != d; temp2 = temp2.next, i++)
                ;
            while (temp1 != null && temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println("Intersection found at " + temp1.data);
                    return;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        } else {
            while (temp1 != null && temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println("Intersection found at " + temp1.data);
                    return;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        System.out.println("Intersection not found;");
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
