package practice;
import java.util.Arrays;


public class StackArray {
	private int capacity = 10;
	private int top;
	private int stack[];

	public StackArray(int capacity) {
		top = -1;
		this.capacity = capacity;
		stack = new int[this.capacity];
	}
	
	public int getSize() {
		return top + 1;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public void push(int data) {
		if (getSize() == capacity) {
			resize(capacity * 2);
		}
		stack[++top] = data;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Underflow");
		}
		if (getSize() == capacity / 4) {
			resize(capacity / 2);
		}
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return data;
	}

	private void resize(int newSize) {
		if (newSize <= 0) {
			newSize = 1;
		}
		System.out.println("Oops! Array needs to be resized to: " + newSize);
		capacity = newSize;
		int[] newStack = new int[capacity];
		System.arraycopy(stack, 0, newStack, 0, top + 1);
		stack = newStack;
	}

	public static void main(String[] args) throws Exception {
		StackArray stackArray = new StackArray(1);
		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				stackArray.push(5);
			} else {
				stackArray.pop();
			}
			System.out.println(stackArray.toString());
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(stack);
	}
}
