package linked_list.problems;

public class StackUsingLinkedList_1 {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private int size;
    private Node head;

    private void push(int data) {
        ++size;
        if (isEmpty()) {
            head = new Node(data);
            return;
        }

        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    private int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }

        --size;
        int data = head.data;
        Node temp = head;
        head = head.next;
        temp = null;
        return data;
    }

    private int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void printStack() {
        if (isEmpty()) {
            System.out.println("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                stringBuilder.append(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList_1 stack = new StackUsingLinkedList_1();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();

        stack.pop();
        stack.printStack();
    }

}
