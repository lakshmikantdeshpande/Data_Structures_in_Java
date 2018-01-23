package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SLL.insertBeginning(i);
        }

        SLL.Node node = new SLL.Node(99);
        node.next = SLL.head.next.next.next.next.next;
        display(SLL.head);
        display(node);

        System.out.println(findIntersection1(SLL.head, node));
        System.out.println(findIntersection2(SLL.head, node));
        System.out.println(findIntersection3(SLL.head, node));
    }

    private static boolean findIntersection3(SLL.Node head1, SLL.Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        int count1 = findLength(head1);
        int count2 = findLength(head2);

        int diff = Math.max(count1, count2) - Math.min(count1, count2);

        SLL.Node temp1 = head1, temp2 = head2;
        // run first linked list until d difference

        if (count1 < count2) {
            temp2 = runNSteps(temp2, diff);
        } else if (count1 > count2) {
            temp1 = runNSteps(temp1, diff);
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                System.out.printf("Intersection is found at %d ", temp1.data);
                return true;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return false;
    }

    private static SLL.Node runNSteps(SLL.Node head, int N) {
        if (head == null) {
            return null;
        }

        while (N-- > 0) {
            head = head.next;
        }
        return head;
    }

    private static int findLength(SLL.Node head) {
        if (head == null) {
            return 0;
        }

        SLL.Node temp = head;

        int count = 0;
        while (temp != null) {
            temp = temp.next;
            ++count;
        }
        return count;
    }

    // M + N time M + N space
    private static boolean findIntersection2(SLL.Node head1, SLL.Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        SLL.Node temp = head1;
        Set<SLL.Node> set = new HashSet<>();
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null) {
            if (!set.add(temp)) {
                System.out.format("Intersection is present at %d ", temp.data);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // N * N time 1 space
    private static boolean findIntersection1(SLL.Node head1, SLL.Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        SLL.Node temp1 = head1;
        while (temp1 != null) {
            SLL.Node temp2 = head2;
            while (temp2 != null) {
                if (temp1 == temp2) {
                    System.out.printf("Intersection is present at %d ", temp1.data);
                    return true;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return false;
    }

    private static void display(SLL.Node head) {
        if (head == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        SLL.Node temp = head;
        while (temp != null) {
            builder.append(temp.data).append(" ~ ");
            temp = temp.next;
        }

        System.out.println(builder.toString());
    }

}
