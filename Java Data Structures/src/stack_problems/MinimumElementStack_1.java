// 6. Design a stack which will take O(1) time to return getMinimum()?
// n time 2n space
// 1 time to return the minimum element in the stack

package stack_problems;

public class MinimumElementStack_1 {
    static Node head1; // main stack
    static Node head2; // minimum stack
    int top = -1;

    public MinimumElementStack_1() {
        head1 = null;
        head2 = null;
    }

    public static boolean isEmpty() {
        return head1 == null;
    }

    public static int getMinimum() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return head2.data;
    }

    public static void main(String[] args) throws Exception {
        MinimumElementStack_1 mes = new MinimumElementStack_1();
        mes.push(2);
        mes.push(6);
        mes.push(4);
        mes.push(1);
        mes.push(5);

        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
        System.out.println(getMinimum());
        mes.pop();
    }

    public int pop() throws Exception {
        if (head1 == null)
            throw new Exception("Underflow");
        int data = head1.data;
        head1 = head1.next;
        head2 = head2.next;
        System.gc();
        return data;
    }

    public void push(int data) throws Exception {
        if (isEmpty()) {
            head1 = new Node(data);
            head2 = new Node(data);
        } else {
            Node oldHead = head1;
            head1 = new Node(data);
            head1.next = oldHead;

            oldHead = head2;
            if (data < oldHead.data)
                ;
            else
                data = oldHead.data;
            head2 = new Node(data);
            head2.next = oldHead;
        }
        top++;
    }

    public int size() {
        return top + 1;
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
