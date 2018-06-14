package amz.linked_list;

public class Search {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private static boolean searchIterative(Node head, Node queryNode) {
        if (head == null || queryNode == null) {
            return false;
        }

        Node temp = head;
        while (temp != null) {
            if (temp == queryNode) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private static boolean searchRecursive(Node head, Node queryNode) {
        if (head == null || queryNode == null) {
            return false;
        }
        if (head == queryNode) {
            return true;
        }
        return searchRecursive(head.next, queryNode);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(searchIterative(head, head.next));
        System.out.println(searchIterative(head, null));
        System.out.println(searchIterative(head, new Node(44)));

        System.out.println(searchRecursive(head, head.next));
        System.out.println(searchRecursive(head, null));
        System.out.println(searchRecursive(head, new Node(44)));
    }

}
