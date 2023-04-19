package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }
}

class TestLongestCommonSubsequence {
    @Test
    public void testLengthOfSubSequence() {
        String test1 = "abcde";
        String test2 = "abe";
        int expected = 3;
        int output = LongestCommonSubsequence.longestCommonSubsequence(test2, test1);
        assertEquals(expected, output);
    }

    @Test
    public void testLengthOfSubSequence1() {
        String test1 = "abcde";
        String test2 = "bbe";
        int expected = 2;
        int output = LongestCommonSubsequence.longestCommonSubsequence(test2, test1);
        assertEquals(expected, output);
    }
}
