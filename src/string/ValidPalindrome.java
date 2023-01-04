package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0, j = s.length() - 1;
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

class TestValidPalindrome {
    @Test
    @DisplayName("Test positive scenario")
    public void testIsValidPalindrome() {
        String input = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean actual = ValidPalindrome.isPalindrome(input);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Test negative test case")
    public void testNonValidPalindrome() {
        String input = "race a car";
        boolean expected = false;
        boolean actual = ValidPalindrome.isPalindrome(input);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Test empty")
    public void testEmptyValidPalindrome() {
        String input = " ";
        boolean expected = true;
        boolean actual = ValidPalindrome.isPalindrome(input);
        assertEquals(actual, expected);
    }
}
