package heap_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        Node head1 = new Node(0);
        head1.next = new Node(5);
        head1.next.next = new Node(7);
        head1.next.next.next = new Node(98);

        Node head2 = new Node(1);
        head2.next = new Node(8);
        head2.next.next = new Node(84);

        List<Node> lists = new ArrayList<>();
        lists.add(head1);
        lists.add(head2);

        print(mergeKSortedLinkedLists(lists));
    }

    private static Node mergeKSortedLinkedLists(List<Node> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.data - node2.data);

        Node head = new Node(-1);
        Node p = head;

        for (Node node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            p.next = node;
            p = p.next;

            if (node.next != null)
                queue.offer(node.next);
        }

        return head.next;
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
