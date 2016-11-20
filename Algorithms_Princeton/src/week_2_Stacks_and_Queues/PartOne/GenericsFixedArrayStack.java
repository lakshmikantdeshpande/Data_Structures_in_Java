package week_2_Stacks_and_Queues.PartOne;

public class GenericsFixedArrayStack<Item> {
	Item stack[];
	int top = 0;

	GenericsFixedArrayStack(int capacity) {
		// Not a good coding practice
		stack = (Item[]) new Object[capacity];
	}

	public static void main(String args[]) {
		GenericsFixedArrayStack gs = new GenericsFixedArrayStack(5);
		System.out.println(gs.isEmpty());
		// pushing three different datatypes
		gs.push(1);
		gs.push("Two");
		gs.push('3');
		System.out.println(gs.pop());
		System.out.println(gs.pop());
		System.out.println(gs.pop());
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public void push(Item item) {
		stack[++top] = item;
	}

	public Item pop() {
		Item item = stack[top];
		stack[top--] = null;
		return item;
	}
}
