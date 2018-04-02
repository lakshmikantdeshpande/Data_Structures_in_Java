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

    int binarySearchRecursive(int[] array, int left, int right, int number) {
        if (left < right) {
            int middle = (left + right) / 2;

            if (array[middle] == number) {
                return middle;
            } else if (array[middle] < number) {
                return binarySearchRecursive(array, middle + 1, right, number);
            } else {
                return binarySearchRecursive(array, left, middle - 1, number);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 8, 9, 10, 44, 456, 784, 56465};

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearchNonRecursive(array, 5));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, 5));
        System.out.println(binarySearch.binarySearchNonRecursive(array, -6));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, -6));
        System.out.println(binarySearch.binarySearchNonRecursive(array, 456));
        System.out.println(binarySearch.binarySearchRecursive(array, 0, array.length - 1, 456));

    }
}
