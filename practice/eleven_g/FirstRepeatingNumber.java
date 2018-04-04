import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeatingNumber {

    // n * n time 1 space
    int findFirstRepeatingNumber(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Empty / null array");
        }

        boolean firstRepeated = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    firstRepeated = true;
                }
            }
            if (firstRepeated) {
                return array[i];
            }
        }
        throw new RuntimeException("All numbers appear unique");
    }

    // N time N space
    int findFirstRepeatingNumberFaster(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int number : array) {
            if (!set.add(number)) {
                return number;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstRepeatingNumber frn = new FirstRepeatingNumber();
        int[] array = new int[]{1, 2, 3, 4, 5, 1, 3, 5, 7, 8};
        System.out.println(frn.findFirstRepeatingNumber(array));
        System.out.println(frn.findFirstRepeatingNumberFaster(array));

        array = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10};
        System.out.println(frn.findFirstRepeatingNumber(array));
        System.out.println(frn.findFirstRepeatingNumberFaster(array));
    }

}
