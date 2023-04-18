package dp.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Q: https://leetcode.com/problems/domino-and-tromino-tiling/description/
 *
 *         1, 1, 2, 5, 11, 24, 53, 117, 258, 569, 1255
 *
 *         dp[n]=   dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
 *              =   dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
 *              =   dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
 *              =   dp[n-1]+dp[n-3]+dp[n-1]
 *              =   2*dp[n-1]+dp[n-3]
 *         DP[N] = DP[N-1] * 2 + DP[N-3];
 */
public class DominoAndTrominoTiling {
    public static int numTilings(int n) {
        long[] dp = new long[n + 3];
        dp[0] = 1; dp[1] = 2; dp[2] = 5;
        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }
}

class TestDominoAndTrominoTiling {
    @Test
    public void testTiling() {
        int n = 1;
        int expected = 1;
        int output = DominoAndTrominoTiling.numTilings(n);
        assertEquals(expected, output);
    }

    @Test
    public void testTiling1() {
        int n = 4;
        int expected = 11;
        int output = DominoAndTrominoTiling.numTilings(n);
        assertEquals(expected, output);
    }
}
