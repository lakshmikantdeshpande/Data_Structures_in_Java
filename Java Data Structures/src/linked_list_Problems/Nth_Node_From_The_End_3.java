// 4. Can we use Problem-3 approach for solving Problem-2 without creating the hash table?
// two scans, one for finding length, second for length-n traversal (n+n time 1 space)
package linked_list_Problems;

public class Nth_Node_From_The_End_3 {
    private Node head;
    private int size;

    public Nth_Node_From_The_End_3() {
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        Nth_Node_From_The_End_3 nnd = new Nth_Node_From_The_End_3();
        nnd.insertFromTheBeginning(5);
        nnd.insertFromTheBeginning(4);
        nnd.insertFromTheBeginning(3);
        nnd.insertFromTheBeginning(2);
        nnd.insertFromTheBeginning(1);

        nnd.display();
        nnd.nthFromTheEnd(0);
    }

    public void insertFromTheBeginning(int data) {
        Node oldhead = head;
        head = new Node(data);
        head.next = oldhead;
        size++;
    }

    private void display() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // two scans, one to find length, second to reach to length-n element
    private void nthFromTheEnd(int n) {
        if (head == null || n < 0)
            return;

        Node temp = head;

        // find the size by iterating through the linked list
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        n = counter - n - 1;
        temp = head;
        for (int i = 0; i < n; i++)
            temp = temp.next;
        System.out.println(temp.data);
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
