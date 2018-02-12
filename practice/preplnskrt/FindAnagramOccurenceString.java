import java.util.LinkedHashMap;
import java.util.Map;

public class FindAnagramOccurenceString {

    public static void main(String[] args) {
        String longString = "BACDGABCDA";
        String pattern = "ABCD";
        printAnagramOccurence(pattern, longString);
    }

    private static void printAnagramOccurence(String pattern, String longString) {
        if (pattern == null || longString == null || pattern.isEmpty() || longString.isEmpty()
                || pattern.length() > longString.length()) {
            return;
        }

        Map<Character, Integer> patternMap = new LinkedHashMap<>();
        Map<Character, Integer> longStringMap = new LinkedHashMap<>();

        // initialized maps
        for (int i = 0; i < pattern.length(); i++) {
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
            longStringMap.put(longString.charAt(i), longStringMap.getOrDefault(longString.charAt(i), 0) + 1);
        }

        for (int i = pattern.length(); i < longString.length(); i++) {
            if (compare(patternMap, longStringMap)) {
                System.out.printf("Occurence found at index %d ", i - pattern.length());
            }

            longStringMap.put(longString.charAt(i),
                    longStringMap.getOrDefault(longString.charAt(i), 0) + 1);
            longStringMap.put(longString.charAt(i - pattern.length()),
                    longStringMap.getOrDefault(longString.charAt(i - pattern.length()), 0) - 1);
        }

        if (compare(patternMap, longStringMap)) {
            System.out.printf("Occurence found at index %d ", longString.length() - pattern.length());
        }
    }

    private static boolean compare(Map<Character, Integer> patternMap, Map<Character, Integer> longStringMap) {
        if (patternMap == null || longStringMap == null) {
            return false;
        }

        for (Character key : patternMap.keySet()) {
            if (!patternMap.get(key).equals(longStringMap.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }

}
