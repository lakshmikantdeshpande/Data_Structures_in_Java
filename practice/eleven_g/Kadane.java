public class Kadane {

    public static void main(String[] args) {
        System.out.println(printMaximumSubarray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    private static int printMaximumSubarray(int[] array) {
        int current = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            current = Math.max(array[i], current + array[i]);
            max = Math.max(current, max);
        }
        return max;
    }

}
