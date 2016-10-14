package Week_2_Stacks_and_Queues;

/**
 * Implementation of stack using linked list
 * Reverse given string using stack
 */
public class StackOfStrings {
    Node head = null;

    private class Node
    {
        String item;
        Node next;
    }
//
//    StackOfStrings(){
//        head = new Node();
//        head.item = null;
//        head.next = null;
//    }

    public void push(String item){
        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
    }

    public String pop(){

    }

    public boolean isEmpty(){
        return head == null;
    }

    private int size(){

    }
}
