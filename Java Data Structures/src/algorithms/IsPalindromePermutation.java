package algorithms;

public class IsPalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPrimePermutation1("madam"));
        System.out.println(isPrimePermutation1("madamq"));
        System.out.println(isPrimePermutation2("madam"));
        System.out.println(isPrimePermutation2("madamq"));
    }

    private static boolean isPrimePermutation1(String string) {
        if (string == null) {
            return false;
        } else if (string.isEmpty()) {
            return true;
        }

        int[] frequencyMap = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : string.toCharArray()) {
            frequencyMap[c - 'a']++;
        }

        int oddCounter = 0;
        for (int i : frequencyMap) {
            if (i % 2 != 0) {
                oddCounter++;
            }
        }

        return oddCounter <= 1;
    }

    private static boolean isPrimePermutation2(String string) {
        if (string == null) {
            return false;
        } else if (string.isEmpty()) {
            return true;
        }

        int oddCounter = 0;
        int[] frequencyMap = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : string.toCharArray()) {
            frequencyMap[c - 'a']++;
            if (frequencyMap[c - 'a'] % 2 != 0) {
                oddCounter++;
            } else {
                oddCounter--;
            }
        }

        return oddCounter <= 1;
    }

}
