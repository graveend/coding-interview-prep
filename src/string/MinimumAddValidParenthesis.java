package string;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 */
public class MinimumAddValidParenthesis {
    public static int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                right++;
            } else if(right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}

class TestMinimumAddValidParenthesis {
    @Test
    @DisplayName("Test positive scenario 1")
    public void testMinAddToMakeValid1() {
        String input = "())";
        int expected = 1;
        int output = MinimumAddValidParenthesis.minAddToMakeValid(input);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test positive scenario 2")
    public void testMinAddToMakeValid2() {
        String input = "()))((";
        int expected = 4;
        int output = MinimumAddValidParenthesis.minAddToMakeValid(input);
        assertEquals(expected, output);
    }
}
