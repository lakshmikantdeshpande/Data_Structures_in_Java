// 56. How do you implement insertion sort for linked lists?
// n*n time 1 space

package linked_list_Problems;

public class Insertion_Sort_Linked_List {
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
        head = new Node(74894);
        Node temp1 = new Node(100);
        Node temp2 = new Node(99);
        Node temp3 = new Node(98);
        Node temp4 = new Node(94);
        Node temp5 = new Node(95);
        Node temp6 = new Node(96);
        Node temp7 = new Node(97);
        Node temp8 = new Node(85);
        Node temp9 = new Node(94);
        Node temp10 = new Node(110);

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
        display(insertionSort(head));
    }

    private static Node insertionSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = new Node(head.data);
        Node pointer = head.next;
        // loop through each element in the list
        while (pointer != null) {
            // insert this element to new list
            Node innerPointer = newHead;
            Node next = pointer.next;
            if (pointer.data <= newHead.data) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {
                    if (pointer.data > innerPointer.data && pointer.data <= innerPointer.next.data) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }
                    innerPointer = innerPointer.next;
                }
                if (innerPointer.next == null && pointer.data > innerPointer.data) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }
            pointer = next;
        }
        return newHead;
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
