package amz.algos;

public class MaxNonAdjacentSum {

    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(maxNonAdjacentSum(array));
    }

    private static int maxNonAdjacentSum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int include = array[0];  // include = sum including previous element
        int exclude = 0;         // exclude = sum excluding previous element
        int excludeNew;

        for (int i = 1; i < array.length; i++) {
            excludeNew = Math.max(include, exclude);

            include = exclude + array[i];
            exclude = excludeNew;
        }
        return Math.max(include, exclude);
    }

}
