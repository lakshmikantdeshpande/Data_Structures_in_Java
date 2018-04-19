package practice;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range {

    static String fixRange(int[] array) {
        StringBuilder output = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int i = 0;

        while (i < array.length) {
            if (stack.isEmpty() || array[i] - stack.peek() == 1) {
                stack.push(array[i]);
            } else {
                if (stack.size() >= 3) {
                    output.append(stack.get(0)).append('-').append(stack.peek()).append(',');
                } else {
                    for (Integer aStack : stack) {
                        output.append(aStack).append(',');
                    }
                }
                stack.clear();
                stack.push(array[i]);
            }
            ++i;
        }

        if (!stack.isEmpty()) {
            if (stack.size() >= 3) {
                output.append(stack.get(0)).append('-').append(stack.peek());
            } else {
                for (Integer aStack : stack) {
                    output.append(aStack).append(',');
                }
            }
        }

        String result = output.toString();
        if (result.endsWith(",")) {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }

    static String findPhoneNumber(String text) {
        String regex = "(\\d{3}-\\d{3}-\\d{4})|(\\(\\d{3}\\) \\d{3}-\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group() : "NONE";
    }

    static String deDuplicate(String inputStr, int chunkSize) {
        // Write your code here.
        StringBuilder output = new StringBuilder();
        String match = inputStr.substring(0, chunkSize);
        output.append(match);

        int i = 0;
        for (i = 0 + chunkSize; i < inputStr.length() - chunkSize + 1; i++) {
            String substr = inputStr.substring(i, i + chunkSize);
            if (match.equals(substr)) {
                output.append('*');
                i += chunkSize - 1;
            } else {
                output.append(inputStr.charAt(i));
            }
        }

        String result = output.toString();
        if (!result.endsWith("*")) {
            output.append(inputStr.substring(i, inputStr.length()));
            return output.toString();
        }
        return result;
    }


    static String duplicate(String deduplicatedStr, int chunkSize) {
        StringBuilder output = new StringBuilder();
        String match = deduplicatedStr.substring(0, chunkSize);
        for (char c : deduplicatedStr.toCharArray()) {
            if (c == '*') {
                output.append(match);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Range().fixRange(new int[]{12, 13, 14, 15}));
        System.out.println(new Range().fixRange(new int[]{12, 13}));

        System.out.println(findPhoneNumber("(000) 000-0000"));

        String input = "aaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbcccccccccc";
        String output = deDuplicate(input, 10);
        System.out.println(input.length());
        System.out.println(output.length());

        System.out.println(output);


        System.out.println(duplicate(output, 10).equals(input));
    }

}
