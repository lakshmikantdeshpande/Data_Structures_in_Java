package linked_list;

class LinkedListDemo {

	private node head;
	
	static class node
	{
		int data;
		node next;
		
		// constructor
		node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	private void display()
	{
		while (head != null)
		{
			System.out.print(head.data + "->");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListDemo linkedList = new LinkedListDemo();
		
		linkedList.head = new node(1);
		node second = new node(2);
		node third = new node(3);
		
		linkedList.head.next = second;
		second.next = third;
		
		linkedList.display();
	}
	
}
