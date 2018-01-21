package linkedlist;

import java.io.PrintWriter;

public class StackUsingLL {

    private int size = 0;
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private int size() {
        return this.size;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private void push(int data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        size++;
    }

    private int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int pop = head.data;
        head = head.next;
        size--;
        return pop;
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        PrintWriter printWriter = new PrintWriter(System.out);
        while (!stack.isEmpty()) {
            printWriter.print(stack.pop());
            printWriter.print(' ');
        }
        printWriter.close();
    }

}
