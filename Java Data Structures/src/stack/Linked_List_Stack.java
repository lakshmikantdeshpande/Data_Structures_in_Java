package stack;

public class Linked_List_Stack {
    int top;
    private Node head;

    public Linked_List_Stack() {
        top = -1;
    }

    public static void main(String[] args) throws Exception {
        Linked_List_Stack lls = new Linked_List_Stack();
        lls.push(1);
        lls.push(2);
        lls.push(3);
        lls.push(4);
        System.out.println(lls.toString());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
        System.out.println(lls.pop());
    }

    public void push(int data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        top++;
    }

    public int pop() throws Exception {
        if (head == null)
            throw new Exception("Underflow");
        int data = head.data;
        head = head.next;
        top--;
        return data;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() throws Exception {
        if (head == null)
            throw new Exception("Stack is empty");
        return head.data;
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "Stack []";
        else {
            StringBuilder strb = new StringBuilder("Stack [ ");
            Node temp = head;
            while (temp != null) {
                strb.append(temp.data + ",");
                temp = temp.next;
            }
            return strb.append(" ]").toString();
        }
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
