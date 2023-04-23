package dp.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 *
 * length(s) - lengthOfLongestPalindromicSubsequence
 */
public class MinimumInsertionToMakePalindrome {
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i+1][j+1] = s.charAt(i) == s.charAt(n-j-1) ? dp[i][j] + 1 : Math.max(dp[i][j+1] , dp[i+1][j]);
            }
        }
        return n - dp[n][n]; // 0 1 2
    }
}

class TestMinimumInsertionToMakePalindrome {
    @Test
    public void testMinInsertion() {
        String s = "mbadm";
        int expected = 2;
        int output = MinimumInsertionToMakePalindrome.minInsertions(s);
        assertEquals(expected, output);
    }

    @Test
    public void testMinInsertion1() {
        String s = "zzazz";
        int expected = 0;
        int output = MinimumInsertionToMakePalindrome.minInsertions(s);
        assertEquals(expected, output);
    }
}
