package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/vowels-of-all-substrings/description/
 *
 * Example: abei
 *         Possible choices:
 *         a       b      e    i
 *         ab      be     ei
 *         abe     bei
 *         abei
 *
 *         a -> 4
 *         e -> 6
 *         i -> 4
 *
 *         0 <= i < n-1
 *
 *         [i+1] * [n - i] choices
 *                         where, i+1 => 0 ... i choices
 *                                n-i => i...n-1 choices
 */
public class VowelsOfAllSubString {
    public static long countVowels(String word) {
        long n = word.length();
        long res = 0;
        for(int i = 0; i < n; i++) {
            if("aeiou".indexOf(word.charAt(i)) >= 0) {
                res += (i+1) * (n-i);
            }
        }
        return res;
    }
}

class TestVowelsOfAllSubString {
    @Test
    public void testCountVowels() {
        String word = "aba";
        long expected = 6;
        long output = VowelsOfAllSubString.countVowels(word);
        assertEquals(expected, output);
    }

    @Test
    public void testCountVowels1() {
        String word = "abc";
        long expected = 3;
        long output = VowelsOfAllSubString.countVowels(word);
        assertEquals(expected, output);
    }
}
