package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/description/
 *
 * Solution: https://leetcode.com/problems/count-sorted-vowel-strings/solutions/918498/java-c-python-dp-o-1-time-space/
 */
public class CountSortedVowelString {
    public static int countVowelStrings(int n) {
        int[] dp = new int[]{0,1,1,1,1,1};
        int k = 5;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[5];
    }
}

class TestCountSortedVowelString {

    @Test
    public void testStringCount() {
        int n = 1;
        int expected = 5;
        int output = CountSortedVowelString.countVowelStrings(n);
        assertEquals(expected, output);
    }

    @Test
    public void testStringCount1() {
        int n = 2;
        int expected = 15;
        int output = CountSortedVowelString.countVowelStrings(n);
        assertEquals(expected, output);
    }
}
