package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * HINT: Same as LongestCommonSubsequence
 */
public class DeleteOperationOfTwoStrings {
    public static int minDistance(String text1, String text2) {
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
        return (m+n) - 2* dp[m][n];
    }
}

class TestDeleteOperationOfTwoStrings {
    @Test
    public void testStringsToBeDeleted() {
        String text1 = "sea";
        String text2 = "eat";
        int expected = 2;
        int output = DeleteOperationOfTwoStrings.minDistance(text1,text2);
        assertEquals(expected, output);
    }

    @Test
    public void testStringsToBeDeleted1() {
        String text1 = "leetcode";
        String text2 = "etco";
        int expected = 4;
        int output = DeleteOperationOfTwoStrings.minDistance(text1,text2);
        assertEquals(expected, output);
    }
}
