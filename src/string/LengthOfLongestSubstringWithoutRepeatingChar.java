package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Hint: Sliding window
 */
public class LengthOfLongestSubstringWithoutRepeatingChar {

    /**
     * Create a map that holds visited character and its index.
     * Initialize left and right pointer
     * Iterate through each character and check if the charis already visited or not.
     * If it is visited then update the left pointer to the value in map + 1.
     * Calculate max length in each iteration.
     *
     * Time: O(n)
     * Space: O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while( j < s.length()) {
            /* map.get(s.charAt(j)) >= i --> Since we are not removing any character from the map,
            this check is required to see if the character is inside the sliding window*/
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i ) {
                i = map.get(s.charAt(j)) + 1;
                map.put(s.charAt(j), j);
            } else {
                map.put(s.charAt(j), j);
            }
            max = Math.max(max, (j - i) + 1);
            j++;
        }
        return max;
    }

}

class TestLengthOfLongestSubstringWithoutRepeatingChar {

    @Test
    @DisplayName("Positive scenario test case 1")
    public void testLLS() {
        String s = "abcabcbb";
        int expected = 3;
        int actual = LengthOfLongestSubstringWithoutRepeatingChar.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Positive scenario test case 2")
    public void testLLS1() {
        String s = "abcdbcbb";
        int expected = 4;
        int actual = LengthOfLongestSubstringWithoutRepeatingChar.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unique char")
    public void testUniqueLLS() {
        String s = "bbbb";
        int expected = 1;
        int actual = LengthOfLongestSubstringWithoutRepeatingChar.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test empty string")
    public void testEmptyLLS() {
        String s = "";
        int expected = 0;
        int actual = LengthOfLongestSubstringWithoutRepeatingChar.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

}
