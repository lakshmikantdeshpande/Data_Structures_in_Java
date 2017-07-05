// 44. JosephusCircle: N people have decided to elect a leader by arranging themselves in a circle and eliminating every Mth
//   person around the circle, closing ranks as each person drops out. Find which person will be the one remaining (rank 1).
//   n*n time 1 space

package linked_list_Problems;

public class Josephus_Circle {

    private static Node head;

    public Josephus_Circle() {
        this.head = new Node(1);
    }

    public static void main(String[] args) {
        Josephus_Circle joe = new Josephus_Circle();
        Node temp1 = joe.new Node(2);
        Node temp2 = joe.new Node(3);
        Node temp3 = joe.new Node(4);
        Node temp4 = joe.new Node(5);
        Node temp5 = joe.new Node(6);
        Node temp6 = joe.new Node(7);
        Node temp7 = joe.new Node(8);
        Node temp8 = joe.new Node(9);
        Node temp9 = joe.new Node(10);
        Node temp10 = joe.new Node(11);

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
        temp10.next = head; // here it becomes cyclic

        joe.display(head);
        joe.getJosephus(11, 2);
    }

    public void display(Node head) {
        if (head == null)
            return;
        Node temp = head, temp2 = temp.next;
        System.out.println(temp.data);

        while (temp2 != temp) {
            System.out.println(temp2.data);
            temp2 = temp2.next;
        }
    }

    // N is the number of nodes, Mth person gets killed each time
    private void getJosephus(int N, int M) {
        // Either use the given linked list or create one by using numbered
        // nodes
        // here we're using the existing linked list with nodes 1-11 (11 nodes)
        // every 2nd player gets killed
        Node p = head;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++)
                p = p.next;
            p.next = p.next.next;
        }
        System.out.println("*****" + p.data + "*****");
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
