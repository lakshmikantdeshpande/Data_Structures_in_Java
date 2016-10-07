package linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {
	Node head;
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
		}
	}

	public static void main(String[] args) throws IOException
	{
		int choice;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			System.out.println("1.Create a linked list");
			System.out.println("2.Insert from the beginning");
			System.out.println("3.Insert at some position");
			System.out.println("4.Insert at the end");
			System.out.println("5.Display the linked list");
			System.out.println("6.Print length of the linked list");
			System.out.println("7.Delete from the front of the linked list");
			System.out.println("8.Delete from some position in the linked list");
			System.out.println("9.Delete from the end of the linked list");
			System.out.println("10.Quit");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				default:
					
			}
		}
	}
}
