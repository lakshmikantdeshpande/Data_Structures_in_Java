// 12. Check whether the given linked list is either NULL-terminated or not. 
//     If there is a cycle, find the start node of the loop.

// Find the loop, using Floyd's cycle detection algorithm, let fast ptr stay there, point slow pointer to the head of the 
// linked list, make fast and slow pointer move by one at a time. They will meet at the beginning of the loop.

// n time, 1 space

package linked_list_Problems;

public class Start_Of_The_Loop_Linked_List {
    private static Node head;

    public Start_Of_The_Loop_Linked_List() {
        this.head = new Node(0);
    }

    public static void main(String[] args) {
        Start_Of_The_Loop_Linked_List sll = new Start_Of_The_Loop_Linked_List();
        Node temp1 = sll.new Node(1);
        Node temp2 = sll.new Node(2);
        Node temp3 = sll.new Node(3);
        Node temp4 = sll.new Node(4);
        Node temp5 = sll.new Node(5);
        Node temp6 = sll.new Node(6);
        Node temp7 = sll.new Node(7);
        Node temp8 = sll.new Node(8);
        Node temp9 = sll.new Node(9);
        Node temp10 = sll.new Node(10);

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
        sll.FindTheBeginning(head);
    }

    public void display(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // n time 1 space
    private void FindTheBeginning(Node head) {
        if (head == null) {
            System.out.println("The linked list is empty!");
            return;
        }
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                System.out.println("It is a cycle, great!");
                break;
            }
        }

        if (slowPointer != fastPointer) {
            System.out.println("Damn! It is not a cycle, aborting the operation !");
            return;
        }

        // Make slow pointer point to the head, and move fast & slow pointer by
        // 1 at a time if they meet, a loop exists
        slowPointer = head;
        while (slowPointer != fastPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("The loop starts at " + fastPointer.data);

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
