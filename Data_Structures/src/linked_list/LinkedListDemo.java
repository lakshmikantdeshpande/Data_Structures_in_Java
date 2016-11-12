package linked_list;

class Node
{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedListDemo
{
	int length;
	private Node head;
		
	// initialize the linked list
	public LinkedListDemo() {
		head = null;
		length = 0;
	}

	// print the length of the linked list
	public int ListLength()
	{
		return this.length;
//		int len = 0;
//		Node temp = head;
//		while (temp != null) {
//			temp = temp.next;
//			len++;
//		}
//		System.out.println("Length of the linked list: " + len);
//		return len;
	}
	
	// print the linked list
	public void printLinkedList()
	{
		if (head == null) return;
		System.out.println("Linked list: ");
		
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
	
	public synchronized void insertAtTheBeginning(int data)
	{
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
		length++;
	}
	
	public synchronized void insertAtTheEnd(int data)
	{
		if (head == null)
		{
			insertAtTheBeginning(data);
			return;
		}
		
		Node temp = head; 
		Node newnode = new Node(data);
		
		while (temp.next != null)      // go to the end of the linked list
			temp = temp.next;
		temp.next = newnode;
		length++;
	}
	
	public synchronized void insertAtThePosition(int position, int data) throws Exception
	{
		if (position < 0) position = 0;
		if (position > length) position = length;
		if (position == 0) { insertAtTheBeginning(data); return; }
		
		Node temp = head;
		Node newNode = new Node(data);

		for(int i = 1; i < position; i++)
		{
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
	}
	
	public synchronized void deleteFromTheBeginning()
	{
		Node temp = head;
		if (head!= null)
		{
			head = temp.next;
			temp = null;
		}
		length--;
	}
	
	public synchronized void deleteFromTheEnd()
	{
		if (head == null) return;
		if (head.next == null){ head = null; return; }
		Node p = head, q = null;
		while (p.next != null)
		{
			q = p;
			p = p.next;
		}
		p = null; 
		q.next = null;  // to prevent loitering
		length--;
	}
	
	public synchronized void deleteFromThePosition(int position)
	{
		if (position < 0) position = 0;
		if (head == null) return;
		if (position >= length) return;
		if (position == 0) { deleteFromTheBeginning(); return;}
		
		Node p = head, q = null;
		int k = 0;
		while (p.next != null && k < position)
		{
			q = p;
			p = p.next;
			k++;
		}
		q.next = p.next;
		p = null;
		length--;
	}
	
	public static void main(String args[]) throws Exception
	{
		LinkedListDemo lld = new LinkedListDemo();
		// lld.head = new Node(0);
		// lld.ListLength();
		
		lld.insertAtTheBeginning(3);
		lld.insertAtTheBeginning(2);
		lld.insertAtTheBeginning(1);
		lld.insertAtTheEnd(4);
		
		lld.insertAtThePosition(0, 5);
		lld.deleteFromTheBeginning();
		lld.deleteFromTheEnd();
		lld.deleteFromTheEnd();
		lld.deleteFromTheEnd();
		lld.deleteFromThePosition(1);
		
		lld.printLinkedList();
	}
}
