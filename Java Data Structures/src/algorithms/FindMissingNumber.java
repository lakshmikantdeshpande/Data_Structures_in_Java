package algorithms;

public class FindMissingNumber {

    public static void main(String[] args) {
        System.out.println(findMissingNumber1(new int[]{1, 2, 3, 4, 5, 6, 7, 9, 10}));
        System.out.println(findMissingNumber2(new int[]{1, 2, 3, 4, 5, 6, 7, 9, 10}));
    }

    // O(n).. can cause integer overflow
    private static int findMissingNumber1(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int n = array.length;
        long sum = ((n + 1) * (n + 2)) / 2;
        for (int number : array) {
            sum -= number;
        }
        return (int) (sum);
    }

    private static int findMissingNumber2(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int expectedXor = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            expectedXor ^= i;
        }

        int xor = 0;
        for (int number : array) {
            xor ^= number;
        }

        return xor ^ expectedXor;
    }

}
