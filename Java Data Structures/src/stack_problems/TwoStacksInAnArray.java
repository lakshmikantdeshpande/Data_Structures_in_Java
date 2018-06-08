// 14. How will one implement 2 stacks using one array? 
// Stack shouldn't throw exception, unless every slot in the array gets used. 
// n time n space

package stack_problems;

public class TwoStacksInAnArray {
    private static int topA;
    private static int topB;
    private static int[] array;
    private int size;

    public TwoStacksInAnArray() throws Exception {
        this(10);
    }

    public TwoStacksInAnArray(int size) throws Exception {
        if (size <= 2)
            throw new Exception("Invalid size");

        this.size = size;
        array = new int[size];
        topA = -1;
        topB = size;
    }

    public static void main(String[] args) throws Exception {
        TwoStacksInAnArray tsa = new TwoStacksInAnArray(3);
        System.out.println(tsa.size(1));
        System.out.println(tsa.size(1));

        tsa.push(1, 2);
        tsa.push(2, 1);
        tsa.push(2, 3);
        tsa.pop(2);
        tsa.pop(2);
        tsa.pop(1);
        System.out.println(tsa);
    }

    public int pop(int id) throws Exception {
        if (isEmpty(id))
            throw new Exception("Underflow");

        if (id == 1) {
            int data = array[topA];
            array[topA--] = Integer.MIN_VALUE;
            return data;
        } else if (id == 2) {
            int data = array[topB];
            array[topB++] = Integer.MIN_VALUE;
            return data;
        } else
            throw new Exception("Invalid ID bruh !");
    }

    public void push(int id, int data) throws Exception {
        if (topA + 1 == topB)
            throw new Exception("Touched the array limit, sorry :( ");
        if (id == 1)
            array[++topA] = data;
        else if (id == 2)
            array[--topB] = data;
        else
            throw new Exception("Invalid ID bruh !");
    }

    public boolean isEmpty(int id) throws Exception {
        if (id == 1)
            return topA == -1;
        else if (id == 2)
            return topB == size;
        else
            throw new Exception("Invalid ID bruh !");
    }

    public int size(int id) throws Exception {
        if (id == 1)
            return topA + 1;
        else if (id == 2)
            return size - topB;
        else
            throw new Exception("Invalid ID bruh !");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n[ ");
        for (int x : array)
            stringBuilder.append(x + " ");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
