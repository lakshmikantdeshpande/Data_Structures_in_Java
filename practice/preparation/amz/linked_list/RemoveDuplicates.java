package amz.linked_list;

public class RemoveDuplicates {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node temp1 = new Node(1);
        Node temp2 = new Node(2);
        Node temp3 = new Node(3);
        Node temp4 = new Node(3);
        Node temp5 = new Node(7);
        Node temp6 = new Node(7);
        Node temp7 = new Node(7);
        Node temp8 = new Node(9);
        Node temp9 = new Node(10);
        Node temp10 = new Node(10);

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

        display(head);
        removeDuplicates(head);
        display(head);
    }

    private static void removeDuplicates(Node head) {
        if (head == null) {
            return;
        }

        // 1 2 2 3 4
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

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


}
