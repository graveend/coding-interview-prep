package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 *
 */
public class MinimumSwapBalancedString {
    public static int minSwaps(String s) {
        int size = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if( c == '[') {
                size++;
            } else {
                if(size > 0) {
                    size--;
                }
            }
        }
        return (size + 1)/2;
    }
}

class TestMinimumSwapBalancedString {
    @Test
    @DisplayName("Test positive scenario 1")
    public void testMinSwaps() {
        String input = "][][";
        int expected = 1;
        int output = MinimumSwapBalancedString.minSwaps(input);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Scenario likely to miss!!!")
    public void testMinSwaps1() {
        String input = "]]][[[";
        int expected = 2;
        int output = MinimumSwapBalancedString.minSwaps(input);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Empty string test")
    public void testMinSwapsWithEmptyString() {
        String input = "";
        int expected = 0;
        int output = MinimumSwapBalancedString.minSwaps(input);
        assertEquals(expected, output);
    }
}
