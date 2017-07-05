// 8. Check if an array of characters is a palindrome. eg. abcdefGfedcba
// n time complexity 1 space

package stack_problems;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(new char[]{'a', 'a', 'c', 'a', 'a'}));
        System.out.println(isPalindrome(new char[]{'a', 'a', 'c', 'c', 'a', 'a'}));
    }

    public static boolean isPalindrome(char[] array) {
        if (array == null)
            return false;
        int i = 0, j = array.length - 1;
        while (i < j && array[i] == array[j]) {
            i++;
            j--;
        }
        if (i < j)
            return false;
        return true;
    }
}
