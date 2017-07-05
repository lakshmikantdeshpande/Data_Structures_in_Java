// 15. Check whether the given linked list is NULL terminated. If there is a cycle, find the length of the loop
// == floyd's algorithm for loop detection, a variable to track count of number of steps of the slow pointer
//  N time 1 Space

package linked_list_Problems;

public class Cyclic_Linked_List_Length {
    private static Node head;

    public Cyclic_Linked_List_Length() {
        this.head = new Node(0);
    }

    public static void main(String[] args) {
        Cyclic_Linked_List_Length cll = new Cyclic_Linked_List_Length();
        Node temp1 = cll.new Node(1);
        Node temp2 = cll.new Node(2);
        Node temp3 = cll.new Node(3);
        Node temp4 = cll.new Node(4);
        Node temp5 = cll.new Node(5);
        Node temp6 = cll.new Node(6);
        Node temp7 = cll.new Node(7);
        Node temp8 = cll.new Node(8);
        Node temp9 = cll.new Node(9);
        Node temp10 = cll.new Node(10);

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
        temp10.next = temp5; // here it becomes cyclic

        // cll.display(head);
        cll.LengthOfLinkedList(head);
    }

    public void display(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Run to the place where both pointers meet; stop fast pointer and make
    // slow pointer run to fast one again (with counter)
    // N time 1 Space
    private void LengthOfLinkedList(Node head) {
        if (head == null) {
            System.out.println("The linked list is empty !");
            return;
        }

        Node slow = head;
        Node fast = head;
        int counter = 0;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Loop exists");
                flag = true;
                break;
            }
        }
        if (flag) {
            do {
                slow = slow.next;
                counter++;
            } while (slow != fast);

            System.out.println("Loop exists, length of the loop is " + (counter));
        } else
            System.out.println("Loop doesn't exist, length of the loop is " + counter);
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
