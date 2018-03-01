package algorithms;

public class URLify {

    public static void main(String[] args) {
        String a = "hello world ";
        System.out.println(urlify(a, 10));
    }

    private static String urlify(String a, int truelength) {
        if (a.isEmpty()) {
            return a;
        }

        char[] array = a.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < truelength; i++) {
            char c = array[i];
            if (c == ' ') {
                spaceCount++;
            }
        }

        final int length = a.length();
        if (truelength < length) {
            array[truelength] = '\0';
        }
        int index = truelength + spaceCount * 2;

        for (int i = truelength - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                array[index - 1] = '0';
                array[index - 2] = '2';
                array[index - 3] = '%';
                index -= 3;
            } else {
                array[index - 1] = array[i];
                index--;
            }
        }
        return String.valueOf(array);
    }

}
