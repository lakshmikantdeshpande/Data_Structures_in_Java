public class BinarySearch {

    int binarySearchNonRecursive(final int[] array, final int number) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] == number) {
                return middle;
            } else if (array[middle] < number) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return -1;
    }

}
