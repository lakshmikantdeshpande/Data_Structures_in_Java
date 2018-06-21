package amz.algos;

public class ReverseIndividualWords {

    public static void main(String[] args) {
        String helloWorld = "Hello World";
        System.out.println(reverseIndividualWords(helloWorld));
    }

    // N time N space
    private static String reverseIndividualWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : sentence.split(" ")) {
            stringBuilder.append(reverseWord(word)).append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // Not using Stringbuilder's method
    private static String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            stringBuilder.append(word.charAt(i));
        }
        return stringBuilder.toString();
    }

}
