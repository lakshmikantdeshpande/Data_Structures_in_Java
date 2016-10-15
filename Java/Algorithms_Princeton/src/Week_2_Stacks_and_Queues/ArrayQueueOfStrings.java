package Week_2_Stacks_and_Queues;

public class ArrayQueueOfStrings {
    String[] queue;
    int front, back, capacity;

    ArrayQueueOfStrings(int capacity){
        queue = new String[capacity];
        front = 0;
        back = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty()
    {
        return queue[front] == null;
    }

    public void enqueue(String item)
    {
        queue[back] = item;
        back = (back + 1) % capacity;
    }

    public String dequeue()
    {
        String item = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        return item;
    }
    public static void main(String args[])
    {
        ArrayQueueOfStrings sos =  new ArrayQueueOfStrings(4);
        sos.enqueue("one");
        sos.enqueue("two");
        sos.enqueue("three");
        sos.enqueue("four");
        sos.enqueue("five");
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
        System.out.println(sos.dequeue());
    }
}
