package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/maximal-square/description/
 */
public class MaximumSquare {
    public static int maximalSquare(char[][] matrix) {
        if( matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m+1][n+1];
        int ans = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i][j-1],
                            Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }

            }
        }
        return ans*ans;
    }
}

class TestMaximumSquare {
    @Test
    public void testSquares() {
        char[][] ch = new char[][]{{'0','1'},{'1','0'}};
        int expected = 1;
        int output = MaximumSquare.maximalSquare(ch);
        assertEquals(expected, output);
    }
}
