package algorithms;

public class PrintAllPermutations {

    private static void printAllPermutations(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }
        permute(input, 0, input.length() - 1);
    }

    private static void permute(String input, int left, int right) {
        if (left == right) {
            System.out.println(input);
        } else {
            for (int i = left; i <= right; i++) {
                input = swap(input, left, i);
                permute(input, left + 1, right);
                input = swap(input, left, i);
            }
        }
    }

    private static String swap(String input, int left, int right) {
        char[] array = input.toCharArray();
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        printAllPermutations("ABC");
    }

}
