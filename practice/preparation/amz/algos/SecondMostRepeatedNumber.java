package amz.algos;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedNumber {

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "A", "A", "C"};
        System.out.println(secondMostRepeatedNumber(array));
    }

    private static String secondMostRepeatedNumber(String[] array) {
        if (array == null || array.length < 3) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : array) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int first = Integer.MIN_VALUE;
        String firstWord = null;
        int second = Integer.MIN_VALUE;
        String secondWord = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > first) {
                second = first;
                secondWord = firstWord;
                first = value;
                firstWord = key;
            } else if (!firstWord.equals(secondWord) && value > second) {
                second = value;
                secondWord = key;
            }
        }
        return secondWord;
    }

}
