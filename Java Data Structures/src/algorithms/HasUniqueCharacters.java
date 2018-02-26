package algorithms;

public class HasUniqueCharacters {

    public static void main(String[] args) {
        String[] array = {"helloworld", "cat", "caat"};
        for (int i = 0; i < array.length; i++) {
            System.out.println(hasUniqueCharacters1(array[i]));
            System.out.println(hasUniqueCharacters2(array[i]));
        }
    }

    // n * n time 1 space
    private static boolean hasUniqueCharacters1(String one) {
        if (one == null) {
            return false;
        } else if (one.isEmpty()) {
            return true;
        }

        for (int i = 0; i < one.length() - 1; i++) {
            for (int j = i + 1; j < one.length(); j++) {
                if (one.charAt(i) == one.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // n time 1 space
    private static boolean hasUniqueCharacters2(String one) {
        if (one == null) {
            return false;
        } else if (one.isEmpty()) {
            return true;
        }

        boolean[] flag = new boolean[128];
        for (int i = 0; i < one.length(); i++) {
            int value = one.charAt(i);
            if (flag[value]) {
                return false;
            }
            flag[value] = true;
        }
        return true;
    }

}
