package amz.algos;

public class ReverseWordsSentence {

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello world"));
        System.out.println(reverseWords("Bye world"));
    }

    private static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        StringBuilder builder = new StringBuilder();
        for (String word : sentence.split(" ")) {
            builder.append(reverseWord(word)).append(" ");
        }
        builder.setLength(builder.length() - 1);
        return reverseWord(builder.toString());
    }

    private static String reverseWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }

}
