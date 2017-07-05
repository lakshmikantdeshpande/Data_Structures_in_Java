// 10. Can we solve the Problem-6 in O(n)?
// Floyd's Algorithm (n time 1 space)
package linked_list_Problems;

public class Cyclic_Linked_List_2 {
    private static Node head;

    public Cyclic_Linked_List_2() {
        this.head = new Node(0);
    }

    public static void main(String[] args) {
        Cyclic_Linked_List_2 cll = new Cyclic_Linked_List_2();
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
        cll.FloydsAlgorithm(head);
    }

    public void display(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private void FloydsAlgorithm(Node head) {
        if (head == null) {
            System.out.println("Linked list is empty!");
            return;
        }

        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                System.out.println("Linked list is cyclic");
                return;
            }
        }
        System.out.println("Linked list is not cyclic");
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
