// Recursive and iterative
// N time 1 space non recursive
// N time N space (for recursion) recursive

package linkedlist;

public class Length {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SLL.insertBeginning(i);
        }
        SLL.display();

        findLengthIterative(SLL.head);
        int length = findLengthRecursive(SLL.head);
        System.out.println(length);
    }

    // N time N space
    private static int findLengthRecursive(SLL.Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + findLengthRecursive(head.next);
    }

    // N time 1 space
    private static void findLengthIterative(SLL.Node head) {
        SLL.Node temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        System.out.println(counter);
    }

}
