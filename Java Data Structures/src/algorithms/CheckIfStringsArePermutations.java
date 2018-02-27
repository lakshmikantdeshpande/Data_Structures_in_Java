package algorithms;

import java.util.Arrays;

public class CheckIfStringsArePermutations {

    public static void main(String[] args) {
        String a = "hello";
        String b = "lohel";
        System.out.println(arePermutations1(a, b));
        System.out.println(arePermutations2(a, b));
        a = "l";
        System.out.println(arePermutations1(a, b));
        System.out.println(arePermutations2(a, b));
    }

    // n log n + m logn time m + n space
    private static boolean arePermutations1(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }

        return sort(a).equals(sort(b));
    }

    private static String sort(String string) {
        if (string == null) {
            throw new RuntimeException("String is null");
        }

        char[] array = string.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

    // M + N time 1 space
    private static boolean arePermutations2(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }

        int[] flag = new int[128];

        for (char c : a.toCharArray()) {
            flag[c]++;
        }

        for (char c : b.toCharArray()) {
            flag[c]--;
            if (flag[c] < 0) {
                return false;
            }
        }
        return true;
    }

}

