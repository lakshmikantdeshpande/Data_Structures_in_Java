package linked_list;

public class DoublyLinkedList {
	int length;
	private Node head;
		
	class Node
	{
		int data;
		Node next;
		Node prev;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	// initialize the linked list
	public DoublyLinkedList() {
		head = null;
		length = 0;
	}

	// print the length of the linked list
	public int ListLength()
	{
		return this.length;
//		int len = 0;
//		Dnode temp = head;
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
	
	public synchronized void reversePrint()
	{
		Node temp = head;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		while (temp != null)
		{
			System.out.print(temp.data + " <- ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public synchronized void insertAtTheBeginning(int data)
	{
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
		if (oldHead != null)
			oldHead.prev = head;
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
		newnode.prev = temp;
		length++;
	}
	
	public synchronized void insertAtThePosition(int position, int data) throws Exception
	{
		if (position < 0) position = 0;
		if (position > length) position = length;
		if (position == 0) { insertAtTheBeginning(data); return; }
		
		Node p = head, q = null;
		Node newNode = new Node(data);

		for(int i = 1; i < position; i++)
		{
			q = p;
			p = p.next;
		}
		if (p != null)
		{
			newNode.next = q.next;
			newNode.prev = q;
			p.prev = newNode; 
			q.next = newNode;
		}
		else
		{
			q.next = newNode;
			newNode.prev = q;
		}
		length++;
	}
	
	public synchronized void deleteFromTheBeginning()
	{
		Node temp = head;
		if (head!= null)
		{
			head = temp.next;
			head.prev = null;
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
		if (p != null)
		{
			q.next = p.next;
			p = null;
			q.next.prev = null;
		}
		length--;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		DoublyLinkedList dld = new DoublyLinkedList();
		// dld.head = new Node(0);
		// dld.ListLength();
		
		dld.insertAtTheBeginning(3);
		dld.insertAtTheBeginning(2);
		dld.insertAtTheBeginning(1);
		dld.insertAtTheEnd(4);
		
//		dld.insertAtThePosition(0, 5);
//		dld.deleteFromTheBeginning();
//		dld.deleteFromTheEnd();
//		dld.deleteFromTheEnd();
//		dld.deleteFromTheEnd();
//		dld.deleteFromThePosition(1);
		
		dld.reversePrint();		
		dld.printLinkedList();
	}
}
