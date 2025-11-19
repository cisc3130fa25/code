package B_recursion;

public class Palindrome {
    static void main() {
        IO.println(isPalindrome("racecar"));
        IO.println(isPalindrome("abcdba"));

        IO.println(isPalindromeMoreEfficient("racecar"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            String middle = s.substring(1, s.length() - 1);
            return s.charAt(0) == s.charAt(s.length() - 1)
                    && isPalindrome(middle);
        }
    }

    // isPalindrome("abcba")
    // isPalindrome("bcb")
    // isPalindrome("c")

    // wrapper method
    public static boolean isPalindromeMoreEfficient(String s) {
        return isPalindromeMoreEfficient(s, 0, s.length() - 1);
    }

    // isPalindromeMoreEfficient("abcba", 0, 4)
    // isPalindromeMoreEfficient("abcba", 1, 3)
    // isPalindromeMoreEfficient("abcba", 2, 2)

    // Determines whether the characters in s from
    // startIndex through endIndex form a palindrome.
    // more efficient since we don't create new Strings (with substring method)
    private static boolean isPalindromeMoreEfficient(String s,
                                                     int startIndex,
                                                     int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        } else {
            return s.charAt(startIndex) == s.charAt(endIndex)
                    && isPalindromeMoreEfficient(s, startIndex + 1, endIndex - 1);
        }
    }
}
