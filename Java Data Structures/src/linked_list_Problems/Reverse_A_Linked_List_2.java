// 17. Reverse a singly linked list
// recursive solution 
// n time n space

package linked_list_Problems;

public class Reverse_A_Linked_List_2 {
    private static Node head;

    public Reverse_A_Linked_List_2() {
        head = new Node(0);
    }

    public static void main(String[] args) {
        Reverse_A_Linked_List_2 rll = new Reverse_A_Linked_List_2();
        Node temp1 = rll.new Node(1);
        Node temp2 = rll.new Node(2);
        Node temp3 = rll.new Node(3);
        Node temp4 = rll.new Node(4);
        Node temp5 = rll.new Node(6);
        Node temp6 = rll.new Node(7);
        Node temp7 = rll.new Node(8);
        Node temp8 = rll.new Node(9);
        Node temp9 = rll.new Node(10);
        Node temp10 = rll.new Node(11);

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

        rll.display();
        head = rll.reverse(head, null);

        rll.display();
    }

    private synchronized void display() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // n time n space, move these three pointers one by one
    // we can make an auxiliary function to check for null head
    public synchronized Node reverse(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return null;
        }

        Node temp = curr.next;
        curr.next = prev;
        reverse(temp, curr);
        return head;
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
