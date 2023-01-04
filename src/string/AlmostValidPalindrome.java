package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class AlmostValidPalindrome {

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while( i < j ) {
            if(s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i+1, j) || validPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean validPalindrome(String s, int i , int j) {
        while( i < j ) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

class TestAlmostValidPalindrome {
    @Test
    @DisplayName("Test positive scenario")
    public void testIsValidPalindrome() {
        String s = "aba";
        boolean expected = true;
        boolean actual = AlmostValidPalindrome.validPalindrome(s);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Test positive scenario")
    public void testIsValidPalindrome1() {
        String s = "abbda";
        boolean expected = true;
        boolean actual = AlmostValidPalindrome.validPalindrome(s);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Test negative scenario")
    public void testNotValidPalindrome() {
        String s = "abc";
        boolean expected = false;
        boolean actual = AlmostValidPalindrome.validPalindrome(s);
        assertEquals(actual, expected);
    }
}
