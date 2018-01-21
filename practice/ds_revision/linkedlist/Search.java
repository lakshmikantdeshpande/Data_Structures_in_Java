package linkedlist;

public class Search {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        System.out.println(findIterative(SLL.head, 3));
        System.out.println(findRecursive(SLL.head, 3));
    }

    private static int findRecursive(SLL.Node head, int i) {
        return findRec(head, i, 0);
    }

    // N time N space (for recursion)
    private static int findRec(SLL.Node head, int i, int index) {
        if (head == null) {
            return -1;
        } else if (head.data == i) {
            return index;
        } else {
            return findRec(head.next, i, index + 1);
        }
    }

    // N time 1 space
    private static int findIterative(SLL.Node head, int i) {
        if (head == null) {
            return -1;
        }

        int index = 0;
        do {
            if (head.data == i) {
                return index;
            }
            head = head.next;
            index++;
        } while (head != null);
        return -1;
    }

}
