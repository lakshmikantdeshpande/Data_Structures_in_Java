package algorithms;

public class PrintAllCombinations {

    private static void printAllCombinations(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }
        for (int i = 0; i <= input.length(); i++) {
            combinations(input, i, "");
        }
    }

    private static void combinations(String input, int length, String prefix) {
        if (length == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < input.length(); i++) {
                String newPrefix = prefix + input.charAt(i);
                combinations(input, length - 1, newPrefix);
            }
        }
    }

    public static void main(String[] args) {
        printAllCombinations("ABC");
    }

}
