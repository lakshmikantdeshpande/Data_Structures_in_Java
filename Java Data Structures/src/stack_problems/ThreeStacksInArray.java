// 15. Implement three stacks in an array
// n time n size

package stack_problems;

public class ThreeStacksInArray {
	private int[] array;
	private int size, topOne, topTwo, topThree, baseThree;

	public ThreeStacksInArray(int size) throws Exception {
		if (size < 3)
			throw new Exception("Size should be at least 3");

		this.size = size;
		array = new int[size];
		java.util.Arrays.fill(array, Integer.MIN_VALUE);
		topOne = -1;
		topTwo = size;
		baseThree = size / 2;
		topThree = baseThree;
	}

	public ThreeStacksInArray() throws Exception {
		this(10);
	}

	/*
	 * |---> |---> <---| topOne baseThree & topThree topTwo
	 */

	public void push(int stackID, int data) throws Exception {
		if (stackID == 1) {
			if (topOne + 1 == baseThree) {
				if (isMiddleStackRightShiftable()) {
					shiftMiddleStackToRight();
					array[++topOne] = data;
				} else
					throw new Exception("Stack 1 is full!");
			} else
				array[++topOne] = data;
		} else if (stackID == 2) {
			if (topTwo - 1 == topThree) {
				if (isMiddleStackLeftShiftable()) {
					shiftMiddleStackToLeft();
					array[--topTwo] = data;
				} else
					throw new Exception("Stack 2 is full!");
			} else
				array[--topTwo] = data;
		} else if (stackID == 3) {
			if (topTwo - 1 == topThree) {
				if (isMiddleStackLeftShiftable()) {
					shiftMiddleStackToLeft();
					array[++topThree] = data;
				} else
					throw new Exception("Stack 3 is full!");
			} else
				array[++topThree] = data;
		} else
			return;
	}

	public int pop(int stackID) throws Exception {
		if (stackID == 1) {
			if (topOne == -1)
				throw new Exception("Stack 1 is empty!");
			int value = array[topOne];
			array[topOne--] = Integer.MIN_VALUE;
			return value;
		} else if (stackID == 2) {
			if (topTwo == this.size)
				throw new Exception("Stack 2 is empty!");
			int value = array[topTwo];
			array[topTwo++] = Integer.MIN_VALUE;
			return value;
		} else if (stackID == 3) {
			if (topThree == baseThree)
				throw new Exception("Stack 3 is empty!");
			int value = array[topThree];
			array[topThree--] = Integer.MIN_VALUE;
			return value;
		} else
			return Integer.MIN_VALUE;
	}

	public int peek(int stackID) throws Exception {
		if (stackID == 1) {
			if (topOne == -1)
				throw new Exception("Stack 1 is empty!");
			return array[topOne];
		} else if (stackID == 2) {
			if (topTwo == this.size)
				throw new Exception("Stack 2 is empty!");
			return array[topTwo];
		} else if (stackID == 3) {
			if (topThree == baseThree)
				throw new Exception("Stack 3 is empty!");
			return array[topThree];
		} else
			return Integer.MIN_VALUE;
	}

	public boolean isEmpty(int stackID) {
		switch (stackID) {
		case 1:
			return topOne == -1;
		case 2:
			return topTwo == this.size;
		case 3:
			return (topThree == baseThree);
		default:
			return true;
		}
	}

	public void shiftMiddleStackToRight() {
		for (int i = topThree; i >= baseThree + 1; i--)
			array[i + 1] = array[i];
		array[baseThree++] = Integer.MIN_VALUE;
		topThree++;
	}

	public void shiftMiddleStackToLeft() {
		for (int i = baseThree + 1; i <= topThree; i++)
			array[i] = array[i + 1];
		array[topThree--] = Integer.MIN_VALUE;
		baseThree--;
	}

	private boolean isMiddleStackLeftShiftable() {
		return topOne + 1 < baseThree;
	}

	private boolean isMiddleStackRightShiftable() {
		return topThree + 1 < topTwo;
	}

	public static void main(String args[]) throws Exception {
		ThreeStacksInArray tsia = new ThreeStacksInArray();
		tsia.push(3, 1);
		tsia.push(3, 1);
		tsia.push(3, 1);
		tsia.push(3, 1);
		tsia.push(3, 1);
		tsia.push(3, 1);
	}
}
